library(metaRNASeq)
library(DESeq2)
data(param)
dim(param)
data(dispFuncs)
set.seed(123)
matsim <- sim.function(param = param, dispFuncs = dispFuncs)
sim.conds <- colnames(matsim)
rownames(matsim) <- paste("tag", 1:dim(matsim)[1],sep="")
simstudy1 <- extractfromsim(matsim,"study1")
simstudy2<-extractfromsim(matsim,"study2")
dds1 <- DESeqDataSetFromMatrix(countData = simstudy1$study,
+ colData = simstudy1$pheno,design = ~ condition)
res1 <- results(DESeq(dds1))
dds2 <- DESeqDataSetFromMatrix(countData = simstudy2$study,
+ colData = simstudy2$pheno,design = ~ condition)
res2 <- results(DESeq(dds2))
rawpval <- list("pval1"=res1[["pvalue"]],"pval2"=res2[["pvalue"]])
FC <- list("FC1"=res1[["log2FoldChange"]],"FC2"=res2[["log2FoldChange"]])
adjpval <- list("adjpval1"=res1[["padj"]],"adjpval2"=res2[["padj"]])
DE <- mapply(adjpval, FUN=function(x) ifelse(x <= 0.05, 1, 0))
colnames(DE)=c("DEstudy1","DEstudy2")
library(DESeq)
resDESeq1study <- function(studyname, alldata, cond1totest="cond1",
 cond2totest="cond2", fitType = "parametric") {
 study <- alldata[,grep(studyname,colnames(alldata))]
 studyconds <- gsub(studyname,"",colnames(study))
 colnames(study) <- paste(studyconds,1:dim(study)[2],sep=".")
 cds <- newCountDataSet(study, studyconds)
 cds <- estimateSizeFactors(cds)
 cds <- estimateDispersions(cds, method="pooled", fitType=fitType)
 filter <- HTSFilter(cds, plot=FALSE)
 cds.filter <- filter$filteredData
 on.index <- which(filter$on == 1)
 cat("# genes passing filter", studyname, ":", dim(cds.filter)[1], "\n")
 res <- as.data.frame(matrix(NA, nrow = nrow(cds), ncol=ncol(cds)))
 nbT <- nbinomTest(cds.filter, cond1totest, cond2totest)
 colnames(res) <- colnames(nbT)
 res[on.index,] <- nbT
 res
 }
studies <- c("study1", "study2")
resDESeq <- lapply(studies,
+ FUN=function(x) resDESeq1study(x, alldata=matsim))
library(HTSFilter)
resDESeq <- lapply(studies,
+ FUN=function(x) resDESeq1study(x, alldata=matsim))
adjpval <- lapply(resDESeq, FUN=function(res) res$padj)
DE <- mapply(adjpval, FUN=function(x) ifelse(x <= 0.05, 1, 0))
colnames(DE)=paste("DE",studies,sep=".")

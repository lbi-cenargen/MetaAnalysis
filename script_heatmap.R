library(gplots)
library(RColorBrewer)
input<-read.table("input_file.txt",header=TRUE)
input_new<-as.matrix(input[,2:4])
rownames<-input[,1]
heatmap.2( input_new,
           col = colorpanel(100,"green","grey78","red"),
           trace = "none", 
           xlab = "",
           scale = c("none"),
           symbreaks = min(input_new, na.rm=TRUE),
           cexRow = 0.5, cexCol = 0.7,
           main = "",
           labRow = rownames, Rowv = TRUE, Colv = TRUE, dendrogram = "both")
          


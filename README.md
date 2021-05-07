# MetaAnalysis
This README describes the meta-analysis used in the paper "Defining the combined stress response in wild *Arachis*" (Mota et al., 2021)

All the libraries used in this analysis are publicy available at [ncbi](https://www.ncbi.nlm.nih.gov/bioproject/?term=PRJNA284674).

---
## Data processing 
---
Two separate analyses were performed, for abiotic and biotic libraries. 
The first step consists of retrieving the data from the differential expression analysis and building a table for comparison (CTRL x Stressed) with the information below:

Gene | Log2FoldChange | pval | padj

All the libraries must have the same number of lines, and the files can be prepared using the script CreateCommomGenesTables.java

Below the example of an input file: 

Gene | Log2FoldChange | pval | padj
------------ | ------------- | ------------- | -------------
"Aradu.000JC" | 0.303489806396251 | 0.195741894512141 | 0.326509606375421|
"Aradu.001N3" | -2.96244392768886 | 3.57502584689713e-37 | 6.9031995153895e-36

---
## Meta-analysis
---

The R package MetaRNASeq was used to perform the meta-analysis and whole script is described in the metaAnalysis.R file. 

The resulting tables from the abiotic and the biotic analysis were used as input files for further analysis in the paper.

Create two directories for each analysis

```
$ mkdir abiotic
$ mkdir biotic
```
From the results of the Differential expression analysis, print only the columns of Gene name, Log2FoldChange, p-value and FDR, for each treatment

```
$ awk -F"\t" '{print $1 "\t" $2 "\t" $4 "\t" $5}' result_edgeR.txt > resEdgeR_treatment.txt
```
Count the total of unique genes present in all libraries 
```
$ cat *result_edgeR.txt|awk '{print $1}'|sort -u > list_genes.txt
$ awk '{print NR "\t" $0}' list_genes.txt > numbered_list_genes.txt
```
The result is the number of unique genes present in all the treatments. 

Run the script CreateCommonGenesTables.java to complete each table with all the genes found in all analysis

```
$ javac CreateCommomGenesTables.java
$ java CreateCommomGenesTables
```

Using R execute the script metaAnalysis.R

Below an example of metaAnalysis result:

Gene_model | "DE.DDHI" | "DE.DDD" | "DE.SDHI" | "DE.SDD" | "DE.fishercomb" | "X1" | "X2"| "X3" | "X4" | "signFC" | "DE"
------------ | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------
"51" | 0 | 0 | 0 | 1 | 1 | -0.151094515316481 | -0.548527912447952 | -0.220747575674181 | -1.29157607217008 | -1 | FALSE|
"60" | 1 | 1 | 0 | 1 | 1 | -2.64431233840503 | -8.91671418450554 | -1.22144069268159 | -2.75685967515926 | -1 | FALSE

Retrieve gene identity from the numbered_list_genes.txt from the input file:

```
$ awk '{print $1}' result_meta_analysis.txt > to_retrive_numbers.txt
$ grep -f to_retrieve_numbers.txt numbered_list_genes.txt > genes_from_meta.txt
$ awk -f merge_files.awk genes_from_meta.txt result_meta_analysis.txt > final_result_with_gene_models.txt
```


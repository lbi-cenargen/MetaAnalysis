# MetaAnalysis
This README describe the meta-analysis used in the paper "Defining the combined stress response in wild *Arachis*" (Mota et al., 2021)

All the libraries used in this analysis are publicy available in [ncbi](https://www.ncbi.nlm.nih.gov/bioproject/?term=PRJNA284674).

---
## Data processing 
---
Two separated analyses were performed, for abiotic and biotic libraries. 
The first step is retrieve the data from the differential expression analysis and provide a table for comparison (CTRL x Stressed) with the information of 

Gene | Log2FoldChange | pval | padj

All the libraries need to have the same number of lines, these files can be prepared using the script CreateCommomGenesTables.java

An example of input below: 

c
------------ | ------------- | ------------- | -------------
"Aradu.000JC" | 0.303489806396251 | 0.195741894512141 | 0.326509606375421|
"Aradu.001N3" | -2.96244392768886 | 3.57502584689713e-37 | 6.9031995153895e-36

---
## Meta-analysis
---

The R package MetaRNASeq was used to performe the meta-analysis and whole script is described in the metaAnalysis.R file. 

The resulting table from the abiotic and the biotic analysis was used as input for the further analysis of the paper.



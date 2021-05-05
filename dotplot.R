library(ggplot2)
x<-read.table("input_file.txt", header=TRUE)
x$Code<-as.factor(x$Code)
head(x[,c("Gene","Value","Code")],3)
y<-ggplot(x,aes(x=Gene,y=Value))
y+geom_point()
y+geom_point(aes(color=Code))+
  scale_fill_manual(values = c("#00AFBB", "#E7B800", "#d68deb"))
theme_bw()+
  theme(axis.text.x = element_blank())

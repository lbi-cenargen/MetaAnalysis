import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class CreateCommomGenesTables { 

    public static void main(String args[]) throws Exception{
    
		TreeSet<String> mapGlobal = new TreeSet<String>();
		TreeMap<String, String> mapDN3 = new TreeMap<String, String>();
		TreeMap<String, String> mapDN6 = new TreeMap<String, String>();
		TreeMap<String, String> mapDN9 = new TreeMap<String, String>();
		TreeMap<String, String> mapSN3 = new TreeMap<String, String>();
		TreeMap<String, String> mapSN6 = new TreeMap<String, String>();
		TreeMap<String, String> mapSN9 = new TreeMap<String, String>();


		File fileAduranensis_nema_3DAI = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/biotic/resEdgeR_Aduranensis_nema_3DAI.txt");
		File fileAduranensis_nema_6DAI = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/biotic/resEdgeR_Aduranensis_nema_6DAI.txt");
		File fileAduranensis_nema_9DAI = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/biotic/resEdgeR_Aduranensis_nema_9DAI.txt");
		File fileAstenosperma_nema_3DAI = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/biotic/resEdgeR_Astenosperma_nema_3DAI.txt");
		File fileAstenosperma_nema_6DAI = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/biotic/resEdgeR_Astenosperma_nema_6DAI.txt");
		File fileAstenosperma_nema_9DAI = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/biotic/resEdgeR_Astenosperma_nema_9DAI.txt");
		
		
		File fileAduranensis_nema_3DAI_completos = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/teste/resEdgeR_Aduranensis_nema_3DAI_completos.txt");
		File fileAduranensis_nema_6DAI_completos = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/teste/resEdgeR_Aduranensis_nema_6DAI_completos.txt");
       		File fileAduranensis_nema_9DAI_completos = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/teste/resEdgeR_Aduranensis_nema_9DAI_completos.txt");
	        File fileAstenosperma_nema_3DAI_completos = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/teste/resEdgeR_Astenosperma_nema_3DAI_completos.txt");
		File fileAstenosperma_nema_6DAI_completos = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/teste/resEdgeR_Astenosperma_nema_6DAI_completos.txt");
		File fileAstenosperma_nema_9DAI_completos = new File("/work/acgt/anazotta/Documents/cross_stress_2019/meta_analysis/Jan_2020/teste/resEdgeR_Astenosperma_nema_9DAI_completos.txt");

//Read
        BufferedReader readerAduranensis_nema_3DAI = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(fileAduranensis_nema_3DAI)));

		BufferedReader readerAduranensis_nema_6DAI = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(fileAduranensis_nema_6DAI)));

		BufferedReader readerAduranensis_nema_9DAI = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(fileAduranensis_nema_9DAI)));

                BufferedReader readerAstenosperma_nema_3DAI = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(fileAstenosperma_nema_3DAI)));

		BufferedReader readerAstenosperma_nema_6DAI = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(fileAstenosperma_nema_6DAI)));

                BufferedReader readerAstenosperma_nema_9DAI = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(fileAstenosperma_nema_9DAI)));


//Write
		BufferedWriter writer_DN3 = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(fileAduranensis_nema_3DAI_completos)));

		BufferedWriter writer_DN6 = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(fileAduranensis_nema_6DAI_completos)));
		
		BufferedWriter writer_DN9 = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(fileAduranensis_nema_9DAI_completos)));

		BufferedWriter writer_SN3 = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(fileAstenosperma_nema_3DAI_completos)));

		BufferedWriter writer_SN6 = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(fileAstenosperma_nema_6DAI_completos)));

		BufferedWriter writer_SN9 = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(fileAstenosperma_nema_9DAI_completos)));


//

		String linha; 
		linha = readerAduranensis_nema_3DAI.readLine();
		while ( (linha = readerAduranensis_nema_3DAI.readLine()) != null ) {
			StringTokenizer linha_tk = new StringTokenizer(linha, "\t");
			String geneId = linha_tk.nextToken();
			mapDN3.put(geneId, linha);
			mapGlobal.add(geneId);
        }
        readerAduranensis_nema_3DAI.close();

        	while ( (linha = readerAduranensis_nema_6DAI.readLine()) != null ) {
			StringTokenizer linha_tk = new StringTokenizer(linha, "\t");
			String geneId = linha_tk.nextToken();
			mapDN6.put(geneId, linha);
			mapGlobal.add(geneId);
        }
        readerAduranensis_nema_6DAI.close();

		while ( (linha = readerAduranensis_nema_9DAI.readLine()) != null ) {
                        StringTokenizer linha_tk = new StringTokenizer(linha, "\t");
                        String geneId = linha_tk.nextToken();
                        mapDN9.put(geneId, linha);
                        mapGlobal.add(geneId);
        }
        readerAduranensis_nema_9DAI.close();

		while ( (linha = readerAstenosperma_nema_3DAI.readLine()) != null ) {
                        StringTokenizer linha_tk = new StringTokenizer(linha, "\t");
                        String geneId = linha_tk.nextToken();
                        mapSN3.put(geneId, linha);
                        mapGlobal.add(geneId);
        }
        readerAstenosperma_nema_3DAI.close();

		while ( (linha = readerAstenosperma_nema_6DAI.readLine()) != null ) {
                        StringTokenizer linha_tk = new StringTokenizer(linha, "\t");
                        String geneId = linha_tk.nextToken();
                        mapSN6.put(geneId, linha);
                        mapGlobal.add(geneId);
        }
        readerAstenosperma_nema_6DAI.close();
		
		while ( (linha = readerAstenosperma_nema_9DAI.readLine()) != null ) {
                        StringTokenizer linha_tk = new StringTokenizer(linha, "\t");
                        String geneId = linha_tk.nextToken();
                        mapSN9.put(geneId, linha);
                        mapGlobal.add(geneId);
        }
        readerAstenosperma_nema_9DAI.close();


//

        writer_DN3.write("Gene\tlogFC\tPValue\tBH_FDR\n");
        writer_DN6.write("Gene\tlogFC\tPValue\tBH_FDR\n");
        writer_DN9.write("Gene\tlogFC\tPValue\tBH_FDR\n");
	writer_SN3.write("Gene\tlogFC\tPValue\tBH_FDR\n");
	writer_SN6.write("Gene\tlogFC\tPValue\tBH_FDR\n");
	writer_SN9.write("Gene\tlogFC\tPValue\tBH_FDR\n");

	Iterator<String> mapGlobal_it = mapGlobal.iterator();
        while (mapGlobal_it.hasNext()) {
			String geneIdGlobal = mapGlobal_it.next();
			if (mapDN3.containsKey(geneIdGlobal)) {
				String tabela = mapDN3.get(geneIdGlobal);
				writer_DN3.write(tabela + "\n");
			} else {
				writer_DN3.write(geneIdGlobal + "\tNA\tNA\tNA\n");
			}


			if (mapDN6.containsKey(geneIdGlobal)) {
				String tabela = mapDN6.get(geneIdGlobal);
				writer_DN6.write(tabela + "\n");
			} else {
				writer_DN6.write(geneIdGlobal + "\tNA\tNA\tNA\n");
			}

			if (mapDN9.containsKey(geneIdGlobal)) {
                                String tabela = mapDN9.get(geneIdGlobal);
                                writer_DN9.write(tabela + "\n");
                        } else {
                                writer_DN9.write(geneIdGlobal + "\tNA\tNA\tNA\n");
                        }

			if (mapSN3.containsKey(geneIdGlobal)) {
                                String tabela = mapSN3.get(geneIdGlobal);
                                writer_SN3.write(tabela + "\n");
                        } else {
                                writer_SN3.write(geneIdGlobal + "\tNA\tNA\tNA\n");
                        }

			if (mapSN6.containsKey(geneIdGlobal)) {
                                String tabela = mapSN6.get(geneIdGlobal);
                                writer_SN6.write(tabela + "\n");
                        } else {
                                writer_SN6.write(geneIdGlobal + "\tNA\tNA\tNA\n");
                        }

			if (mapSN9.containsKey(geneIdGlobal)) {
                                String tabela = mapSN9.get(geneIdGlobal);
                                writer_SN9.write(tabela + "\n");
                        } else {
                                writer_SN9.write(geneIdGlobal + "\tNA\tNA\tNA\n");
                        }

        }
        writer_DN3.close();
        writer_DN6.close();
	writer_DN9.close();
	writer_SN3.close();
	writer_SN6.close();
	writer_SN9.close();
    }
}


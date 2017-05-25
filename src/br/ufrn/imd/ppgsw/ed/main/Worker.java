package br.ufrn.imd.ppgsw.ed.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.ufrn.imd.ppgsw.ed.sorter.Sorter;

public class Worker {

	private static ArrayList<Integer> base;
	private static Timestamp inic;
	private static Timestamp fim;
	private static long result = 0;
	private static int[] ordenado;
	private static Sorter sorter;
	private static FileWriter arq;
	private static String arquivo;
	private static PrintWriter gravarArq;
	private static long timeToRunSort;
	
	
	public static void ordena(int tamanhoDoVetor, int numeroExecucoes, Sorter sorter) throws IOException {

		arquivo = new String("resources/" + sorter.getNome() 
		+ "_rep" + numeroExecucoes 
		+ "_tam" + tamanhoDoVetor
		+".txt");
		arq = new FileWriter(new File(arquivo));
		gravarArq = new PrintWriter(arq);
		Worker.sorter = sorter;
		
		for (int i = 1; i <= numeroExecucoes; i++) {
			base = new ArrayList<Integer>(criaEembaralha(tamanhoDoVetor));
			inic = new Timestamp(System.currentTimeMillis());
			ordenado = sorter.sort(base);
			fim = new Timestamp(System.currentTimeMillis());
			timeToRunSort = (fim.getTime() - inic.getTime());
			result += timeToRunSort;
			escreverEmArquivo(arquivo);
		}
		escreverTempoMedio((double) result / numeroExecucoes);
		arq.close();
	}

	private static ArrayList<Integer> criaEembaralha(int tamanhoDoVetor) {
		ArrayList<Integer> base = new ArrayList<Integer>();
		for (int i = 0; i < tamanhoDoVetor; i++) {
			base.add(i);
		}
		Collections.shuffle(base);
		return base;
	}

	public static void escreverEmArquivo(String arquivo) throws IOException {

		List<Integer> list = IntStream.of(ordenado).boxed().collect(Collectors.toList());
		gravarArq.printf("------------- %n");
		gravarArq.printf(sorter.getNome() + "%n");
		gravarArq.printf("Vetor utilizado: " + base + "%n");
		gravarArq.printf("Tamanho do vetor: " + list.size() + "%n%n");
		
		gravarArq.printf("Tempo inicial: " + inic.toInstant() + "%n");
		gravarArq.printf("Tempo final: " + fim.toInstant() + "%n");
		gravarArq.printf("Tempo total: " + timeToRunSort + "%n%n");
		gravarArq.printf("ORDENADO: ");
		gravarArq.printf(list.toString() + "%n%n");
		
		System.out.printf("Resultado gravado com sucesso %n");
	}
	
	public static void escreverTempoMedio(double media) throws IOException {

		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf("Media de tempo: " + media);
		System.out.printf("Tempo m�dio gravado com sucesso \n\n");
	}
}

package br.ufrn.imd.ppgsw.ed.main;

import java.io.IOException;

import br.ufrn.imd.ppgsw.ed.sorter.*;

public class Main {

	private static int TAMANHO = 100;
	private static final int REPETICOES = 10;
	
	public static void main(String[] args) throws IOException {
		
		for(int i = 1; i < 3; i++){
			//Worker.ordena(TAMANHO, REPETICOES, new ShellSort());
			//Worker.ordena(TAMANHO, REPETICOES, new BubbleSort());
			//Worker.ordena(TAMANHO, REPETICOES, new InsertSort());
			//Worker.ordena(TAMANHO, REPETICOES, new SelectionSort());
			Worker.ordena(TAMANHO, REPETICOES, new HeapSort());
			Worker.ordena(TAMANHO, REPETICOES, new QuickSort());
			Worker.ordena(TAMANHO, REPETICOES, new MergeSort());
			Worker.ordena(TAMANHO, REPETICOES, new RadixSort());

			TAMANHO *= 10;
		}
	}
	
	

}

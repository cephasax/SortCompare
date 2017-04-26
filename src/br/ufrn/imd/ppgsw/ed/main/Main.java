package br.ufrn.imd.ppgsw.ed.main;

import java.io.IOException;

import br.ufrn.imd.ppgsw.ed.sorter.BubbleSort;
import br.ufrn.imd.ppgsw.ed.sorter.InsertSort;
import br.ufrn.imd.ppgsw.ed.sorter.SelectionSort;
import br.ufrn.imd.ppgsw.ed.sorter.ShellSort;

public class Main {

	private static int TAMANHO = 100;
	private static final int REPETICOES = 5;
	
	public static void main(String[] args) throws IOException {
		
		for(int i = 1; i < 6; i++){
			Worker.ordena(TAMANHO, REPETICOES, new ShellSort());
			Worker.ordena(TAMANHO, REPETICOES, new BubbleSort());
			Worker.ordena(TAMANHO, REPETICOES, new InsertSort());
			Worker.ordena(TAMANHO, REPETICOES, new SelectionSort());
			TAMANHO *= 10;
		}
	}
	
	

}
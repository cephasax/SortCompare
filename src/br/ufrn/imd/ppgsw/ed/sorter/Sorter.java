package br.ufrn.imd.ppgsw.ed.sorter;

import java.util.ArrayList;

public abstract class Sorter {
	
	public String nome;

	public int[] sort(int[] dataToSort){
		return null;
	}
	
	public int[] sort(ArrayList<Integer> dataToSort){
		int [] numerosVector = dataToSort.stream().mapToInt(i->i).toArray();
		return sort(numerosVector);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	protected void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}

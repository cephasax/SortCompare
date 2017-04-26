package br.ufrn.imd.ppgsw.ed.sorter;

public class InsertSort extends Sorter{
	
	public InsertSort(){
		this.nome = new String("INSERT_SORT");
	}
	
	@Override
	public int[] sort(int[] dataToSort) {
		int size = dataToSort.length;
		int[] numeros = dataToSort;
		
		for(int i = 1; i < size; i++){
			int cursor = i;
			int atual = numeros[i];
			while((cursor > 0) && (numeros[cursor - 1] > atual) ){
				numeros[cursor] = numeros[cursor - 1];
				cursor--;
			}
			numeros[cursor] = atual;
		}
		
		return numeros;
	}
	
}

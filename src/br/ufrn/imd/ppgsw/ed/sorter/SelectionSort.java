package br.ufrn.imd.ppgsw.ed.sorter;

public class SelectionSort extends Sorter{
	
	public SelectionSort(){
		this.nome = new String("SELECTION_SORT");
	}
	
	@Override
	public int[] sort(int[] dataToSort) {
		int size = dataToSort.length;
		int[] numeros = dataToSort;
		
		for(int i = 0; i < size; i++){
			int cursorMenor = i;
			int menor = numeros[i];
			for(int j = i; j < size; j++){
				if(numeros[j] < menor){
					menor = numeros[j];
					cursorMenor = j;
					
				}
			}
			int temp = numeros[i];
			numeros[i] = menor;
			numeros[cursorMenor] = temp;
		}
		
		return numeros;
	}
	
}

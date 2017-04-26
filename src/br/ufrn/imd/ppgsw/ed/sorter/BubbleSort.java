package br.ufrn.imd.ppgsw.ed.sorter;

public class BubbleSort extends Sorter{
	
	public BubbleSort(){
		this.nome = new String("BUBBLE_SORT");
	}
	
	@Override
	public int[] sort(int[] dataToSort) {
		int size = dataToSort.length;
		int[] numeros = dataToSort;
		
		for(int i = 0; i < size; i++){
			for(int j = i; j < size; j++){
				if(numeros[j] < numeros[i]){
					int temp = numeros[j];
					numeros[j] = numeros[i];
					numeros[i] = temp;
				}
			}
			
		}
		return numeros;
	}
	
}

package br.ufrn.imd.ppgsw.ed.sorter;

public class ShellSort extends Sorter {

	public ShellSort() {
		this.nome = new String("SHELL_SORT");
	}

	@Override
	public int[] sort(int[] dataToSort) {
		int[] numeros=  dataToSort;
		int size = dataToSort.length;
		int salto = size / 2;
		
		while(salto > 0){
			for (int i = salto; i < size; i++){
				int j = i - salto;
				while (j >= 0){
					if (numeros[j] > numeros[j + salto]){
						int temp = numeros[j];
						numeros[j] = numeros[j + salto];
						numeros[j + salto] = temp;
						j = j - salto;
					} 
					else {
						j = j - 1;
					}
				}
			}
			salto = salto / 2;
		}
		return numeros;
	}

}

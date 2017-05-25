package br.ufrn.imd.ppgsw.ed.sorter;

public class MergeSort extends Sorter{

	public MergeSort(){
		this.nome = new String("MERGE_SORT");
	}
	
	public void merge(int[] a, int from, int mid, int to) {
		int[] dest = new int[to - from + 1];
		int aId = from;
		int bId = mid + 1;
		for (int destId = 0; destId < dest.length; destId++) {
			if (aId > mid) {
				dest[destId] = a[bId++];
			} else if (bId > to) {
				dest[destId] = a[aId++];
			} else if (a[aId] <= a[bId]) {
				dest[destId] = a[aId++];
			} else {
				dest[destId] = a[bId++];
			}
		}
		for (int j = 0; j < dest.length; j++) {
			a[from + j] = dest[j];
		}
	}

	public void mergeSort(int[] a, int from, int to) {
		if (from == to){
			return;
		}
		int mid = (from + to) / 2;

		mergeSort(a, from, mid);
		mergeSort(a, mid + 1, to);
		merge(a, from, mid, to);
	}

	@Override
	public int[] sort(int[] dataToSort) {
		int[] numeros = dataToSort;
		mergeSort(numeros, 0, dataToSort.length - 1);
		return numeros;
	}


}
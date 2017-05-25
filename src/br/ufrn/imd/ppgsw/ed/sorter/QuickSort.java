package br.ufrn.imd.ppgsw.ed.sorter;

public class QuickSort extends Sorter {

	private int[] a;
	private int n;

	public QuickSort(){
		this.nome = new String("QUICK_SORT");
	}
	
	private void quicksort(int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int x = a[lo + (hi - lo) / 2];

		int i = lo, j = hi;
		while (i <= j) {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j) {
				swap(a, i++, j--);
			}
		}
		quicksort(lo, j);
		quicksort(i, hi);
	}

	@Override
	public int[] sort(int[] dataToSort) {
		this.a = dataToSort;
		n = dataToSort.length;
		quicksort(0, n - 1);
		return a;
	}
}

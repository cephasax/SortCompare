package br.ufrn.imd.ppgsw.ed.sorter;

public class HeapSort extends Sorter {

	public HeapSort() {
		this.nome = new String("HEAP_SORT");
	}

	private int A[];

	private void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// To Max-Heapify a subtree rooted at node i which is
	// an index in A[]. n -> size of heap
	void maxHeapify(int A[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && A[l] > A[largest]){
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && A[r] > A[largest]){
			largest = r;
		}
		// If largest is not root
		if (largest != i) {
			swap(A,  i, largest);
			// Recursively heapify the affected sub-tree
			maxHeapify(A, n, largest);
		}
	}

	// Build-Max-Heap (rearrange array)
	// Converting array A to Max-Heap
	public void BuildMaxHeap(int A[]) {
		int n = A.length;
		// one by one checking all root nodes
		// and calling Heapify function
		// if they does not satisfy heap property
		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeapify(A, n, i);
	}

	// main function to do Heap Sort
	public void heapSort(int arr[]) {
		this.A = arr;
		int n = A.length;

		BuildMaxHeap(A);
		// One by one extract an element from heap
		// and get the sorted array
		for (int i = n - 1; i >= 0; i--) {
			// Move top root element to end element
			swap(0, i);
			// call max heapify on the reduced heap
			maxHeapify(arr, i, 0);
		}
	}

	@Override
	public int[] sort(int[] dataToSort) {
		HeapSort hs = new HeapSort();
		hs.heapSort(dataToSort);
		return dataToSort;

	}

}

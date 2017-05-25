package br.ufrn.imd.ppgsw.ed.sorter;

public class HeapSort extends Sorter {

	public HeapSort(){
		this.nome = new String("HEAP_SORT");
	}
	
	public void maxHeapify(int[] array, int currentId, int sizeOfHeap) {
		// Left child
		int left = 2 * currentId + 1;
		// Right child
		int right = 2 * currentId + 2;
		int largest = currentId;

		if (left < sizeOfHeap && array[left] > array[currentId]) {
			largest = left;
		}

		if (right < sizeOfHeap && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != currentId) {
			swap(array, currentId, largest);
			maxHeapify(array, largest, currentId);
		}
	}

	public void constructMaxHeap(int[] array, int heapSize) {
		
		int lastElementId = array.length - 1;
		int parentIndex = (lastElementId - 1) / 2;
		for (int i = parentIndex; i >= 0; i--) {
			maxHeapify(array, i, heapSize);
		}
	}

	public void heapSort(int[] array) {
		if (array == null || array.length < 2)
			return;

		constructMaxHeap(array, array.length);
		int heapSize = array.length;
		for (int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			heapSize = heapSize - 1;
			maxHeapify(array, 0, heapSize);
		}
	}

	@Override
	public int[] sort(int[] dataToSort) {
		int[] numeros = dataToSort;
		heapSort(numeros);
		return numeros;
		
	}

}

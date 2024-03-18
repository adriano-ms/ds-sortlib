package br.edu.fateczl.sort;

public class Sort {

	public static int[] bubbleSort(int[] array) {
		int size = array.length;
		int aux = 0;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size - 1; j++)
				if (array[j] > array[j + 1]) {
					aux = array[j + 1];
					array[j + 1] = array[j];
					array[j] = aux;
				}

		return array;
	}

	public static int[] mergeSort(int[] array, int beginIndex, int endIndex) {
		if (beginIndex < endIndex) {
			int middle = (beginIndex + endIndex) / 2;
			mergeSort(array, beginIndex, middle);
			mergeSort(array, middle + 1, endIndex);
			sortSubarray(array, beginIndex, middle, endIndex);
		}

		return array;
	}

	public static int[] mergeSort(int[] array) {
		int beginIndex = 0;
		int endIndex = array.length - 1;
		if (beginIndex < endIndex) {
			int middle = (beginIndex + endIndex) / 2;
			mergeSort(array, beginIndex, middle);
			mergeSort(array, middle + 1, endIndex);
			sortSubarray(array, beginIndex, middle, endIndex);
		}

		return array;
	}

	private static void sortSubarray(int[] array, int beginIndex, int middle, int endIndex) {
		int aux[] = new int[array.length];

		for (int i = beginIndex; i <= endIndex; i++)
			aux[i] = array[i];

		int leftPointer = beginIndex;
		int rightPointer = middle + 1;

		for (int i = beginIndex; i <= endIndex; i++) {
			if (leftPointer > middle) {
				array[i] = aux[rightPointer];
				rightPointer++;
			} else if (rightPointer > endIndex) {
				array[i] = aux[leftPointer];
				leftPointer++;
			} else if (aux[leftPointer] < aux[rightPointer]) {
				array[i] = aux[leftPointer];
				leftPointer++;
			} else {
				array[i] = aux[rightPointer];
				rightPointer++;
			}
		}
	}

	public static int[] quickSort(int[] array, int beginIndex, int endIndex) {
		if (beginIndex < endIndex) {
			int pivot = beginIndex;
			int leftPointer = pivot + 1;
			int rightPointer = endIndex;
			pivot = movePointers(array, pivot, leftPointer, rightPointer);
			quickSort(array, beginIndex, pivot - 1);
			quickSort(array, pivot + 1, endIndex);
		}
		return array;
	}
	
	public static int[] quickSort(int[] array) {
		int beginIndex = 0;
		int endIndex = array.length - 1;
		if (beginIndex < endIndex) {
			int pivot = beginIndex;
			int leftPointer = pivot + 1;
			int rightPointer = endIndex;
			pivot = movePointers(array, pivot, leftPointer, rightPointer);
			quickSort(array, beginIndex, pivot - 1);
			quickSort(array, pivot + 1, endIndex);
		}
		return array;
	}

	private static int movePointers(int[] array, int pivot, int leftPointer, int rightPointer) {
		while (leftPointer <= rightPointer) {
			while (leftPointer <= rightPointer && array[leftPointer] <= array[pivot]) {
				leftPointer++;
			}

			while (leftPointer <= rightPointer && array[rightPointer] > array[pivot]) {
				rightPointer--;
			}
			if (leftPointer <= rightPointer) {
				int aux = array[leftPointer];
				array[leftPointer] = array[rightPointer];
				array[rightPointer] = aux;
			}
		}
		int aux = array[pivot];
		array[pivot] = array[rightPointer];
		array[rightPointer] = aux;
		pivot = rightPointer;

		return pivot;
	}
}

/**
 * This Quick sort have used Hoare partition technique where number of swaps are
 * reduced and Best used for array having more duplicates
 * average time complexity is O(nlogn) and space complexity is O(1) ie in array sorting.
 * 
 * @author z022839
 *
 */
public class QuickSortHoareScheme {

	public static void main(String[] args) {
		int[] num = { 10, 2, 3, 1, 8, 9, 6 };
		quickSortHoare(num);
		for (int n : num) {
			System.out.println(n);
		}
	}

	public static void quickSortHoare(int[] arr) {
		quickSortHoare(arr, 0, arr.length - 1);
	}

	private static void quickSortHoare(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSortHoare(arr, low, pi);
			quickSortHoare(arr, pi + 1, high);
		}

	}

	private static int partition(int[] arr, int low, int high) {

		int pivot = arr[low];
		int i = low - 1;
		int j = high + 1;
		while (true) {

			do {
				i++;
			} while (arr[i] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (i >= j) {
				return j;
			}
			swap(arr, i, j);

		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}

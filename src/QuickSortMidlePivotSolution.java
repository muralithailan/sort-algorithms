
public class QuickSortMidlePivotSolution {

	public static void main(String[] args) {

		int[] arr = {3,2,1,5,4,6};
		
		quickSort(arr);
		for(int a : arr) {
			System.out.println(a);
		}
		

	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {

		int pivot = partation(arr, low, high);
		if (low < pivot - 1) {
			quickSort(arr, low, pivot - 1);
		}
		if (pivot < high) {
			quickSort(arr, pivot, high);
		}

	}

	private static int partation(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int pivot = arr[mid];

		while (low < high) {

			while (arr[low] < pivot)
				low++;

			while (arr[high] > pivot)
				high--;

			while (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;

	}

}

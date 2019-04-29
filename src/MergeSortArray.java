/**
 * This merge sort have average and worst case as O(nlogn) only overhead is 
 * that we need to have O(n) space complexity
 * @author z022839
 *
 */
public class MergeSortArray {

	public static void main(String[] args) {
		int[] num = { 10, 2, 3, 1, 8, 9, 6 };

		mergeSort(num);
		for (int n : num) {
			System.out.println(n);
		}

	}
	
	public static void mergeSort(int[] arr) {
		
		mergeSort(arr,0,arr.length-1);
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if(low<high) {
			
			int mid = (low+high)/2;
			
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
		
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		
		int n1 = (mid -low) + 1;
		int n2 = high - mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i =0;i<n1;i++) {
			left[i] = arr[low+i];
		}
		
		for(int j = 0; j< n2 ; j++) {
			right[j] = arr[mid+1+j];
		}
		int k=low;
		int i=0;
		int j=0;
		
		while(i< n1 && j < n2) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i< n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j< n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	

}

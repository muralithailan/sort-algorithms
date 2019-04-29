
/**
 * This is one of Quick sort algorithm when two pivot have been chosen to bring average case to O(nlog3 n)
 * worst is still in O(n2)
 * used in java sort
 * @author z022839
 *
 */
public class DualPivotQuickSort {

	public static void main(String[] args) {
		int[] num = { 10, 2, 3, 1, 8, 9, 6 };

		dualPivotQuickSort(num);
		for (int n : num) {
			System.out.println(n);
		}
	}

	public static void dualPivotQuickSort(int[] arr) {
		dualPivotQuickSort(arr,0,arr.length-1);
	}

	private static void dualPivotQuickSort(int[] arr, int low, int high) {
		if(low<high) {
			
			int[] pi = partition(arr,low,high);
			dualPivotQuickSort(arr,low,pi[0]-1);
			dualPivotQuickSort(arr,pi[0]+1,pi[1]-1);
			dualPivotQuickSort(arr,pi[1]+1,high);
		}
		
	}

	private static int[] partition(int[] arr, int low, int high) {

		if(arr[low] > arr[high]) {
			swap(arr,low,high);
		}
		
		int j =low +1;
		int g = high -1;
		int p = arr[low];
		int q = arr[high];
		int k =low +1;
		
		while(k<=g) {
			
			if(arr[k] < p) {
				swap(arr,k,j);
				j++;
			}else if(arr[k] >= q) {
				
				while(arr[g]> q && k<g) {
					g--;
				}
				swap(arr,k,g);
				g--;
				if(arr[k] < p) {
					swap(arr,k,j);
					j++;
				}
				
			}
			
			
			k++;
		}
		j--;
		g++;
		swap(arr,low,j);
		swap(arr,high,g);
		return new int[] {j,g};
	
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}


/**
 * To Get assending order first build Max heap so that when we remove and swap
 * with last element one by one we will get ascending value. ex input [3,4,2]
 * once heap build then [4,2,3] step 1 in reheap swap 4 and 3 [3,2,4] and call
 * re heap from 0 to 2, then to swap 3 and 2 and he heap on 2 [2,3,4]
 * 
 * 
 * best and worst and average case complexity is O(nlogn)
 * @author z022839
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] num = { 10, 2, 3, 1, 8, 9, 6 };
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(num);

		for (int i : num) {
			System.out.println(i);
		}

	}

	public void swap(int[] arr,int spos,int fpos) {
		int temp = arr[spos];
		arr[spos] = arr[fpos];
		arr[fpos] = temp;
	}
	
	public void heapSort(int[] arr) {
		//Build Heap
		for(int pos = arr.length/2 -1;pos>=0;pos--) {
			heapify(arr, arr.length, pos);
		}
		
		for(int i =arr.length-1;i>=0;i--) {
			swap(arr,0,i);
			heapify(arr, i, 0);
		}
		
	}
	public void heapify(int[] arr,int n,int i) {
		int large = i;
		
		int left = 2*i +1;
		int right = 2*i + 2;
		
		if(left < n && arr[left] > arr[large]) {
			large = left;
		}
		
		if(right < n && arr[right] > arr[large]) {
			large = right;
		}
		
		if(large != i) {
			swap(arr,large,i);
			heapify(arr,n,large);
		}
	}
}

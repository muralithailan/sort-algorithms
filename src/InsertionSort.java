
public class InsertionSort {

	public static void main(String[] args) {
		int[] num = {10,2,3,1,8,9,6};
		
		insertionSort(num);
		for(int n : num) {
			System.out.println(n);
		}
	}
	
	public static void insertionSort(int[] num) {
		
		for(int i=1;i<num.length;i++) {
			int key = num[i];
			int j = i-1;
			
			while(j>=0 && num[j]>key) {
				num[j+1] = num[j];
				j = j -1;
			}	
			num[j+1] = key;
		}
	}
	
	
}

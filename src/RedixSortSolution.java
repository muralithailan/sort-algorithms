import java.util.Arrays;

public class RedixSortSolution {

	public static void main(String[] args) {
		int[] num = {100,23,1,45,20};

		redixSort(num);
		
		for(int n : num) {
			System.out.print(n +" ");
		}
	}
	
	public static void redixSort(int[] num) {
		
		int max = Arrays.stream(num).max().getAsInt();
		for(int pos =1;max/pos >0;pos = pos *10) {
			redixSort(num,pos);
		}
	}

	private static void redixSort(int[] num, int pos) {

		int[] count = new int[10]; // base10
		int[] out = new int[num.length];

		for (int i = 0; i < num.length; i++) {
			count[(num[i] / pos) % 10]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = num.length - 1; i >= 0; i--) {
			out[count[(num[i] / pos) % 10] - 1] = num[i];
			--count[(num[i] / pos) % 10];
		}

		for (int i = 0; i < num.length; i++) {
			num[i] = out[i];
		}
	}

}

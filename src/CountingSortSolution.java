import java.util.Arrays;
import java.util.OptionalInt;

public class CountingSortSolution {

	public static void main(String[] args) {

		char[] in = { 'd', 'c', 't', 'a' };

		countingSortChar(in);
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i] + " ");
		}
		System.out.println();
		System.out.println("***************************Range based counting sort ***************************");
		int[] num = { 20, 30, 21, 26, 27 };

		countingSortRange(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public static void countingSortChar(char[] chr) {

		int[] count = new int[256];

		char[] output = new char[chr.length];

		for (int i = 0; i < chr.length; i++) {
			count[chr[i]]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = chr.length - 1; i >= 0; i--) {
			output[count[chr[i]] - 1] = chr[i];
			--count[chr[i] - 1];
		}

		for (int i = 0; i < output.length; i++) {
			chr[i] = output[i];
		}

	}

	public static void countingSortRange(int[] num) {

		int min = Arrays.stream(num).min().getAsInt();
		int max = Arrays.stream(num).max().getAsInt();
		int[] count = new int[max - min + 1];

		int[] out = new int[num.length];

		for (int i = 0; i < num.length; i++) {
			++count[num[i] - min];
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = num.length - 1; i >= 0; i--) {
			out[count[num[i] - min] - 1] = num[i];

			--count[num[i] - min];
		}

		for (int i = 0; i < num.length; i++) {
			num[i] = out[i];
		}
	}

}

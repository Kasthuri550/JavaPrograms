import java.util.Arrays;
import java.util.stream.IntStream;

public class SumElements {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		approach1(arr);
		approach2(arr);
		approach3(arr);
		approach4(arr);
		approach5(arr);

	}

	private static void approach5(int[] arr) {
		
		long sum = Arrays.stream(arr).summaryStatistics().getSum();
		System.out.println(sum);
		
	}

	private static void approach4(int[] arr) {
		
		int sum = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
		System.out.println(sum);
	}

	private static void approach3(int[] arr) {
		
		int sum = Arrays.stream(arr).reduce((x,y) -> x+y).getAsInt();
		System.out.println(sum);
		
	}

	private static void approach2(int[] arr) {
		
		int sum = IntStream.of(arr).sum();
		System.out.println(sum);
		
	}

	private static void approach1(int[] arr) {
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
	}

}

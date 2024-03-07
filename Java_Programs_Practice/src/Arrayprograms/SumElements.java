package Arrayprograms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumElements {

	public static void main(String[] args) {
		
		int arr[]= {2,3,4,8,2,0};
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		
		int sum2 = IntStream.of(arr).sum();
		System.out.println(sum2);
		
		long sum3 = Arrays.stream(arr).summaryStatistics().getSum();
		System.out.println(sum3);
		
		int sum4 = Arrays.stream(arr).reduce((x,y)-> x+y).getAsInt();
		System.out.println(sum4);
		
		int sum5 = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
		System.out.println(sum5);
		
		int max = Arrays.stream(arr).summaryStatistics().getMax();
		System.out.println(max);
		
		int min = Arrays.stream(arr).summaryStatistics().getMin();
		System.out.println(min);

	}

}

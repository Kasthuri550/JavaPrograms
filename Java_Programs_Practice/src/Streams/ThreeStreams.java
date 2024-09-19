package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeStreams {

	public static void main(String[] args) {
		
		int arr1[][] = { {1, 2},{ 3, 4},{ 5} };
		double arr2[][] = { {1.5, 2.2},{ 3.5, 4.2},{5.3}};
		
		Arrays.stream(arr1).flatMapToInt(Arrays::stream).forEach(result->System.out.print(result+" "));
		
		List<Double> collectDoubleArr = Arrays.stream(arr2).flatMapToDouble(Arrays::stream)
						   .boxed().collect(Collectors.toList());
				
		System.out.println(collectDoubleArr);
	}
}

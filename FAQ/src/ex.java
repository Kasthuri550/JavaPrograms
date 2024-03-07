import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ex {

	public static void main(String[] args) {

		int arr[]= {2,3,4,5};
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		
		List<int[]> list1=Arrays.asList(arr);
		
		System.out.println(list);
	}

}

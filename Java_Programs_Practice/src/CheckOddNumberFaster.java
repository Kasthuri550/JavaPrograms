import java.util.Arrays;
import java.util.List;

public class CheckOddNumberFaster {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(35,45,89,12);
		
		System.out.println(checkOdd(list));
	
	}
	
	public static boolean checkOdd(List<Integer> list)
	{
		return list.parallelStream().anyMatch(x -> x%2 != 0);
	}
	
}

import java.util.Arrays;
import java.util.List;

public class CheckOddNumbers {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(31,63,23,89,13);
		System.out.println(checkOdd(list));
	}
	
	public static boolean checkOdd(List<Integer> list)
	{
		for(int i:list)
		{
			if(i%2==0)
				return false;
		}
		
		return true;
	}
	
}

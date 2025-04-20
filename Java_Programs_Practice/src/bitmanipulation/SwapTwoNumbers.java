package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class SwapTwoNumbers {

	public static void main(String[] args) {

		int a=6,b=5;
		
		System.out.println(swapTwoNumbersUsingBitManipulation(a,b));	
	}

	private static List<Integer> swapTwoNumbersUsingBitManipulation(int a, int b) {

		List<Integer> swap=new ArrayList<>();
		
		a=a^b;
		b=a^b;
		a=a^b;
		
		swap.add(a);
		swap.add(b);
		
		
		return swap;
	}
}

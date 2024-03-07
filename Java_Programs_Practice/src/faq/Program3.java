package faq;

import java.util.Arrays;

public class Program3 {

	public static void main(String[] args) {
		
//		String arr[]= {"3","30","34","5","9"};
//		String arr[]= {"50","3","95","22","18","7"};
		String arr[]= {"70","75","80","90","10"};
		
		
		System.out.println(largestNumber(arr));
	}

	private static String largestNumber(String[] arr) {
		
		String str="";
		
		Arrays.sort(arr,(num1,num2)-> (num2+num1).compareTo(num1+num2));
		
		for(String value:arr)
		{
			str=str+value;
		}
		return str;
	}

}

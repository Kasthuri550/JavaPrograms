package faq;

import java.util.Arrays;

public class Program4 {

	public static void main(String[] args) {
		
		String arr[]= {"3","30","34","5","9"};
		
		System.out.println(smallestNumber(arr));
	}

	private static String smallestNumber(String[] arr) {
		
		Arrays.sort(arr,(num1,num2)-> (num1+num2).compareTo(num2+num1));
		
		return String.join("", arr);
	}

}

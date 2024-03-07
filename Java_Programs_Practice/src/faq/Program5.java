package faq;

import java.util.Arrays;

public class Program5 {

	public static void main(String[] args) {
		
		String arrs[]= {"1","2","5","4","7","8","11","20"};
		
		evenAndOdd(arrs);
	}

	private static void evenAndOdd(String[] arrs) {
		
		int arr[]=new int[arrs.length];
		int index=0;
		
		for(String value:arrs)
		{
			int parsedInt=Integer.parseInt(value);
			if((parsedInt & 1) ==0)
			{
				arr[index++]=parsedInt;
			}
		}
		
		for(String value:arrs)
		{
			int parsedInt=Integer.parseInt(value);
			if((parsedInt & 1) ==1)
			{
				arr[index++]=parsedInt;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

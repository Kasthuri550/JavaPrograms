package faq;

import java.util.Arrays;
import java.util.HashSet;

public class Program9 {

	public static void main(String[] args) {
		
		int firstArray[]= {4,9,5};
		int secondArray[]= {9,4,9,8,4};
		
		Arrays.stream(firstArray).filter(x -> Arrays.stream(secondArray)
				.anyMatch(y->y==x)).distinct().forEach(System.out::println);
		approach1(firstArray,secondArray);
	}

	private static void approach1(int[] firstArray, int[] secondArray) {
		
		HashSet<Integer> hs1=new HashSet<Integer>();
		HashSet<Integer> hs2=new HashSet<Integer>();
		
		for(int i=0;i<firstArray.length;i++)
		{
			hs1.add(firstArray[i]);
		}
		
		for(int j=0;j<secondArray.length;j++)
		{
			if(hs1.contains(secondArray[j]))
			{
				hs2.add(secondArray[j]);
			}
		}
		System.out.println(hs2);
	}

}

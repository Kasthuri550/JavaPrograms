package Arrayprograms;

import java.util.Arrays;

public class SortStringArray {

	public static void main(String[] args) {
		
		String[] stringArray = {"orange", "apple", "banana", "grape"};
		
		System.out.println("Original string array: "+Arrays.toString(stringArray));
		
		sortStringArray(stringArray);
        
		System.out.println("Sorted string array: "+Arrays.toString(stringArray));
	}

	private static void sortStringArray(String[] stringArray) {
		
		int stringArrayLength=stringArray.length;
		for(int itr1=0;itr1<stringArrayLength;itr1++)
		{
			for(int itr2=itr1+1;itr2<stringArrayLength;itr2++)
			{
				if(stringArray[itr1].compareTo(stringArray[itr2])>0)
				{
					swap(stringArray,itr1,itr2);
				}
				
			}
		}
		
	}

	private static void swap(String[] stringArray, int itr1, int itr2) {
		
		String tempString=stringArray[itr1];
		stringArray[itr1]=stringArray[itr2];
		stringArray[itr2]=tempString;
	}	
}

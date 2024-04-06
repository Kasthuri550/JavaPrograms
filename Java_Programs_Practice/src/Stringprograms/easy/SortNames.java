package Stringprograms.easy;

import java.util.Arrays;

public class SortNames {

	public static void main(String[] args) {
		
		String[] array = {"racecar", "madam", "level", "hello", "noon","edcaabbaacde"};
		
		Arrays.sort(array);
		
//		for(int i=0;i<array.length;i++)
//		{
//			for(int j=i+1;j<array.length;j++)
//			{
//				if(array[i].compareTo(array[j])>0)
//				{
//					String temp=array[i];
//					array[i]=array[j];
//					array[j]=temp;
//				}
//			}
//		}
		
		System.out.println(Arrays.toString(array));

	}

}

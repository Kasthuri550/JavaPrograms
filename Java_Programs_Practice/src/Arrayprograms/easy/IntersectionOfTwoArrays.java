package Arrayprograms.easy;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {

		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {3, 4, 5, 6, 7};
		
//		int[] arr3=intersection(arr1,arr2);
		HashSet<Integer> hs=intersection1(arr1,arr2);
		System.out.println(hs);
//		System.out.println(Arrays.toString(arr3));

	}

	private static HashSet<Integer> intersection1(int[] arr1, int[] arr2) {
		
		HashSet<Integer> hs1=new HashSet<Integer>();
		HashSet<Integer> hs2=new HashSet<Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			hs1.add(arr1[i]);
		}
		int j;
		for(j=0;j<arr2.length;j++)
		{
			if(hs1.contains(arr2[j]))
				hs2.add(arr2[j]);
		}
		
		return hs2;
	}

	private static int[] intersection(int[] arr1, int[] arr2) {
		
		int i=0,j=0,k=0;
		int n=arr1.length,m=arr2.length;
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int temp[]=new int[Math.min(n, m)];
		
		while(i <n  && j <m )
		{
			if(arr1[i]<arr2[j])
			{
				i++;
			}
			else if(arr1[i]>arr2[j])
			{
				j++;
			}
			else
			{
				temp[k]=arr1[i];
				i++;
				j++;
				k++;
			}
		}
		
		int intersection[]=new int[k];
		
//		System.arraycopy(temp, 0, intersection, 0, k);
		return Arrays.copyOfRange(temp, 0, k);
		
//		return Arrays.copyOf(temp, k);
	}

}

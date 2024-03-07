package Basicmaths;

import java.util.ArrayList;
import java.util.HashSet;

public class MissingNumbers {
	
	public static void main(String[] args) {
		
		int arr[]= {2,4,1,5,7,8,0};
		mn(arr);
	}

	private static void mn(int[] arr) {
		
		int n=arr.length;
		
		HashSet<Integer> al=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			al.add(arr[i]);
		}
		
		for(int j=0;j<n+1;j++)
		{
			if(!al.contains(j))
			{
				System.out.println(j);
			}
		}
	}
}

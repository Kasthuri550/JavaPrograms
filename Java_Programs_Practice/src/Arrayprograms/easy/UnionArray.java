package Arrayprograms.easy;

import java.util.ArrayList;

public class UnionArray {

	public static void main(String[] args) {

		int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		  int arr2[] = {2, 3, 4, 4, 5, 11, 12};
		  
		  union(arr1,arr2);
	}

	private static void union(int[] arr1, int[] arr2) {
		
		ArrayList<Integer> al=new ArrayList<>();
		
		int i=0,j=0,m=arr1.length,n=arr2.length;
		
		while(i<m && j<n)
		{
			if(arr1[i]<=arr2[j])
			{
				if(al.size()==0||al.get(al.size()-1)!=arr1[i])
					al.add(arr1[i]);
				i++;
			}
			else
			{
				if(al.size()==0||al.get(al.size()-1)!=arr2[j])
					al.add(arr2[j]);
				j++;
			}
		}
		
		while(i<m)
		{
				if(al.get(al.size()-1)!=arr1[i])
					al.add(arr1[i]);
				i++;
		}
		
		while(j<n)
		{
			if(al.size()==0||al.get(al.size()-1)!=arr2[j])
				al.add(arr2[j]);
			j++;
		}
		
		System.out.println(al);
	}

}

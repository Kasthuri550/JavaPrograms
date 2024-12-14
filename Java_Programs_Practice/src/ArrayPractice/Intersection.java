package ArrayPractice;

import java.util.ArrayList;

public class Intersection {

	public static void main(String[] args) {
		
		int arr1[] = {1, 2, 3, 4,4, 5, 6, 7, 8, 9, 10};
		int arr2[] = {2, 3, 4, 4, 5, 11, 12};
		
		approach1(arr1,arr2);

	}

	private static void approach1(int[] arr1, int[] arr2) {
		
		int m=arr1.length,n=arr2.length,i=0,j=0;
		ArrayList<Integer> intersection=new ArrayList<>();
		
		while(i<m && j<n)
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
				if(intersection.size()==0 || intersection.get(intersection.size()-1)!=arr1[i])
					intersection.add(arr1[i]);
				i++;
				j++;
			}
		}
		System.out.println(intersection);		
	}
}

package ArrayPractice;

import java.util.ArrayList;

public class Union {

	public static void main(String[] args) {

		int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int arr2[] = {2, 3, 4, 4, 5, 11, 12};
		
		approach1(arr1,arr2);

	}

	private static void approach1(int[] arr1, int[] arr2) {
		
		int m=arr1.length,n=arr2.length,i=0,j=0;
		
		ArrayList<Integer> list=new ArrayList<>();
		
		while(i<m && j<n)
		{
			if(arr1[i]<=arr2[j])
			{
				if(list.size()==0 || list.get(list.size()-1)!=arr1[i])
					list.add(arr1[i]);
				i++;
			}
			else if(arr1[i]>=arr2[j])
			{
				if(list.size()==0 || list.get(list.size()-1)!=arr2[j])
					list.add(arr2[j]);
				j++;
			}
		}
		
		while(i<m)
		{
			if(list.get(list.size()-1)!=arr1[i])
				list.add(arr1[i]);
			i++;
		}
		
		while(j<n)
		{
			if( list.get(list.size()-1)!=arr2[j])
				list.add(arr2[j]);
			j++;
		}
		
		System.out.println(list);
	}
}

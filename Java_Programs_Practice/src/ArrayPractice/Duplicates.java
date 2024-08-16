package ArrayPractice;

import java.util.HashSet;

public class Duplicates {

	public static void main(String[] args) {
		
		int arr[]= {3,4,8,1,9,2,5,3,3,2,2,2},n=arr.length;
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(arr[i]==arr[j])
					count++;
			}
			
			if(count>1)
				hashSet.add(arr[i]);
		}

		System.out.println(hashSet);
	}
}

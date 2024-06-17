package Arrayprograms.easy;

import java.util.ArrayList;
import java.util.Collections;

public class DuplicateElementInArray {

	public static void main(String[] args) {
		
		int arr[] = {2,3,1,2,3};
		
		duplicateBrute(arr,arr.length);

	}

	private static void duplicateBrute(int[] arr, int n) {
		
		
		ArrayList<Integer> duplicateList=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					duplicateList.add(arr[i]);
					break;
				}
			}
		}
		
		if(duplicateList.isEmpty())
			duplicateList.add(-1);
		
		Collections.sort(duplicateList);
		System.out.println(duplicateList);
		
	}
}

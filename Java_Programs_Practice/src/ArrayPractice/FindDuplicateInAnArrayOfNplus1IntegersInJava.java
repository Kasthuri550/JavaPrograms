package ArrayPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicateInAnArrayOfNplus1IntegersInJava {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 3,2};
		
		System.out.println(duplicates1(arr));
		System.out.println(duplicates2(arr));

	}

	private static ArrayList<Integer> duplicates2(int[] arr) {
		
		int n=arr.length;
		
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			arr[arr[i]%n]=arr[arr[i]%n]+n;
		}
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>=n*2)
			{
				list.add(i);
			}
		}
		return list;
	}

	private static int duplicates1(int[] arr) {
		
		int n=arr.length;
		
		int slow=arr[0],fast=arr[arr[0]];
		
		while(slow!=fast)
		{
			slow=arr[slow];
			fast=arr[arr[fast]];
		}
		
		fast=0;
		while(slow!=fast)
		{
			slow=arr[slow];
		    fast=arr[fast];
		}
		
		return slow;
	}
}

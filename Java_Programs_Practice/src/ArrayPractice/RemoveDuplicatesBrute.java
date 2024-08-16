package ArrayPractice;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesBrute {

	public static void main(String[] args) {
		
		int arr[]={1,1,2,2,2,3,3};
		
		int k=removeDuplicatesBrute(arr);
		
		for(int i=k;i<arr.length;i++)
		{
			arr[i]=-1;
		}
		System.out.println(Arrays.toString(arr));
	}

	private static int removeDuplicatesBrute(int[] arr) {
		
		int n=arr.length;
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			hashSet.add(arr[i]);
		}
		
		int j=0;
		for(int set:hashSet)
		{
			arr[j++]=set;
		}
		
		return hashSet.size();
	}
}

package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPermutationsArrayString {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3};
		int a[]= {2,3,1};
		
		List<Integer> ds=new ArrayList<>();
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		boolean freq[]=new boolean[arr.length];
		List<List<Integer>> resultList=new ArrayList<List<Integer>>();
		permutationsBrute(arr,ds,ans,freq);
//		permutationsOptimal(arr,0,resultList);
		
		System.out.println(ans);
		
		
//		System.out.println(resultList);

	}

	private static void permutationsOptimal(int[] arr, int index, List<List<Integer>> resultList) {
		
		int n=arr.length;
		
		if(index==n)
		{
			List<Integer> ds=new ArrayList<Integer>();
			for(int j=0;j<n;j++)
			{
				ds.add(arr[j]);
			}
			resultList.add(ds);
			return;
		}
		for(int i=index;i<n;i++)
		{
			swap(arr,index,i);
			permutationsOptimal(arr, index+1, resultList);
			swap(arr,index,i);
		}
		
	}

	private static void swap(int[] arr, int a, int b) {
		
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;		
	}

	private static void permutationsBrute(int[] arr, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
		
		int n=arr.length;
		if(ds.size()==n)
		{
			ans.add(new ArrayList<Integer>(ds));
			return;
		}
		
		for(int i=0;i<n;i++)
		{
			if(!freq[i])
			{
				freq[i]=true;
				ds.add(arr[i]);
				permutationsBrute(arr, ds, ans, freq);
				ds.remove(ds.size()-1);
				freq[i]=false;
			}
		}
		
	}
}

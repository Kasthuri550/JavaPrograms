package Arrayprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortAnArray012s {

	public static void main(String[] args) {
		
		 int n = 6;
	     ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
	     System.out.println("Before sorting");
	     printArray(arr,n);
//	     sortArray1(arr,n);
//	     sortArray2(arr,n);
	     sortArray3(arr, n);
	     System.out.println("After sorting");
	     printArray(arr,n);
	}

	private static void sortArray3(ArrayList<Integer> arr, int n) {
		
		int low=0,mid=0,high=n-1;
		
		while(mid <= high)
		{
			if(arr.get(mid)==0)
			{
				int temp=arr.get(low);
				arr.set(low, arr.get(mid));
				arr.set(mid, temp);
				low++;
				mid++;
			}
			else if(arr.get(mid)==1)
			{
				mid++;
			}
			else
			{
				int temp=arr.get(mid);
				arr.set(mid, arr.get(high));
				arr.set(high, temp);
				high--;
			}
		}		
	}

	private static void sortArray2(ArrayList<Integer> arr, int n) {
		
		int count0=0,count1=0,count2=0;
		
		for(int i=0;i<n;i++)
		{
			if(arr.get(i)==0)
			{
				count0++;
			}
			else if(arr.get(i)==1)
			{
				count1++;
			}
			else
			{
				count2++;
			}
		}
		
		for(int j=0;j<count0;j++)
		{
			arr.set(j,0);
		}
		for(int k=count0;k<count0+count1;k++)
		{
			arr.set(k, 1);
		}
		for(int l=count0+count1;l<n;l++)
		{
			arr.set(l,2);
		}
	}

	private static void printArray(ArrayList<Integer> arr, int n) {
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}

	private static void sortArray1(ArrayList<Integer> arr, int n) {
		
		mergeSort(arr,0,n-1);
	}

	private static void mergeSort(ArrayList<Integer> arr, int low,int high) {
		
		if(low>=high) return;
		
		int mid=low+(high-low)/2;
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr,low,mid,high);
	}

	private static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
		
		int left=low,right=mid+1;
		ArrayList<Integer> temp=new ArrayList<Integer>();
		
		while(left<=mid && right<=high)
		{
			if(arr.get(left) <= arr.get(right))
			{
				temp.add(arr.get(left));
				left++;
			}
			else
			{
				temp.add(arr.get(right));
				right++;
			}
		}
		
		while(left <= mid)
		{
			temp.add(arr.get(left));
			left++;
		}
		
		while(right <= high)
		{
			temp.add(arr.get(right));
			right++;
		}
		
		for(int i=low;i<=high;i++)
		{
			arr.set(i, temp.get(i-low));
		}
		
	}
}

package sorting;

import java.util.ArrayList;

public class MergeSort {

	public static void main(String[] args) {
		
		 int N=7,arr[]={3,2,8,5,1,4,23};
		 
		 printArray(arr,"Before sorting");
		 
		 mergeSort(arr,0,N-1);
		 
		 printArray(arr,"After sorting");

	}

	private static void printArray(int[] arr,String text) {
		
		System.out.println(text);
		
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		
	}

	private static void mergeSort(int[] arr, int low, int high) {
		
		if(low>=high) return;
		
		int mid=low+(high-low)/2;
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr,low,mid,high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		
		int left=low,right=mid+1;
		ArrayList<Integer> temp=new ArrayList<Integer>();
		
		while(left <= mid && right <= high)
		{
			if(arr[left] <= arr[right])
			{
				temp.add(arr[left]);
				left++;
			}
			else 
			{
				temp.add(arr[right]);
				right++;
			}
		}
		
		while(left <= mid)
		{
			temp.add(arr[left]);
			left++;
		}
		
		while(right <= high)
		{
			temp.add(arr[right]);
			right++;
		}
		
		for(int i=low;i<=high;i++)
		{
			arr[i]=temp.get(i-low);
		}
	}

}

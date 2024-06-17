package sorting;

import java.util.Arrays;

public class SortArray012 {

	public static void main(String[] args) {
		
		int arr[]={0, 2, 1, 2, 0, 1};
		
//		sortArray1(arr);
//		sortArray2(arr);
		sortArray3(arr);

	}

	private static void sortArray3(int[] arr) {
		
		int n=arr.length;
		int low=0,mid=0,high=n-1;
		
		while(mid<=high)
		{
			if(arr[mid]==0)
			{
				int temp=arr[low];
				arr[low]=arr[mid];
				arr[mid]=temp;
				low++;
				mid++;
			}
			else if(arr[mid]==1)
			{
				mid++;
			}
			else
			{
				int temp=arr[mid];
				arr[mid]=arr[high];
				arr[high]=temp;
				high--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void sortArray2(int[] arr) {
		
		int n=arr.length,count0=0,count1=0,count2=0;
		int newArr[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				count0++;
			}
			if(arr[i]==1)
			{
				count1++;
			}
			if(arr[i]==2)
			{
				count2++;
			}
		}
		
		for(int i=0;i<count0;i++)
		{
			newArr[i]=0;
		}
		
		for(int i=count0;i<count0+count1;i++)
		{
			newArr[i]=1;
		}
		
		for(int i=count0+count1;i<n;i++)
		{
			newArr[i]=2;
		}
		
		System.out.println(Arrays.toString(newArr));
	}

	private static void sortArray1(int[] arr) {

		Arrays.parallelSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}

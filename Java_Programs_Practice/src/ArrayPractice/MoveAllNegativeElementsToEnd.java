package ArrayPractice;

import java.util.Arrays;

public class MoveAllNegativeElementsToEnd {

	public static void main(String[] args) {
		
		int arr[] = {1, -1, 3, 2, -7, -5, 11, 6};
		
		moveAllNegativeElementsBrute(arr);
		moveAllNegativeElementsOptimal(arr);
	}

	private static void moveAllNegativeElementsOptimal(int[] arr) {
		
		int n=arr.length,j=-1;
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				j=i;
				break;
			}
		}
		
		if(j==-1)
		{
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=j+1;j<n;j++)
		{
			if(arr[i]>0)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void moveAllNegativeElementsBrute(int[] arr) {
		
		int n=arr.length,j=0;
		int temp[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				temp[j++]=arr[i];
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				temp[j++]=arr[i];
			}
		}
		
		j=0;
		for(int i=0;i<n;i++)
		{
			arr[j++]=temp[i];
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

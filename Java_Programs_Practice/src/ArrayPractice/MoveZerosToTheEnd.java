package ArrayPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToTheEnd {

	public static void main(String[] args) {
		
		int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
		
		moveZeroesBrute(arr,arr.length);
		moveZeroesOptimal(arr,arr.length);

	}

	private static void moveZeroesOptimal(int[] arr, int n) {
		
		int j=-1;
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				j=i;
				break;
			}
		}
		
		for(int i=j+1;i<n;i++)
		{
			if(arr[i]!=0)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void moveZeroesBrute(int[] arr, int n) {
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]!=0)
			{
				resultList.add(arr[i]);
			}
		}
		
		for(int i=0;i<resultList.size();i++)
		{
			arr[i]=resultList.get(i);
		}
		
		for(int i=resultList.size();i<n;i++)
		{
			arr[i]=0;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

package Arrayprograms.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternatePositiveAndNegativeNumbers {

	public static void main(String[] args) {
		
		int arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
		
		alternatePosNeg(arr);

	}

	private static void alternatePosNeg(int[] arr) {
		
		int n=arr.length;
		
		ArrayList<Integer> positiveList=new ArrayList<Integer>();
		ArrayList<Integer> negativeList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				negativeList.add(arr[i]);
			}
			else
			{
				positiveList.add(arr[i]);
			}
		}
		
		int x=0,y=0,k=0;
		
		while(k<n)
		{
			if(x<positiveList.size())
			{
				arr[k]=positiveList.get(x);
				x++;
				k++;
			}
			if(y<negativeList.size())
			{
				arr[k]=negativeList.get(y);
				y++;
				k++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

package Arrayprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceEachElementByRank {

	public static void main(String[] args) {
		
		int[] arr = { 100, 2, 70, 12 , 90};
		
		changeArr1(arr);
		changeArr2(arr);
	}

	private static void changeArr2(int[] arr) {
		
		int n=arr.length;
		int temp[]=arr.clone();
		
		Arrays.sort(temp);
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.putIfAbsent(temp[i],map.size()+1);
		}
		
		int result[]=new int[n];
		
		for(int j=0;j<n;j++)
		{
			result[j]=map.get(arr[j]);
		}
		
		System.out.println(Arrays.toString(result));
	}

	private static void changeArr1(int[] arr) {
		
		int n=arr.length;
		int temp[]=arr.clone();
		
		Arrays.sort(temp);
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i]==temp[j])
				{
					arr[i]=j+1;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

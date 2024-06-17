package Arrayprograms.easy;

import java.util.HashMap;

public class CountPairsWithGivenSum {
	
	public static void main(String[] args) {
		
		int arr[] = {1, 5, 7, 1},n=arr.length,K=6;
		int result=0;
		
		HashMap<Integer,Integer> frequencyMap=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			int remainingValue=K-arr[i];
			
			if(frequencyMap.containsKey(remainingValue))
			{
				result+=frequencyMap.get(remainingValue);
			}
			frequencyMap.put(arr[i],frequencyMap.getOrDefault(arr[i],0)+1);
		}
		
		System.out.println(result);
	}
}

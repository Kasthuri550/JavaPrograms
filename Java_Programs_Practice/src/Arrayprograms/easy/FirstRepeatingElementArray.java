package Arrayprograms.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElementArray {

	public static void main(String[] args) {
		
		int arr[] = {1, 5, 3, 4, 3, 5, 6};
		
		System.out.println(firstRepeatingBrute(arr));
		System.out.println(firstRepeatingOptimal(arr));

	}

	private static int firstRepeatingOptimal(int[] arr) {
		
		Map<Integer,Integer> frequencyMap=new HashMap<Integer, Integer>();
		
		int n=arr.length,firstRepeated=-1;
		
		for(int i=0;i<n;i++)
		{
			frequencyMap.put(arr[i],frequencyMap.getOrDefault(arr[i], 0)+1);
		}
		
		for(int i=0;i<n;i++)
		{
			if(frequencyMap.get(arr[i])>1)
			{
				firstRepeated=i+1;
				break;
			}
		}
		return firstRepeated;
	}

	private static int firstRepeatingBrute(int[] arr) {
		
		int n=arr.length,firstRepeated=-1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					firstRepeated=i+1;
					break;
				}
			}
			
			if (firstRepeated != -1) 
		        break;
		}
		
		return firstRepeated;		
	}
}

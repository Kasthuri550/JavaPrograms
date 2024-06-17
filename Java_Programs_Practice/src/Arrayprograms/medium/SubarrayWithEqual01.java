package Arrayprograms.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithEqual01 {

	public static void main(String[] args) {
		
		int arr[] = {1,0,0,1,0,1,1};
		
		subarrayWithEqual0sAnd1s(arr);

	}

	private static void subarrayWithEqual0sAnd1s(int[] arr) {
		
		int n=arr.length,sum=0,count=0;
		
		Map<Integer,Integer> frequencyMap=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i]==0?-1:1;
			
			if(sum==0)
				count++;
			
			if(frequencyMap.containsKey(sum))
			{
				count+=frequencyMap.get(sum);
			}
			
			frequencyMap.put(sum,frequencyMap.getOrDefault(sum,0)+1);
		}
		
		System.out.println(count);
		
	}
}

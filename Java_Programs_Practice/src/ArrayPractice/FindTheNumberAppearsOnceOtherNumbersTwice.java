package ArrayPractice;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberAppearsOnceOtherNumbersTwice {

	public static void main(String[] args) {
		
		 int[] arr = {4, 1, 2, 1, 2};
		 
		 System.out.println(NumberAppearOnceBrute(arr,arr.length));
		 System.out.println(NumberAppearOnceBetter1(arr,arr.length));
		 System.out.println(NumberAppearOnceBetter2(arr,arr.length));
		 System.out.println(NumberAppearOnceOptimal(arr,arr.length));
	}

	private static int NumberAppearOnceOptimal(int[] arr, int n) {
		
		int xor=0;
		
		for(int i=0;i<n;i++)
		{
			xor=xor^arr[i];
		}
		
		return xor;
	}

	private static int NumberAppearOnceBetter2(int[] arr, int n) {
		
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:hashMap.entrySet())
		{
			if(entry.getValue()==1)
				return entry.getKey();
		}
		
		return -1;
	}

	private static int NumberAppearOnceBetter1(int[] arr, int n) {
		
		int max=0;
		
		for(int i=0;i<n;i++)
		{
			max=Math.max(max,arr[i]);
		}
		
		int hash[]=new int[max+1];
		
		for(int i=0;i<n;i++)
		{
			hash[arr[i]]++;
		}
		
		for(int i=0;i<n;i++)
		{
			if(hash[arr[i]]==1)
				return arr[i];
		}
		
		return -1;
	}

	private static int NumberAppearOnceBrute(int[] arr, int n) {
		
		
		for(int i=0;i<n;i++)
		{
			int count=0;
			
			for(int j=0;j<n;j++)
			{
				if(arr[i]==arr[j])
					count++;
			}
			
			if(count==1)
				return arr[i];
		}
		
		return -1;
	}
}

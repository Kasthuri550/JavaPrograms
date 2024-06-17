package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementN3 {

	public static void main(String[] args) {
		
		 int[] arr = {11, 33, 33, 11, 33, 11};
		 
//		 majorityBrute(arr);
		 majorityBetter(arr);
		 majorityOptimal(arr);

	}

	private static void majorityOptimal(int[] arr) {
		
		int n=arr.length,count1=0,count2=0,element1=0,element2=0;
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(count1==0 && element2!=arr[i])
			{
				count1=1;
				element1=arr[i];				
			}
			else if(count2==0 && element1!=arr[i])
			{
				count2=1;
				element2=arr[i];
			}
			else if(element1==arr[i])
			{
				count1++;
			}
			else if(element2==arr[i])
			{
				count2++;
			}
			else
			{
				count1--;
				count2--;
			}
		}
		
		count1=0;count2=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==element1) count1++;
			if(arr[i]==element2) count2++;
		}
		
		int min=(n/3)+1;
		
		if(count1>=min)
		{
			resultList.add(element1);
		}
		
		if(count2>=min)
		{
			resultList.add(element2);
		}
		
		System.out.println(resultList);
		
	}

	private static void majorityBetter(int[] arr) {
		
		int n=arr.length,min=(n/3)+1;
		
		Map<Integer,Integer> frequencyMap=new HashMap<>();
		ArrayList<Integer> resultList=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			frequencyMap.put(arr[i],frequencyMap.getOrDefault(arr[i],0)+1);
			
			if(frequencyMap.get(arr[i])==min)
			{
				resultList.add(arr[i]);
			}
			
			if(resultList.size()==2) break;
		}
		
		System.out.println(resultList);
		
	}

	private static void majorityBrute(int[] arr) {
		
		int n=arr.length;
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			int count=0;
			
			if(resultList.size()==0 || resultList.get(0)!=arr[i])
			{
				for(int j=0;j<n;j++)
				{
					if(arr[i]==arr[j])
						count++;
				}
				
				if(count>n/3)
					resultList.add(arr[i]);	
			}
			
			if(resultList.size()==2) break;				
		}
		
		System.out.println(resultList);
	}
}

package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementNdiv3times {

	public static void main(String[] args) {
		
		int[] arr = {11, 33, 33, 11, 33, 11};
		majorElement1(arr,arr.length);
		majorElement2(arr,arr.length);
		majorElement3(arr,arr.length);
		majorElement4(arr,arr.length);
	}

	private static void majorElement4(int[] arr, int n) {
		
		int count0=0,count1=0;
		int min=(n/3)+1,ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(count0==0)
			{
				count0=1;
				ele1=arr[i];
			}
			else if(count1==0)
			{
				count1=1;
				ele2=arr[i];						
			}
			else if(ele1 == arr[i])
			{
				count0++;
			}
			else if(ele2 == arr[i])
			{
				count1++;
			}
			else
			{
				count0--;
				count1--;
			}
		}
		
		count0=0;count1=0;
		for(int i=0;i<n;i++)
		{
			if(ele1==arr[i])
			{
				count0++;
			}
			if(ele2 == arr[i])
			{
				count1++;
			}
		}
		
		if(count0>=min)
		{
			list.add(ele1);
		}
		
		if(count1>=min)
		{
			list.add(ele2);
		}
		
		System.out.println(list);
	}

	private static void majorElement3(int[] arr, int n) {
		
		List<Integer> list=new ArrayList<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int min=(n/3)+1;
		
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);	
			
			if(map.get(arr[i])>=min)
			{
				list.add(arr[i]);
			}
			
			if(list.size()==2) break;
		}
		
		System.out.println(list);
		
	}

	private static void majorElement2(int[] arr, int n) {
		
		List<Integer> list=new ArrayList<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue()>n/3)
			{
				list.add(entry.getKey());
			}
		}
		
		System.out.println(list);
	}

	private static void majorElement1(int[] arr, int n) {
		
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(list.size()==0 || list.get(0)!=arr[i])
			{
				int count=0;
				for(int j=0;j<n;j++)
				{
					if(arr[i]==arr[j])
					{
						count++;
					}
				}
				
				if(count > n/3)
				{
					list.add(arr[i]);
				}
			}
			if(list.size()==2) break;
		}
		
		System.out.println(list);
		
	}
}

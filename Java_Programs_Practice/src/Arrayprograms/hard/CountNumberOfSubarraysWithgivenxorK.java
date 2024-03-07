package Arrayprograms.hard;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubarraysWithgivenxorK {

	public static void main(String[] args) {
		
		int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        subarrayWithXorKBrute(a,a.length,k);
        subarrayWithXorKBetter(a,a.length, k);
        subarrayWithXorKOptimal(a, a.length, k);
	}

	private static void subarrayWithXorKOptimal(int[] a, int n, int k) {
		
		int xor=0,count=0;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(0,1);
		
		for(int i=0;i<n;i++)
		{
			xor=xor^a[i];
			int x=xor^k;
			
			if(map.containsKey(x))
			{
				count+=map.get(x);
			}
			if(map.containsKey(xor))
			{
				map.put(xor,map.get(xor)+1);
			}
			else
			{
				map.put(xor,1);
			}
		}
		
		System.out.println(count);
	}

	private static void subarrayWithXorKBetter(int[] a, int n, int k) {
		
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			int xor=0;
			for(int j=i;j<n;j++)
			{
				xor=xor^a[j];
			
				if(xor==k)
				{
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	private static void subarrayWithXorKBrute(int[] a, int n, int k) {
		
		int count=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int xor=0;
				for(int h=i;h<=j;h++)
				{
					xor=xor^a[h];
				}
				
				if(xor==k)
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

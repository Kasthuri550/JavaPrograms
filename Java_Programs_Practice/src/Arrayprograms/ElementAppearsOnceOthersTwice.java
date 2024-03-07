package Arrayprograms;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearsOnceOthersTwice {

	public static void main(String[] args) {
		
		int N = 5;
		int A[] = {1, 1, 2, 5, 5};
		
		System.out.println(elementOnce1(A,N));
		System.out.println(elementOnce2(A, N));
		System.out.println(elementOnce3(A, N));
		System.out.println(elementOnce4(A, N));
	}

	private static int elementOnce4(int[] a, int n) {
		
		int xor=0;
		for(int i=0;i<n;i++)
		{
			xor=xor^a[i];
		}
		return xor;
	}

	private static Integer elementOnce3(int[] a, int n) {
		
		Map<Integer,Integer> freqMap=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			freqMap.put(a[i],freqMap.getOrDefault(a[i], 0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:freqMap.entrySet())
		{
			if(entry.getValue()==1)
			{
				return entry.getKey();
			}
		}
		return -1;
	}

	private static int elementOnce2(int[] a, int n) {
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			max=Math.max(max,a[i]);
		}
		
		int hash[]=new int[max+1];
		
		for(int i=0;i<n;i++)
		{
			hash[a[i]]++;
		}
		
		for(int j=0;j<n;j++)
		{
			if(hash[a[j]]==1)
			{
				return a[j];
			}
		}
		
		return -1;
	}
	
// O(n^2)
	private static int elementOnce1(int[] a, int n) {
		
		for(int i=0;i<n;i++)
		{
			int j,count=0;
			for(j=0;j<n;j++)
			{
				if(a[j]==a[i])
				{
					count++;
				}
			}
			
			if(count==1)
			{
				return a[i];
			}
		}
		return -1;
	}
}

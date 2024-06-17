package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RearrangeArrayBySign {

	public static void main(String[] args) {
		
//		 int A[]= {1,2,-4,-5};
		 int A[] = {1,2,-3,-1,-2,-3};
		 
//		 rearrangeBySignBrute(A);
//		 rearrangeBySignBetter(A);
		 rearrangeBySignOptimal(A);

	}

	private static void rearrangeBySignOptimal(int[] a) {
		
		int n=a.length;
		
		ArrayList<Integer> positiveList=new ArrayList<Integer>();
		ArrayList<Integer> negativeList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				positiveList.add(a[i]);
			}
			else
			{
				negativeList.add(a[i]);
			}
		}
		
		if(positiveList.size()<negativeList.size())
		{
			for(int i=0;i<positiveList.size();i++)
			{
				a[2*i]=positiveList.get(i);
				a[2*i+1]=negativeList.get(i);
			}
			
			int index=positiveList.size()*2;
			
			for(int i=positiveList.size();i<negativeList.size();i++)
			{
				a[index++]=negativeList.get(i);
			}
		}
		else
		{
			for(int i=0;i<negativeList.size();i++)
			{
				a[2*i]=positiveList.get(i);
				a[2*i+1]=negativeList.get(i);
			}
			
			int index=negativeList.size()*2;
			
			for(int i=negativeList.size();i<positiveList.size();i++)
			{
				a[index++]=positiveList.get(i);
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}

	private static void rearrangeBySignBetter(int[] a) {
		
		int positiveIndex=0,negativeIndex=1,n=a.length;
		
		ArrayList<Integer> resultList=new ArrayList<Integer>(Collections.nCopies(n, 0));
		
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				resultList.set(positiveIndex, a[i]);
				positiveIndex+=2;
			}
			else
			{
				resultList.set(negativeIndex, a[i]);
				negativeIndex+=2;
			}
		}
		
		System.out.println(resultList);
		
	}

	private static void rearrangeBySignBrute(int[] a) {
		
		int n=a.length;
		
		ArrayList<Integer> positiveList=new ArrayList<>();
		ArrayList<Integer> negativeList=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				positiveList.add(a[i]);
			}
			else
			{
				negativeList.add(a[i]);
			}
		}
		
		for(int i=0;i<n/2;i++)
		{
			a[2*i]=positiveList.get(i);
			a[2*i+1]=negativeList.get(i);
		}
		
		System.out.println(Arrays.toString(a));
		
	}
}

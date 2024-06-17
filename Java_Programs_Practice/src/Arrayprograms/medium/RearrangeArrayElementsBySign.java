package Arrayprograms.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RearrangeArrayElementsBySign {

	public static void main(String[] args) {
		
		int arr[] = {1,2,-4,-5}, N = 4;
		
//		rearrangeArray1(arr);
//		rearrangeArray2(arr);
		rearrangeArray3(arr);

	}

	private static void rearrangeArray3(int[] arr) {
		
		int n=arr.length;
		ArrayList<Integer> pos=new ArrayList<Integer>();
		ArrayList<Integer> neg=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				pos.add(arr[i]);
			}
			else
			{
				neg.add(arr[i]);
			}
		}
		
		
		if(pos.size()<neg.size())
		{
			for(int i=0;i<pos.size();i++)
			{
				arr[2*i]=pos.get(i);
				arr[2*i+1]=neg.get(i);
			}
			
			int index=pos.size()*2;
			for(int i=pos.size();i<neg.size();i++)
			{
				arr[index]=neg.get(i);
				index++;
			}
		}
		else
		{
			for(int i=0;i<neg.size();i++)
			{
				arr[2*i]=pos.get(i);
				arr[2*i+1]=neg.get(i);
			}
			
			int index=neg.size()*2;
			
			for(int i=neg.size();i<pos.size();i++)
			{
				arr[index]=pos.get(i);
				index++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void rearrangeArray2(int[] arr) {
		
		int posIndex=0,negIndex=1,n=arr.length;
		
		ArrayList<Integer> result=new ArrayList<Integer>(Collections.nCopies(n, 0));
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				result.set(posIndex,arr[i]);
				posIndex+=2;
			}
			else
			{
				result.set(negIndex,arr[i]);
				negIndex+=2;
			}
		}
		result.forEach(System.out::println);
		
	}

	private static void rearrangeArray1(int[] arr) {
		
		int n=arr.length;
		ArrayList<Integer> pos=new ArrayList<Integer>();
		ArrayList<Integer> neg=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				pos.add(arr[i]);
			}
			else
			{
				neg.add(arr[i]);
			}
		}
		
		for(int i=0;i<n/2;i++)
		{
			arr[2*i]=pos.get(i);
			arr[2*i+1]=neg.get(i);
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

package Arrayprograms;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		
		int arr[] = {11, 13, 21, 3 };
	    int n = arr.length;
//	    nextSmaller1(arr, n);
	    nextSmaller2(arr,n);
	    nextSmaller3(arr,n);
	}

	private static void nextSmaller3(int[] arr, int n) {
		
		Stack<Integer> stack=new Stack<Integer>();
		int nse[]=new int[n];
		
		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && stack.peek()>=arr[i])
			{
				stack.pop();
			}
			
			nse[i]=stack.isEmpty()?-1:stack.peek();
			
			stack.push(arr[i]);			
		}
		System.out.println(Arrays.toString(nse));
		
	}

	private static void nextSmaller2(int[] arr, int n) {
		
		int nse[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					nse[i]=arr[j];
					break;
				}
				else
				{
					nse[i]=-1;
				}
			}
		}
		nse[n-1]=-1;
			System.out.println(Arrays.toString(nse));
		
	}

	private static void nextSmaller1(int[] arr, int n) {
		
		int nse[]=new int[n];
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				nse[i]=arr[i+1];
			}
			else
			{
				nse[i]=-1;
			}
		}
		
		nse[n-1]=-1;
		System.out.println(Arrays.toString(nse));
		
	}

}

package Arrayprograms;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {

	public static void main(String[] args) {
		
		int arr[] = {10, 4, 2, 20, 40, 12, 30};
	    int n = arr.length;
	    previousGreater1(arr, n);
	    previousGreater2(arr, n);
	    previousGreater3(arr, n);
	}

	private static void previousGreater3(int[] arr, int n) {
		
		int pge[]=new int[n];
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && stack.peek()<=arr[i])
			{
				stack.pop();
			}
			
			pge[i]=stack.isEmpty()?-1:stack.peek();
			
			stack.push(arr[i]);
		}
		System.out.println(Arrays.toString(pge));
		
	}

	private static void previousGreater2(int[] arr, int n) {
		
		int pge[]=new int[n];
		pge[0]=-1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(arr[i]<arr[j])
				{
					pge[i]=arr[j];
					break;
				}
				else
				{
					pge[i]=-1;
				}
			}
		}
		
		System.out.println(Arrays.toString(pge));
	}

	private static void previousGreater1(int[] arr, int n) {
		
		int pge[]=new int[n];
		pge[0]=-1;
		for(int i=1;i<=n-1;i++)
		{
			if(arr[i]<arr[i-1])
			{
				pge[i]=arr[i-1];
			}
			else
			{
				pge[i]=-1;
			}
		}
		if(pge[n-1]==-1)
		{
			pge[n-1]=pge[n-2];
		}
		
		System.out.println(Arrays.toString(pge));
	}
}

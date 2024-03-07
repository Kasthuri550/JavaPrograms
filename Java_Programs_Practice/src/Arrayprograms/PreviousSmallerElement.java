package Arrayprograms;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {

	public static void main(String[] args) {
		
		int arr[] = {2, 5, 3, 7, 8, 1, 9};
	    int n = arr.length;
	    
	    previousSmaller1(arr,n);
	    previousSmaller2(arr, n);

	}

	private static void previousSmaller2(int[] arr, int n) {
		
		Stack<Integer> stack=new Stack<Integer>();
		int pse[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && stack.peek()>=arr[i])
			{
				stack.pop();
			}
			
			pse[i]=stack.isEmpty()?-1:stack.peek();
			stack.push(arr[i]);
		}
		
		System.out.println(Arrays.toString(pse));
		
	}

	private static void previousSmaller1(int[] arr, int n) {
		
		int pse[]=new int[n];
		pse[0]=-1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(arr[i]>arr[j])
				{
					pse[i]=arr[j];
					break;
				}
				else
					pse[i]=-1;
			}
		}
		
		System.out.println(Arrays.toString(pse));
	}
}

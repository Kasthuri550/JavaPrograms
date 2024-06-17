package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		
		int N = 4, arr[] = {1, 3, 2, 4};
		
		System.out.println(Arrays.toString(nge(arr,N)));
	}

	private static int[] nge(int[] arr, int n) {
		
		Stack<Integer> stack=new Stack<>();
		int nge[]=new int[n];
		
		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && arr[i]>=stack.peek())
			{
				stack.pop();
			}
			
			if(i<n)
			{
				if(!stack.isEmpty())
				{
					nge[i]=stack.peek();
				}
				else
				{
					nge[i]=-1;
				}
			}
			stack.push(arr[i]);
		}
		
		return nge;
		
	}
}

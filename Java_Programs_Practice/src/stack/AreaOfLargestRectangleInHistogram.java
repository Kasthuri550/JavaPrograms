package stack;

import java.util.Stack;

public class AreaOfLargestRectangleInHistogram {

	public static void main(String[] args) {
		
		 int arr[] = {2, 1, 5, 6, 2, 3, 1};
		 
//		 largestRectangleBrute(arr);
		 largestRectangleOptimal(arr);

	}

	private static void largestRectangleOptimal(int[] arr) {
		
		Stack<Integer> stack=new Stack<>();
		int n=arr.length;
		int leftSmall[]=new int[n];
		int rightSmall[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && arr[i]<=stack.peek())
			{
				stack.pop();
			}
			
			leftSmall[i]=stack.isEmpty()?0:stack.peek()+1;
			
			stack.push(arr[i]);
		}
		
		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && arr[i]<=stack.peek())
			{
				stack.pop();
			}
			
			rightSmall[i]=stack.isEmpty()?n-1:stack.peek()-1;
			
			stack.push(arr[i]);
		}
		
		int maxArea=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			maxArea=Math.max(maxArea,arr[i]*(rightSmall[i]-leftSmall[i]+1));
		}
		System.out.println(maxArea);
	}

	private static void largestRectangleBrute(int[] arr) {
		
		int n=arr.length,maxArea=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int min=Integer.MAX_VALUE;
			for(int j=i;j<n;j++)
			{
				min=Math.min(min,arr[j]);
				maxArea=Math.max(maxArea,min*(j-i+1));
			}
		}
		System.out.println(maxArea);
	}

}

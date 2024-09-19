package DynamicProgramming.squares;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		
		int arr[] = {2, 1, 5, 6, 2, 3, 1};
        int n = 7;
		
//		System.out.println(largestRectangleInHistogramApproach1(n,arr));
		System.out.println(largestRectangleInHistogramApproach2(n, arr));
		System.out.println(largestRectangleInHistogramApproach3(n,arr));
		

	}

	private static int largestRectangleInHistogramApproach3(int n, int[] arr) {

		Stack<Integer> stack=new Stack<>();
		int maxArea=0;
		
		for(int i=0;i<=n;i++)
		{
			while(!stack.isEmpty() && (i==n||arr[stack.peek()]>=arr[i]))
			{
				int height=arr[stack.peek()];
				stack.pop();
				
				int width;
				if(stack.isEmpty())
					width=i;
				else
					width=i-stack.peek()-1;
				
				maxArea=Math.max(maxArea,width*height);
				
			}
			stack.push(i);
		}
		
		return maxArea;
	}

	private static int largestRectangleInHistogramApproach2(int n, int[] arr) {

		Stack<Integer> stack=new Stack<>();
		int leftSmall[]=new int[n];
		int rightSmall[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
			{
				stack.pop();
			}
			
			if(stack.isEmpty())
				leftSmall[i]=0;
			else
				leftSmall[i]=stack.peek()+1;
				
			stack.push(i);
		}
		
		while(!stack.isEmpty()) stack.pop();
		
		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
			{
				stack.pop();
			}
			
			if(stack.isEmpty())
				rightSmall[i]=n-1;
			else
				rightSmall[i]=stack.peek()-1;
				
			stack.push(i);
		}
		
		int maxArea=0;
		
		for(int i=0;i<n;i++)
		{
			maxArea=Math.max(maxArea,arr[i]*(rightSmall[i]-leftSmall[i]+1));
		}
		
		return maxArea;
	}

	private static int largestRectangleInHistogramApproach1(int n, int[] arr) {

		int maxArea=0;
		
		for(int i=0;i<n;i++)
		{
			int minHeight=Integer.MAX_VALUE;
			for(int j=i;j<n;j++)
			{
				minHeight=Math.min(minHeight,arr[j]);
				maxArea=Math.max(maxArea,minHeight*(j-i+1));
			}
		}
		return maxArea;
	}
}

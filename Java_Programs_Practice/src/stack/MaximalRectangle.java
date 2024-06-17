package stack;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		
		int M[][] = {{0,1,1,0},
		         {1,1,1,1},
		         {1,1,1,1},
		         {1,1,0,0}};
		int n=M.length,m=M[0].length;
		
		System.out.println(maxArea(M,n,m));

	}

	private static int maxArea(int M[][], int n, int m) {
		
		int max=maxAreaHistogram(M[0]);
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(M[i][j]==1)
				{
					M[i][j]+=M[i-1][j];
				}
			}
			
			max=Math.max(max,maxAreaHistogram(M[i]));
		}
		
		return max;
		
	}

	private static int maxAreaHistogram(int[] hist) {
		
		int i=0,n=hist.length,max=0;	
		
		Stack<Integer> stack=new Stack<>();
		
		while(i<n)
		{
			if(stack.isEmpty()|| hist[stack.peek()]<=hist[i])
			{
				stack.push(i++);
			}
			else
			{
				int height=hist[stack.pop()];
				int width=stack.isEmpty()?i:i-stack.peek()-1;
				max=Math.max(max,width*height);
			}
		}
		
		while(!stack.isEmpty())
		{
			int height=hist[stack.pop()];
			int width=stack.isEmpty()?i:i-stack.peek()-1;
			max=Math.max(max,height*width);
		}
		
		return max;
		
	}
}

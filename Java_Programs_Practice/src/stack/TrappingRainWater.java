package stack;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//		trapRainWaterBrute(arr);
//		trapRainWaterBetter(arr);
//		trapRainWaterOptimal(arr);
		trapRainWaterStack(arr);
	}

	private static void trapRainWaterStack(int[] arr) {
		
		int n=arr.length,waterTrapped=0;
		
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i])
			{
				int top=arr[stack.peek()];
				stack.pop();
				if(stack.isEmpty()) break;
				
				int wallHeight=Math.min(arr[stack.peek()],arr[i])-top;
				int width=i-stack.peek()-1;
				waterTrapped+=wallHeight*width;
			}
			stack.push(i);
		}
		
		System.out.println(waterTrapped);
		
	}

	private static void trapRainWaterOptimal(int[] arr) {
		
		int n=arr.length,result=0;
		int left=0,right=n-1;
		int leftmax=0,rightmax=0;
		
		while(left<=right)
		{
			if(arr[left]<=arr[right])
			{
				if(arr[left]>=leftmax)
				{
					leftmax=arr[left];
				}
				else
				{
					result+=leftmax-arr[left];
				}
				left++;
			}
			else
			{
				if(arr[right]>=rightmax)
				{
					rightmax=arr[right];
				}
				else
				{
					result+=rightmax-arr[right];
				}
				right--;
			}
		}
		System.out.println(result);
	}

	private static void trapRainWaterBetter(int[] arr) {
		
		int n=arr.length,waterTrapped=0;
		int prefix[]=new int[n];
		int suffix[]=new int[n];
		
		prefix[0]=arr[0];
		for(int i=1;i<n;i++)
		{
			prefix[i]=Math.max(prefix[i-1],arr[i]);
		}
		
		suffix[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--)
		{
			suffix[i]=Math.max(suffix[i+1],arr[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			waterTrapped+=Math.min(prefix[i],suffix[i])-arr[i];
		}
		System.out.println(waterTrapped);
	}

	private static void trapRainWaterBrute(int[] arr) {
		
		int n=arr.length,waterTrapped=0;
		
		for(int i=0;i<n;i++)
		{
			int leftmax=0,rightmax=0,j=i;
			
			while(0<=j)
			{
				leftmax=Math.max(leftmax,arr[j]);
				j--;
			}
			
			j=i;
			while(j<n)
			{
				rightmax=Math.max(rightmax, arr[j]);
				j++;
			}
			
			waterTrapped+=Math.min(leftmax, rightmax)-arr[i];
		}
		
		System.out.println(waterTrapped);
		
	}
}

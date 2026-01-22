package stack.medium;

import java.util.Arrays;
import java.util.Stack;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class PreviousSmallerElement {

	public static void main(String[] args) {

		int arr[] = {4, 5, 2, 10, 8};

		previousSmallerElement(arr,arr.length);
	}

	private static void previousSmallerElement(int[] arr, int n) {

		Stack<Integer> stack=new Stack<>();
		int pse[]=new int[n];

		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && arr[i]<=stack.peek())
			{
				stack.pop();
			}

			pse[i]=stack.isEmpty()?-1:stack.peek();
			stack.push(arr[i]);
		}

		System.out.println(Arrays.toString(pse));
	}
}

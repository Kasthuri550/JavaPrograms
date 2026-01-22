package stack.medium;

import java.util.Arrays;
import java.util.Stack;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class PreviousGreaterElement {

	public static void main(String[] args) {

		int arr[] = {4, 5, 2, 10, 8};

		previousGreaterElement(arr,arr.length);
	}

	private static void previousGreaterElement(int[] arr, int n) {

		Stack<Integer> stack=new Stack<>();
		int pge[]=new int[n];


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
}

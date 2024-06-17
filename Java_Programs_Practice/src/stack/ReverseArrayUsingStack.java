package stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArrayUsingStack {

	public static void main(String[] args) {
		
		int[] a = new int[] { 100, 200, 300, 400 };
		
		reverse(a);

	}

	private static void reverse(int[] a) {

		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<a.length;i++)
		{
			stack.push(a[i]);
		}
		
		int i=0;
		while(!stack.isEmpty())
		{
			a[i++]=stack.pop();
		}
		
		System.out.println(Arrays.toString(a));
	}
}

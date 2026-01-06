package Stringprograms;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {

	public static void main(String[] args) {
		
		String s = "(1+(2*3)+((8)/4))+1";		
		maximumNestingDepthParentheses1(s);
//		maximumNestingDepthParentheses2(s);
	}

	private static void maximumNestingDepthParentheses2(String s) {
		
		int max=0;
		Stack<String> stack=new Stack<String>();
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
			{
				stack.push("(");
			}
			if(s.charAt(i)==')')
			{
				stack.pop();
			}
			max=Math.max(max, stack.size());
		}
		
		System.out.println(max);
	}

	private static void maximumNestingDepthParentheses1(String s) {
		
		int max=0,count=0;
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
			{
				count++;
			}
			if(s.charAt(i)==')')
			{
				count--;
			}
			max=Math.max(count, max);
		}		
		System.out.println(max);
	}
}

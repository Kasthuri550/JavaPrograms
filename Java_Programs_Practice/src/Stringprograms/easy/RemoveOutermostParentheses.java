package Stringprograms.easy;

import java.util.Stack;

public class RemoveOutermostParentheses {

	public static void main(String[] args) {
		
		String s = "(()())(())";
		
		removeOuterMostParenthesesBrute(s);
		removeOuterMostParenthesesOptimal(s);

	}

	private static void removeOuterMostParenthesesOptimal(String s) {
		
		int open=0,close=0,n=s.length(),start=0;
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='(')
			{
				open++;
			}
			else
			{
				close++;
			}
			
			if(open==close)
			{
				sb.append(s.substring(start+1,i));
				start=i+1;
			}
		}
		
		System.out.println(sb.toString());
		
	}

	private static void removeOuterMostParenthesesBrute(String s) {
		
		int n=s.length();
		Stack<Character> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='(')
			{
				if(stack.size()>0)
				{
					sb.append(s.charAt(i));
				}
				stack.push(s.charAt(i));
			}
			else
			{
				stack.pop();
				
				if(stack.size()>0)
				{
					sb.append(s.charAt(i));
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}

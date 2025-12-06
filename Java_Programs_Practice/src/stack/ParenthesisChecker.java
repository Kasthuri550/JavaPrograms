package stack;

import java.util.Stack;
/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class ParenthesisChecker {

	public static void main(String[] args) {

		String s = "[()()]{}";
		
		System.out.println(parenthesisChecker(s));
	}
	
	private static boolean parenthesisChecker(String s)
	{
		if(s.isEmpty())
			return true;
		
		Stack<Character> stack=new Stack<>();
		
		for(char ch:s.toCharArray())
		{
			if(ch=='(' || ch=='[' || ch=='{')
			{
				stack.push(ch);
			}
			else
			{
				if(stack.isEmpty())
					return false;
				
				char top=stack.pop();
				
				if((ch==')' && top!='(') || (ch=='}' && top!='{') || (ch==']' && top!='['))
				{
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}

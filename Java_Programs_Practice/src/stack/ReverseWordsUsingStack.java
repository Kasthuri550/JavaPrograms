package stack;

import java.util.Stack;

public class ReverseWordsUsingStack {

	public static void main(String[] args) {
		
		String str = "Geeks for Geeks";
		
		reverseWords(str);

	}

	private static void reverseWords(String str) {
		
		
		Stack<Character> stack=new Stack<>();
		String concat="";
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=' ')
			{
				stack.push(str.charAt(i));
			}
			else
			{
				while(stack.empty()==false)
				{
					concat+=stack.pop();
				}
				concat+=" ";
			}
		}
		
		while(stack.empty()==false)
		{
			concat+=stack.pop();
		}
		
		System.out.println(concat);
	}
}

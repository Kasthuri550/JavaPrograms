package stack;

import java.util.Stack;

/*
 * Time Complexity:O(n)
 * Space Complexity: O(n)
 * */
public class InfixToPrefixExpression {

	public static void main(String[] args) {

		String infix = "(a+b)*c-d/e";

		System.out.println(infixToPrefix(infix));
	}

	private static String infixToPrefix(String infix) {

		String reversedInfix=new StringBuilder(infix).reverse().toString();
		StringBuilder result=new StringBuilder();

		Stack<Character> stack=new Stack<>();

		for(int i=0;i<reversedInfix.length();i++)
		{
			char c=reversedInfix.charAt(i);
			if(Character.isLetterOrDigit(c))
			{
				result.append(c);
			}
			else if(c==')')
			{
				stack.push(c);
			}
			else if(c=='(')
			{
				while(!stack.isEmpty() && stack.peek()!=')')
				{
					result.append(stack.pop());
				}

				stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek()))
				{
					result.append(stack.pop());
				}

				stack.push(c);
			}
		}

		return result.reverse().toString();	
	}

	private static int precedence(char c) {

		switch(c)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
}

package stack;

import java.util.Stack;

public class InfixToPostfixExpression {

	public static void main(String[] args) {
		
		 String exp = "3^(1+1)";
		 
		 System.out.println(infixToPostfix(exp));
	}

	private static String infixToPostfix(String exp) {
		
		Stack<Character> stack=new Stack<>();
		StringBuilder result=new StringBuilder();
		
		for(char c:exp.toCharArray())
		{
			if(Character.isLetterOrDigit(c))
			{
				result.append(c);
			}
			else if(c=='(')
			{
				stack.push(c);
			}
			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek()!='(')
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
		
		while(!stack.isEmpty())
		{
			result.append(stack.pop());
		}
		
		return result.toString();
		
	}

	private static int precedence(char c) {
		
		switch(c)
		{
			case '^':
				return 3;
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				return -1;
		}
	}
}

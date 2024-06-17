package stack;

import java.util.Stack;

public class PostfixToPrefixExpression {

	public static void main(String[] args) {
		
		String postfix="ABC/-AK/L-*";
		
		System.out.println(postfixToPrefix(postfix));
	}

	private static String postfixToPrefix(String postfix) {
		
		Stack<String> stack=new Stack<>();
		
		for(int i=0;i<postfix.length();i++)
		{
			char c=postfix.charAt(i);
			
			if(isOperator(c))
			{
				String operand2=stack.pop();
				String operand1=stack.pop();
				String prefix=c+operand1+operand2;
				stack.push(prefix);
			}
			else
			{
				stack.push(Character.toString(c));
			}
		}
		
		return stack.pop();
	}

	private static boolean isOperator(char c) {
		
		return (c=='+'||c=='-'||c=='*'||c=='/'||c=='^');
	}
}

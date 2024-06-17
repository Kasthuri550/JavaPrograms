package stack;

import java.util.Stack;

public class PrefixToPostfixExpression {

	public static void main(String[] args) {

		String prefix="*-A/BC-/AKL";
		
		System.out.println(prefixToPostfix(prefix));
	}

	private static String prefixToPostfix(String prefix) {
		
		Stack<String> stack=new Stack<>();
				
		for(int i=prefix.length()-1;i>=0;i--)
		{
			char c=prefix.charAt(i);
			if(isOperator(c))
			{
				String operand1=stack.pop();
				String operand2=stack.pop();
				String postfix=operand1+operand2+c;
				stack.push(postfix);
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

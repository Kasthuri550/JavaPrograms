package stack;

import java.util.Stack;

/*
 * Time Complexity:O(n)
 * Space Complexity: O(n)
 * */
public class PostfixToInfixExpression {

	public static void main(String[] args) {

		String postfixExp = "ab+c+d+e-";

		System.out.println(postfixToInfix(postfixExp));
	}

	private static String postfixToInfix(String postfixExp) {

		Stack<String> stack=new Stack<>();

		for(char c:postfixExp.toCharArray())
		{
			if(Character.isLetterOrDigit(c))
			{
				stack.push(String.valueOf(c));
			}
			else
			{
				String operand2=stack.pop();
				String operand1=stack.pop();
				String result="("+operand1+c+operand2+")";
				stack.push(result);
			}
		}

		return stack.pop();
	}
}

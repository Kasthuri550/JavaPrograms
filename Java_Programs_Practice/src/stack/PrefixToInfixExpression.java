package stack;

import java.util.Stack;

/*
 * Time Complexity:O(n)
 * Space Complexity: O(n)
 * */
public class PrefixToInfixExpression {

	public static void main(String[] args) {

		String prefix = "*-A/BC-/AKL";

		System.out.println(prefixToInfix(prefix));
	}

	private static String prefixToInfix(String prefix) {

		Stack<String> stack=new Stack<>();

		for(int i=prefix.length()-1;i>=0;i--)
		{
			char c=prefix.charAt(i);
			if(!isOperator(c))
			{
				stack.push(Character.toString(c));
			}
			else
			{
				String operand1=stack.pop();
				String operand2=stack.pop();

				String result="("+operand1+c+operand2+")";
				stack.push(result);
			}
		}

		return stack.pop();		
	}

	private static boolean isOperator(char c) {
		

		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^')
		{
			return true;
		}

		return false;
	}

}

package Arrayprograms;

import java.util.Stack;

public class PostfixExpression {
	
	public static void main(String[] args) {
		
		String arr[]= {"1","2","/"};
		
		System.out.println(compute(arr,arr.length));	
	}

	private static Integer compute(String[] arr, int n) {
		
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(isNumeric(arr[i]))
			{
				stack.push(Integer.parseInt(arr[i]));
			}
			else
			{
				int operand2=stack.pop();
				int operand1=stack.pop();
				
				switch(arr[i])
				{
				
				case "+":
					stack.push(operand1+operand2);
					break;
				case "-":
					stack.push(operand1-operand2);
					break;
				case "*":
					stack.push(operand1*operand2);
					break;
				case "/":
					stack.push(operand1/operand2);
					break;
				default:
					throw new IllegalArgumentException("Invalid operator "+arr[i]);
				}
			}
		}
		
		if(stack.size()!=1)
		{
			throw new IllegalArgumentException("Invalid postfix");
		}
		
		return stack.pop();		
	}
	
	private static boolean isNumeric(String token)
	{
		try
		{
			Integer.parseInt(token);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}

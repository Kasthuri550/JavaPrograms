package stack;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		
		String num = "1432219";
        int k = 3;
        
        System.out.println(lowestNumber(num,k));

	}

	private static String lowestNumber(String num, int k) {
		
		Stack<Character> stack=new Stack<>();
		
		for(char c:num.toCharArray())
		{
			while(!stack.isEmpty() && k>0 && stack.peek() > c)
			{
				stack.pop();
				k--;
			}
			
			if(!stack.isEmpty() || c!='0')
			{
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty() && k-- > 0)
		{
			stack.pop();
		}
		
		if(stack.isEmpty())
		{
			return "0";
		}
		
		StringBuilder result=new StringBuilder();
		StringBuilder concat=new StringBuilder();
		
		while(!stack.isEmpty())
		{
			char pop=stack.pop();
			result.insert(0,pop);
			concat.append(pop);
		}
		System.out.println(concat.toString());
		return result.toString();
		
	}
}

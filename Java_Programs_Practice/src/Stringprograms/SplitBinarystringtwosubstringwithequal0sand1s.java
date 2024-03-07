package Stringprograms;

import java.util.Stack;

public class SplitBinarystringtwosubstringwithequal0sand1s {

	public static void main(String[] args) {
		
		String str ="0100110101";
		System.out.println(checkequal0and1(str));
		System.out.println(Splitcheckequal0and1(str));
	}

	private static int Splitcheckequal0and1(String str) {
		
		int stringLength=str.length(),i=0,ans=0;
		
		Stack<Character> stack=new Stack<Character>();
		stack.push(str.charAt(i));
		i++;
		while(i<stringLength)
		{
			while(i<stringLength && !stack.empty() && stack.peek()!=str.charAt(i))
			{
				stack.pop();
				i++;				
			}
			if(stack.isEmpty())
			{
				ans++;
			}
			while(i<stringLength && (stack.empty() || stack.peek()==str.charAt(i)))
			{
				stack.push(str.charAt(i));
				i++;
			}
		}
		
		if(stack.isEmpty())
		{
			return ans;
		}
		return -1;
	}

	private static int checkequal0and1(String str) {
		
		int stringLength=str.length(),count0=0,count1=0,ans=0;
		
		for(int i=0;i<stringLength;i++)
		{
			if(str.charAt(i)=='0')
			{
				count0++;
			}
			else
			{
				count1++;
			}
			if(count0==count1)
			{
				ans++;
			}
		}
		
		if(count0!=count1)
		{
			return -1;
		}
		
		return ans;
		
	}

}

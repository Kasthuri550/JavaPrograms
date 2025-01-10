package Stringprograms.hard;

import java.util.Stack;

public class MinimumNumberOfBracketReversals {

	public static void main(String[] args) {
		
		String S = "}{{}}{{{";
		
		System.out.println(minimumNumberOfBracketReversalsBrute(S));
		System.out.println(minimumNumberOfBracketReversalsBetter(S));
		System.out.println(minimumNumberOfBracketReversalsOptimal(S));

	}
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 */
	private static int minimumNumberOfBracketReversalsOptimal(String s) {
		
		if(s.length()%2!=0) return -1;

		int open=0,close=0;
		
		for(char c:s.toCharArray())
		{
			if(c=='{')
			{
				open++;
			}
			else
			{
				if(open>0)
				{
					open--;
				}
				else
				{
					close++;
				}
			}
		}
		
		
		return (open+1)/2+(close+1)/2;
	}
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	private static int minimumNumberOfBracketReversalsBetter(String s) {

		if(s.length()%2!=0) return -1;
		
		Stack<Character> stack=new Stack<>();
		
		for(char c:s.toCharArray())
		{
			if(c=='{')
			{
				stack.push(c);
			}
			else
			{
				if(!stack.isEmpty() && stack.peek()=='{')
					stack.pop();
				else
					stack.push(c);
			}
		}
		
		int open=0,close=0;
		while(!stack.isEmpty())
		{
			if(stack.pop()=='{')
				open++;
			else
				close++;
		}
		
		return (int)(Math.ceil(open/2.0)+Math.ceil(close/2.0));
	}
/*
 * Time Complexity: O(2^N)
 * Space Complexity: O(N)
 */
	private static int minimumNumberOfBracketReversalsBrute(String s) {

		if(s.length()%2!=0) return -1;
		
		return minimumReversal(s.toCharArray(), 0, 0);
		
	}

	private static int minimumReversal(char[] charArray, int index, int reversals) {
		if(index==charArray.length)
		{
			return isBalanced(charArray)?reversals: Integer.MAX_VALUE;
		}
		
		int withOutReversals=minimumReversal(charArray, index+1, reversals);
		
		charArray[index]=charArray[index]=='{'?'}':'{';
		
		int withReversals=minimumReversal(charArray, index+1,reversals+1);
		
		charArray[index]=charArray[index]=='{'?'}':'{';
		
		return Math.min(withOutReversals, withReversals);
	}

	private static boolean isBalanced(char[] charArray) {

		int count=0;
		
		for(char c:charArray)
		{
			if(c=='{')
				count++;
			else
				count--;
			
			if(count<0) return false;
		}
		
		return count==0;
	}
}

package Stringprograms.hard;

import java.util.Stack;

class Candy
{
	char character;
	int count;
	
	public Candy(char character, int count) {
		super();
		this.character = character;
		this.count = count;
	}
}

public class RestrictiveCandyCrush {

	public static void main(String[] args) {
		
		int k = 2;
		String s = "geeksforgeeks";
		
		System.out.println(restrictiveCandyCrush(s,k));

	}

	private static String restrictiveCandyCrush(String s, int k) {
		
		
		Stack<Candy> stack=new Stack<>();
		
		for(char c:s.toCharArray())
		{
			if(!stack.isEmpty() && stack.peek().character==c)
			{
				stack.peek().count++;
			}
			else
			{
				stack.push(new Candy(c, 1));
			}
			
			if(stack.peek().count==k)
				stack.pop();
		}
		
		StringBuilder sb=new StringBuilder();
		
		while(!stack.isEmpty())
		{
			char ch=stack.peek().character;
			int freq=stack.peek().count;
			
			while(freq>0)
			{
				sb.append(ch);
				freq--;
			}
			
			stack.pop();
		}
		
		return sb.reverse().toString();
	}
}

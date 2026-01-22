package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(4^n/sqrt(n))
 * Space Complexity:  O(4^n/sqrt(n)*n)
 * */
public class GenerateParentheses {

	public static void main(String[] args) {

		int n=3;

		List<String> result=generateParentheses(n);
		System.out.println(result);
	}

	private static List<String> generateParentheses(int n) {

		List<String> result=new ArrayList<>();

		backTrack(n,0,0,new StringBuilder(),result);

		return result;
	}

	private static void backTrack(int n,int open, int close, StringBuilder current, List<String> result) {

		if(current.length()==2*n)
		{
			result.add(current.toString());
			return;
		}

		if(open<n)
		{
			current.append('(');
			backTrack(n, open+1, close, current, result);
			current.deleteCharAt(current.length()-1);
		}

		if(close<open)
		{
			current.append(')');
			backTrack(n, open, close+1, current, result);
			current.deleteCharAt(current.length()-1);
		}
	}
}

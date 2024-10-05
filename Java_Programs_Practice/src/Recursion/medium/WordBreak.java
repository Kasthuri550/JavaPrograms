package Recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		
		int n = 6;
		String s = "ilike";
		ArrayList<String> dictionary =new ArrayList<String>() {{
			
			add("i");
			add("like");
			add("sam");
			add("sung");
			add("samsung");
			add("mobile");
		}};
		
		System.out.println(wordBreak(n,s,dictionary));

	}

	private static int wordBreak(int n, String s,ArrayList<String> dictionary) {
		
		Set<String> wordDict=new HashSet<String>(dictionary);
		
		boolean dp[]=new boolean[s.length()+1];
		dp[0]=true;
		
		for(int i=1;i<=s.length();i++)
		{
			for(int j=0;j<i;j++)
			{
				if(dp[j] && wordDict.contains(s.substring(j, i)))
				{
					dp[i]=true;
					break;
				}
			}
		}
		
		return dp[s.length()]?1:0;
	}
}

package DynamicProgramming.mcm;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {

		String s = "leetcode";
		String wordDict[] = {"leet","code"};

		System.out.println(wordBreak(s,wordDict));
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * */	
	private static boolean wordBreak(String s, String[] wordDict) {

		int n=s.length();

		Set<String> dict=new HashSet<>();

		for (String word : wordDict) {
			dict.add(word);
		}

		boolean dp[]=new boolean[n+1];
		dp[0]=true;

		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(dp[j] && dict.contains(s.substring(j,i)))
				{
					dp[i]=true;
					break;
				}
			}
		}

		return dp[n];
	}
}

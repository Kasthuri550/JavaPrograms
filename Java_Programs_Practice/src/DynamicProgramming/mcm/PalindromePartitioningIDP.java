package DynamicProgramming.mcm;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(n^2+2^n*n)
 * Space Complexity: O(n^2)+O(n)+O(n)+O(2^n*n)
 * */
public class PalindromePartitioningIDP {

	public static void main(String[] args) {

		String s="aab";

		List<String> path=new ArrayList<>();
		List<List<String>> resultList=new ArrayList<>();

		int n=s.length();		
		boolean[][] isPal=new boolean[n][n];
		buildPalindromeDP(s,isPal);


		palindromePartitioningIDP(0,s,path,resultList,isPal);

		System.out.println(resultList);
	}

	private static void buildPalindromeDP(String s, boolean[][] isPal) {

		int n=s.length();

		for(int i=n-1;i>=0;i--)
		{
			for(int j=i;j<n;j++)
			{
				if(s.charAt(i)==s.charAt(j))
				{
					if(j-i<=2 || isPal[i+1][j-1])
					{
						isPal[i][j]=true;
					}
				}
			}
		}
	}

	private static void palindromePartitioningIDP(int i, String s, List<String> path, List<List<String>> resultList, boolean[][] isPal) {

		if(i==s.length())
		{
			resultList.add(new ArrayList<String>(path));
			return;
		}

		for(int j=i;j<s.length();j++)
		{
			if(isPal[i][j])
			{
				path.add(s.substring(i,j+1));
				palindromePartitioningIDP(j+1, s, path, resultList, isPal);
				path.remove(path.size()-1);
			}
		}
	}
}

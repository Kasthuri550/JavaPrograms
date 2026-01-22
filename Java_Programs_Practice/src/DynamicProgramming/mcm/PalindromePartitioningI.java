package DynamicProgramming.mcm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningI {

	public static void main(String[] args) {

		String s="aab";

		List<String> path=new ArrayList<>();
		List<List<String>> resultList=new ArrayList<>();

		palindromePartitioningI(0,s,path,resultList);

		System.out.println(resultList);
	}

	/*
	 * Time Complexity: O(2^n*n)
	 * Space Complexity: O(2^n*n)+O(n)+O(n)
	 * */	
	private static void palindromePartitioningI(int i, String s, List<String> path, List<List<String>> resultList) {

		if(i==s.length())
		{
			resultList.add(new ArrayList<>(path));
			return;
		}

		for(int j=i;j<s.length();j++)
		{
			if(isPalindrome(i,j,s))
			{
				path.add(s.substring(i,j+1));
				palindromePartitioningI(j+1, s, path, resultList);
				path.remove(path.size()-1);
			}
		}
	}

	private static boolean isPalindrome(int start, int end, String s) {

		while(start<end)
		{
			if(s.charAt(start)!=s.charAt(end))
				return false;

			start++;
			end--;
		}

		return true;
	}
}

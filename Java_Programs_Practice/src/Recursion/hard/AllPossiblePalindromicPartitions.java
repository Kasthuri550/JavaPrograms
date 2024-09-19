package Recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePalindromicPartitions {

	public static void main(String[] args) {

		String s = "geeks";
		
		List<List<String>> result=new ArrayList<>();
		List<String> path=new ArrayList<>();
		
		allPossiblePalindromicPartitions(0,s,path,result);
		System.out.println(result);
		
	}

	private static void allPossiblePalindromicPartitions(int index, String s, List<String> path,
			List<List<String>> result) {
		
		if(index==s.length())
		{
			result.add(new ArrayList<String>(path));
			return;
		}
		
		for(int i=index;i<s.length();i++)
		{
			if(isPalindrome(s,index,i))
			{
				path.add(s.substring(index,i+1));
				allPossiblePalindromicPartitions(i+1, s, path, result);
				path.remove(path.size()-1);
			}
		}
		
	}

	private static boolean isPalindrome(String s, int start, int end) {

		while(start<end)
		{
			if(s.charAt(start)!=s.charAt(end)) return false;
			start++;
			end--;
		}
		
		return true;
	}
}

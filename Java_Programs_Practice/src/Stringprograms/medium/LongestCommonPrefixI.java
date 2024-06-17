package Stringprograms.medium;

import java.util.Arrays;

public class LongestCommonPrefixI {

	public static void main(String[] args) {
		
		String strs[] = {"flower","flow","flight"};
		
		System.out.println(longestCommonPrefix(strs));

	}

	private static String longestCommonPrefix(String[] strs) {
		
		int n=strs.length,index=0;
		
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		String s1=strs[0];
		String s2=strs[n-1];
		
		while(index<s1.length() && index <s2.length())
		{
			if(s1.charAt(index)==s2.charAt(index))
			{
				index++;
			}
			else
			{
				break;
			}
		}
		
		return s1.substring(0,index);
		
	}
}

package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

	public static void main(String[] args) {
		
		String s="abc";
		
		List<String> list=new ArrayList<>();
		
		allSubsequences(s,list);
//		allSubsequencesRecursion(s,0,"",list);
		Collections.sort(list);
		System.out.println(list);
	}

	private static void allSubsequencesRecursion(String s, int i, String string, List<String> list) {
		
		if(i==s.length())
		{
			list.add(string);
			return;
		}
		allSubsequencesRecursion(s, i+1, string+s.charAt(i), list);
		allSubsequencesRecursion(s, i+1, string, list);
		
	}

	private static void allSubsequences(String s,List<String> list) {
		
		int n = s.length();
		int total=1<<n;
		
		for(int num=0;num<total;num++)
		{
			String subStr="";
			for(int i=0;i<n;i++)
			{
				if((num & (1<<i))>0)
					subStr+=s.charAt(i);
			}
			list.add(subStr);
		}
		
	}
}

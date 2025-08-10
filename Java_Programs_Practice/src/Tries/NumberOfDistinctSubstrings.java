package Tries;

import java.util.HashSet;
import java.util.Set;

class StrNode
{
	StrNode links[]=new StrNode[26];

	boolean containsKey(char ch)
	{
		return links[ch-'a']!=null;
	}

	void put(char ch,StrNode node)
	{
		links[ch-'a']=node;
	}

	StrNode get(char ch)
	{
		return links[ch-'a'];
	}
}

public class NumberOfDistinctSubstrings {

	public static void main(String[] args) {

		String str="ababa";

		System.out.println(countDistinctSubstrings1(str));
		System.out.println(countDistinctSubstrings2(str));
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n^2)
	 * */
	private static int countDistinctSubstrings2(String str) {

		StrNode root=new StrNode();

		int n=str.length(),count=0;

		for(int i=0;i<n;i++)
		{
			StrNode node=root;
			for(int j=i;j<n;j++)
			{
				if(!node.containsKey(str.charAt(j)))
				{
					node.put(str.charAt(j),new StrNode());
					count++;
				}

				node=node.get(str.charAt(j));
			}
		}

		return count+1;
	}

	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(n^2)
	 * */	
	private static int countDistinctSubstrings1(String str) {

		Set<String> set=new HashSet<>();

		int n=str.length();

		for(int i=0;i<n;i++)
		{
			String s="";
			for(int j=i;j<n;j++)
			{
				s=s+str.charAt(j);
				set.add(s);
			}
		}

		return set.size()+1;
	}
}

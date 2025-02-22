package Graph.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

	public static void main(String[] args) {

		int N = 5, K = 4;
		String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

		System.out.println(findOrder1(N,K,dict));
		System.out.println(findOrder2(dict));
	}

	private static String findOrder2(String[] words) {

		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

		for(int i=0;i<26;i++)
		{
			adj.add(new ArrayList<>());
		}

		Set<Character> uniqueChars=new HashSet<>();

		for(String word:words)
		{
			for(char charArray:word.toCharArray())
			{
				uniqueChars.add(charArray);
			}
		}

		int n=words.length;

		int indegree[]=new int[26];

		for(int i=0;i<n-1;i++)
		{
			String s1=words[i];
			String s2=words[i+1];
			int len=Math.min(s1.length(),s2.length());
			boolean foundOrder = false;
			for(int ptr=0;ptr<len;ptr++)
			{
				if(s1.charAt(ptr)!=s2.charAt(ptr))
				{
					adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
					indegree[s2.charAt(ptr)-'a']++;
					foundOrder=true;
					break;
				}
			}
			
			if(!foundOrder && s1.length()>s2.length())
			{
				return "";
			}
		}

		return topoSort(uniqueChars,indegree,adj);
	}


	private static String topoSort(Set<Character> uniqueChars, int[] indegree, ArrayList<ArrayList<Integer>> adj) {

		Queue<Integer> queue=new LinkedList<>();
		StringBuilder result=new StringBuilder();

		for(char c:uniqueChars)
		{
			if(indegree[c-'a']==0)
			{
				queue.offer(c-'a');
			}
		}

		while(!queue.isEmpty())
		{
			int node=queue.poll();
			result.append((char)(node+'a'));

			for(int neighbour:adj.get(node))
			{
				indegree[neighbour]--;

				if(indegree[neighbour]==0)
				{
					queue.offer(neighbour);
				}
			}
		}

		if(result.length()!=uniqueChars.size())
		{
			return "";
		}

		return result.toString();
	}

	private static String findOrder1(int n, int k, String[] dict) {

		ArrayList<ArrayList<Integer>> al=new ArrayList<>();

		for(int i=0;i<k;i++)
		{
			al.add(new ArrayList<>());
		}

		for(int i=0;i<n-1;i++)
		{
			String s1=dict[i];
			String s2=dict[i+1];

			int len=Math.min(s1.length(), s2.length());

			for(int ptr=0;ptr<len;ptr++)
			{
				if(s1.charAt(ptr)!=s2.charAt(ptr))
				{
					al.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
					break;
				}
			}
		}

		ArrayList<Integer> topo=topoSort(k,al);

		String ans="";

		for(int t:topo)
		{
			ans=ans+(char)(t+(int)'a');
		}

		return ans;
	}

	private static ArrayList<Integer> topoSort(int k, ArrayList<ArrayList<Integer>> al) {

		int indegree[]=new int[k];

		for(int i=0;i<k;i++)
		{
			for(int it:al.get(i))
			{
				indegree[it]++;
			}
		}

		Queue<Integer> queue=new LinkedList<>();

		for(int i=0;i<k;i++)
		{
			if(indegree[i]==0)
			{
				queue.add(i);
			}
		}

		ArrayList<Integer> topo=new ArrayList<>();

		while(!queue.isEmpty())
		{
			int node=queue.poll();

			topo.add(node);

			for(int it:al.get(node))
			{
				indegree[it]--;

				if(indegree[it]==0)
				{
					queue.offer(it);
				}
			}
		}

		return topo;
	}
}

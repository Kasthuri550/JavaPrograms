package Tries;

class TrieNode1
{
	TrieNode1 links[]=new TrieNode1[26];
	boolean flag=false;

	boolean containsKey(char ch)
	{
		return links[ch-'a']!=null;
	}

	void put(char ch,TrieNode1 node)
	{
		links[ch-'a']=node;
	}

	public TrieNode1 get(char ch) {

		return links[ch-'a'];
	}

	public void setEnd() {

		flag=true;
	}

	boolean isEnd()
	{
		return flag;
	}
}

public class LongestStringWithAllPrefixes {
	
	static class Trie {
		
		private static TrieNode1 root;
		
		Trie()
		{
			root=new TrieNode1();
		}
	
		public static void insert(String word)
		{
			TrieNode1 node=root;
			
			for(int i=0;i<word.length();i++)
			{
				if(!node.containsKey(word.charAt(i)))
				{
					node.put(word.charAt(i),new TrieNode1());
				}
				
				node=node.get(word.charAt(i));
			}
			
			node.setEnd();
		}
		
		public static boolean checkIfPrefixExists(String word)
		{
			TrieNode1 node=root;
			boolean flag=true;
			
			for(int i=0;i<word.length();i++)
			{
				if(node.containsKey(word.charAt(i)))
				{
					node=node.get(word.charAt(i));
					flag=flag & node.isEnd();
				}
				else
				{
					return false;
				}				
			}
			
			return flag;
		}
	}
	
	public static String completeString(int n,String a[])
	{
		Trie obj=new Trie();
		
		for(int i=0;i<n;i++)
		{
			Trie.insert(a[i]);
		}
		
		String longest="";
		
		for(int i=0;i<n;i++)
		{
			if(Trie.checkIfPrefixExists(a[i]))
			{
				if(a[i].length()>longest.length())
				{
					longest=a[i];
				}
				else if(a[i].length()==longest.length() && a[i].compareTo(longest)<0)
				{
					longest=a[i];
				}
			}
		}
		
		if(longest=="") return "";
		
		return longest;
	}

	public static void main(String[] args) {

		String[] input1 = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println("Output: " + completeString(input1.length,input1)); // Output: pros

        String[] input2 = {"geeks", "gfg", "geeksforgeeks"};
        System.out.println("Output: " + completeString(input2.length,input2)); // Output: (empty string)
		
	}
}

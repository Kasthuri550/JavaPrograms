package Tries;

import java.util.ArrayList;
import java.util.List;

class Node
{
	Node links[]=new Node[26];
	boolean flag=false;

	boolean containsKey(char ch)
	{
		return links[ch-'a']!=null;
	}

	void put(char ch,Node node)
	{
		links[ch-'a']=node;
	}

	public Node get(char ch) {

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
public class Trie {

	private Node root;

	Trie()
	{
		root=new Node();
	}
	/*
	 * Time Complexity: O(L)
	 * Space Complexity: O(L)
	 * */
	public void insert(String word)
	{
		Node node=root;
		for(int i=0;i<word.length();i++)
		{
			if(!node.containsKey(word.charAt(i)))
			{
				node.put(word.charAt(i),new Node());
			}

			node=node.get(word.charAt(i));
		}

		node.setEnd();
	}
	/*
	 * Time Complexity: O(L)
	 * Space Complexity: O(1)
	 * */
	public boolean search(String word)
	{
		Node node=root;
		for(int i=0;i<word.length();i++)
		{
			if(!node.containsKey(word.charAt(i)))
			{
				return false;
			}

			node=node.get(word.charAt(i));
		}

		return node.isEnd();
	}
	/*
	 * Time Complexity: O(L)
	 * Space Complexity: O(1)
	 * */
	public boolean startsWith(String word)
	{
		Node node=root;
		for(int i=0;i<word.length();i++)
		{
			if(!node.containsKey(word.charAt(i)))
			{
				return false;
			}

			node=node.get(word.charAt(i));
		}

		return true;
	}

	public static void main(String[] args) {

		int[][] queryTypes = {
				{1, 0}, {1, 1}, {1, 2}, {2, 3}, {3, 3}, {2, 1}
		};
		String[] words = {"abcd", "abc", "bcd", "bc", "bc", "abc"};

		Trie trie = new Trie();
		List<Boolean> output = new ArrayList<>();

		for (int i = 0; i < queryTypes.length; i++) {
			int type = queryTypes[i][0];
			String word = words[queryTypes[i][1]];

			if (type == 1) {
				trie.insert(word);
			} else if (type == 2) {
				output.add(trie.search(word));
			} else if (type == 3) {
				output.add(trie.startsWith(word));
			}
		}

		System.out.println(output);
	}
}

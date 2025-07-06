package Tries;

class TrieNode
{
	private TrieNode links[]=new TrieNode[26];
	private int countEnd;
	private int countPrefix;

	boolean containsKey(char ch)
	{
		return links[ch-'a'] != null;
	}


	TrieNode get(char ch)
	{
		return links[ch-'a'];
	}

	void put(char ch,TrieNode trieNode)
	{
		links[ch-'a']=trieNode;
	}

	void increasePrefix()
	{
		countPrefix++;
	}

	void decreasePrefix()
	{
		countPrefix--;
	}

	void increaseEnd()
	{
		countEnd++;
	}

	void decreaseEnd()
	{
		countEnd--;
	}

	int getPrefix()
	{
		return countPrefix;
	}

	int getEnd()
	{
		return countEnd;
	}
}
public class Trie_2 {

	private TrieNode root;

	Trie_2()
	{
		root=new TrieNode();
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(m*n)
	 * */	
	void insert(String word)
	{
		TrieNode node=root;

		for(int i=0;i<word.length();i++)
		{
			if(!node.containsKey(word.charAt(i)))
			{
				node.put(word.charAt(i),new TrieNode());
			}

			node=node.get(word.charAt(i));
			node.increasePrefix();
		}

		node.increaseEnd();
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	int countWordsEqualTo(String word)
	{
		TrieNode node=root;

		for(int i=0;i<word.length();i++)
		{
			if(node.containsKey(word.charAt(i)))
			{
				node=node.get(word.charAt(i));
			}
			else
			{
				return 0;
			}
		}

		return node.getEnd();
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	int countWordsStartingWith(String word)
	{
		TrieNode node=root;

		for(int i=0;i<word.length();i++)
		{
			if(node.containsKey(word.charAt(i)))
			{
				node=node.get(word.charAt(i));
			}
			else
			{
				return 0;
			}
		}

		return node.getPrefix();
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	void erase(String word)
	{
		TrieNode node=root;

		for(int i=0;i<word.length();i++)
		{
			if(node.containsKey(word.charAt(i)))
			{
				node=node.get(word.charAt(i));
			}
			else
			{
				return;
			}
		}

		node.decreaseEnd();
	}

	public static void main(String[] args) {

		Trie_2 trie = new Trie_2();
		trie.insert("apple");
		trie.insert("app");
		trie.insert("apple");

		System.out.println(trie.countWordsEqualTo("apple")); // 2
		System.out.println(trie.countWordsStartingWith("app")); // 3

		trie.erase("apple");
		System.out.println(trie.countWordsEqualTo("apple")); // 1
	}
}

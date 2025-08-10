package Tries;

/*
 * Time Complexity: O(n*32)+O(m*32)
 * Space Complexity: O(n*32)
 * */
class TrieBit
{
	TrieBit links[]=new TrieBit[2];

	boolean containsKey(int bit)
	{
		return links[bit]!=null;
	}

	TrieBit get(int bit)
	{
		return links[bit];
	}

	void put(int bit,TrieBit trieBit)
	{
		links[bit]=trieBit;
	}
}

class Trie01
{
	TrieBit root;

	Trie01()
	{
		root=new TrieBit();
	}

	void insert(int num)
	{
		TrieBit node=root;

		for(int i=31;i>=0;i--)
		{
			int bit=(num>>i) & 1;

			if(!node.containsKey(bit))
			{
				node.put(bit,new TrieBit());
			}

			node=node.get(bit);
		}
	}

	int getMax(int num)
	{
		TrieBit node=root;

		int maxNum=0;

		for(int i=31;i>=0;i--)
		{
			int bit=(num>>i) & 1;

			if(node.containsKey(1-bit))
			{
				maxNum= maxNum | (1<<i);
				node=node.get(1-bit);
			}
			else
			{
				node=node.get(bit);
			}
		}

		return maxNum;
	}

}
public class MaximumXOROfTwoNumbersInAnArray {

	static int maxXor(int[] arr) {

		int n=arr.length,max=0;
		Trie01 trie=new Trie01();

		for(int i=0;i<n;i++)
		{
			trie.insert(arr[i]);
		}

		for(int i=0;i<n;i++)
		{
			max=Math.max(max,trie.getMax(arr[i]));
		}

		return max;
	}

	public static void main(String[] args) {

		int arr[]= {25,10,2,8,5,3};

		System.out.println(maxXor(arr));
	}
}

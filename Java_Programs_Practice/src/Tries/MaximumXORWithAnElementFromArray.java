//package Tries;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
///*
// * Time Complexity: O(n*32+q*32+qlogq)
// * Space Complexity: O(n*32+q)
// * */
//class TrieBit
//{
//	TrieBit links[]=new TrieBit[2];
//
//	boolean containsKey(int bit)
//	{
//		return links[bit]!=null;
//	}
//
//	TrieBit get(int bit)
//	{
//		return links[bit];
//	}
//
//	void put(int bit,TrieBit trieBit)
//	{
//		links[bit]=trieBit;
//	}
//}
//
//class Trie01
//{
//	TrieBit root;
//
//	Trie01()
//	{
//		root=new TrieBit();
//	}
//
//	void insert(int num)
//	{
//		TrieBit node=root;
//
//		for(int i=31;i>=0;i--)
//		{
//			int bit=(num>>i) & 1;
//
//			if(!node.containsKey(bit))
//			{
//				node.put(bit,new TrieBit());
//			}
//
//			node=node.get(bit);
//		}
//	}
//
//	int getMax(int num)
//	{
//		TrieBit node=root;
//
//		int maxNum=0;
//
//		for(int i=31;i>=0;i--)
//		{
//			int bit=(num>>i) & 1;
//
//			if(node.containsKey(1-bit))
//			{
//				maxNum= maxNum | (1<<i);
//				node=node.get(1-bit);
//			}
//			else
//			{
//				node=node.get(bit);
//			}
//		}
//
//		return maxNum;
//	}
//
//}
//
//class Pair<U,V>
//{
//	public final U first;
//	public final V second;
//
//	Pair(U first,V second)
//	{
//		this.first=first;
//		this.second=second;
//	}
//}
//public class MaximumXORWithAnElementFromArray {
//
//	static int[] maxXor(int[] arr, int[][] queries) {
//
//		int index=0,n=arr.length;
//
//		Arrays.sort(arr);
//
//		ArrayList<Pair<Integer,Pair<Integer,Integer>>> offlineQueries=new ArrayList<>();
//
//		for(int q[]:queries)
//		{
//			offlineQueries.add(new Pair<>(q[1],new Pair<>(q[0],index++)));
//		}
//
//		offlineQueries.sort(Comparator.comparing(pair -> pair.first));
//
//		int i=0;
//
//		Trie01 trie=new Trie01();
//
//		int result[]=new int[queries.length];
//
//		for(Pair<Integer,Pair<Integer,Integer>> oq:offlineQueries)
//		{
//			while(i<n && arr[i]<=oq.first)
//			{
//				trie.insert(arr[i]);
//				i++;
//			}
//
//			if(i!=0)
//			{
//				result[oq.second.second]=trie.getMax(oq.second.first);
//			}
//			else
//			{
//				result[oq.second.second]=-1;
//			}
//		}
//
//		return result;
//	}
//
//	public static void main(String[] args) {
//
//
//		int arr[] = {0, 1, 2, 3, 4}, q = 3, queries[][] = {{3, 1}, {1, 3}, {5, 6}};
//
//		System.out.println(Arrays.toString(maxXor(arr,queries)));
//	}
//}

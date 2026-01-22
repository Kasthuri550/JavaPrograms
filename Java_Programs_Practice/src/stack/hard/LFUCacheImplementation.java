package stack.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
 * Time Complexity: O(1)
 * Space Complexity: O(capacity)
 * */
class ListNode
{
	int key;
	int value;
	int freq;

	ListNode(int key,int value)
	{
		this.key=key;
		this.value=value;
		this.freq=1;
	}
}
class LeastFrequentlyUsed
{
	int capacity,minFreq;
	Map<Integer,ListNode> keyMap;
	Map<Integer,LinkedHashSet<ListNode>> freqMap;

	LeastFrequentlyUsed(int capacity)
	{
		this.capacity=capacity;
		this.minFreq=0;
		keyMap=new HashMap<Integer, ListNode>();
		freqMap=new HashMap<Integer, LinkedHashSet<ListNode>>();
	}

	public int get(int key)
	{
		if(!keyMap.containsKey(key))
		{
			return -1;
		}

		ListNode node=keyMap.get(key);
		updateFrequency(node);
		return node.value;
	}

	public void put(int key,int value)
	{
		if(capacity==0)
			return;

		if(keyMap.containsKey(key))
		{
			ListNode node=keyMap.get(key);
			node.value=value;
			updateFrequency(node);
			return;
		}

		if(capacity==keyMap.size())
		{
			LinkedHashSet<ListNode> set=freqMap.get(minFreq);
			ListNode toRemove=set.iterator().next();
			set.remove(toRemove);
			keyMap.remove(toRemove.key);
		}

		ListNode newNode=new ListNode(key,value);
		keyMap.put(key,newNode);
		freqMap.computeIfAbsent(1,k->new LinkedHashSet<ListNode>()).add(newNode);
		minFreq=1;
	}

	private void updateFrequency(ListNode node) {

		int freq=node.freq;
		LinkedHashSet<ListNode> set=freqMap.get(freq);
		set.remove(node);

		if(set.isEmpty() && freq==minFreq)
		{
			minFreq++;
		}

		node.freq++;
		freqMap.computeIfAbsent(node.freq,k->new LinkedHashSet<ListNode>()).add(node);
	}
}
public class LFUCacheImplementation {

	public static void main(String[] args) {

		LeastFrequentlyUsed lfu=new LeastFrequentlyUsed(3);
		lfu.put(3,4);
		lfu.put(2, 9);
		lfu.put(1,10);
		lfu.put(8,7);

		System.out.println(lfu.keyMap);
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(1));
		lfu.put(4, 5);
		System.out.println(lfu.keyMap);
		System.out.println(lfu.freqMap);
	}
}

package stack.hard;

import java.util.HashMap;
import java.util.Map;

class LFUCache
{
	private class Node
	{
		int key,value,freq;
		Node next,prev;

		Node(int key,int value)
		{
			this.key=key;
			this.value=value;
			this.freq=1;
		}
	}

	private class DoublyLinkedList
	{
		Node head,tail;

		DoublyLinkedList()
		{
			head=new Node(0,0);
			tail=new Node(0,0);
			head.next=tail;
			tail.prev=head;
		}

		public void addNode(Node node)
		{
			node.next=head.next;
			node.prev=head;
			head.next.prev=node;
			head.next=node;
		}

		public void removeNode(Node node)
		{
			node.prev.next=node.next;
			node.next.prev=node.prev;
		}

		public Node removeLast(Node node)
		{
			if(tail.prev==head) return null;

			Node last=tail.prev;
			removeNode(last);

			return last;
		}

		public boolean isEmpty()
		{
			return head.next==tail;
		}

	}

	int capacity,size,minFreq;
	Map<Integer,Node> cache;
	Map<Integer,DoublyLinkedList> freqMap;

	LFUCache(int capacity)
	{
		this.capacity=capacity;
		this.size=0;
		this.minFreq=0;
		this.cache=new HashMap<Integer, LFUCache.Node>();
		this.freqMap=new HashMap<Integer, LFUCache.DoublyLinkedList>();
	}

	public int get(int key)
	{
		if(!cache.containsKey(key)) return -1;

		Node node=cache.get(key);
		updateFreq(node);
		return node.value;
	}

	public void put(int key,int value)
	{
		if(capacity==0) return;

		if(cache.containsKey(key))
		{
			Node node=cache.get(key);
			node.value=value;
			updateFreq(node);
		}
		else
		{
			if(size==capacity)
			{
				DoublyLinkedList doublyLinkedList = freqMap.get(minFreq);
				Node evictNode = doublyLinkedList.removeLast(new Node(key,value));
				cache.remove(evictNode.key);
				size--;
			}

			Node newNode=new Node(key,value);
			cache.put(key,newNode);
			minFreq=1;
			freqMap.computeIfAbsent(1,k -> new DoublyLinkedList()).addNode(newNode);
			size++;
		}
	}

	public void updateFreq(Node node)
	{
		int currFreq=node.freq;
		DoublyLinkedList list = freqMap.get(currFreq);
		list.removeNode(node);

		if(minFreq==currFreq && list.isEmpty())
		{
			minFreq++;
		}

		node.freq++;
		freqMap.computeIfAbsent(node.freq,k-> new DoublyLinkedList()).addNode(node);
	}


	public static void main(String[] args) {

		LFUCache cache = new LFUCache(3);

		cache.put(5, 7);
		cache.put(4, 6);
		cache.put(3, 5);
		cache.put(2, 4); // evicts key 5
		cache.put(1, 3); // evicts key 4

		System.out.println(cache.get(1)); // returns 3
		System.out.println(cache.get(2)); // returns 4
		System.out.println(cache.get(3)); // returns 5
		System.out.println(cache.get(4)); // returns -1 (evicted)
		System.out.println(cache.get(5)); // returns -1 (evicted)

	}
}

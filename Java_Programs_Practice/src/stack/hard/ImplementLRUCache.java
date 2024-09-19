package stack.hard;

import java.util.HashMap;
import java.util.Map;

class Node
{
	Node prev,next;
	int key,value;
	public Node(int _key,int _value)
	{
		key=_key;
		value=_value;
	}
	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
}
class LRUCache
{
	int capacity;
	Node head=new Node(0,0);
	Node tail=new Node(0,0);
	Map<Integer,Node> map=new HashMap<Integer, Node>();

	public LRUCache(int capacity)
	{
		this.capacity=capacity;
		head.next=tail;
		tail.prev=head;				
	}

	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Node node=map.get(key);
			removeNode(node);
			insertNode(node);
			return node.value;
		}

		return -1;	
	}

	private void insertNode(Node node) {
		
		map.put(node.key,node);
		node.next=head.next;
		node.next.prev=node;
		head.next=node;
		node.prev=head;
		
	}

	private void removeNode(Node node) {
		
		map.remove(node.key);
		node.prev.next=node.next;
		node.next.prev=node.prev;
		
	}

	public void put(int key,int value)
	{
		if(map.containsKey(key))
		{
			removeNode(map.get(key));
		}

		if(map.size()==capacity)
		{
			removeNode(tail.prev);
		}

		insertNode(new Node(key,value));
	}
}
public class ImplementLRUCache {

	public static void main(String[] args) {

		LRUCache lruCache=new LRUCache(4);
		lruCache.put(10, 30);
		lruCache.put(78, 23);
		lruCache.put(34, 12);
		lruCache.put(90, 35);
		System.out.println(lruCache.get(78));
		System.out.println(lruCache.map);

	}
}

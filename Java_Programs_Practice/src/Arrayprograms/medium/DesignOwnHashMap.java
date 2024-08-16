package Arrayprograms.medium;

import java.util.Arrays;

class MyHashMap<K,V>
{
	private final int SIZE=10000;
	private Object map[];
	
	MyHashMap()
	{
		map=new Object[SIZE];		
	}
	
	public void put(K key,V value)
	{
		int index=key.hashCode()%SIZE;
		map[index]=value;
	}
	
	public V get(K key)
	{
		int index=key.hashCode()%SIZE;
		return (V) map[index];
	}
	
	public void remove(K key)
	{
		int index=key.hashCode()%SIZE;
		 map[index]=null;
	}
}
public class DesignOwnHashMap {

	public static void main(String[] args) {
		
		MyHashMap<String,Integer> myHashMap=new MyHashMap();
		
		myHashMap.put("Kasthuri",26);
		
		System.out.println(myHashMap.get("Kasthuri"));

	}
}

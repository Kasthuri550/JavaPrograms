package stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class MyStack
{
	static Queue<Integer> queue=new LinkedList<Integer>();
	
	void push(int newElement)
	{
		queue.add(newElement);
		
		for(int i=0;i<queue.size()-1;i++)
		{
			queue.add(queue.peek());
			queue.remove();
		}
	}
	
	int pop()
	{
		return queue.remove();
	}
	
	 boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	 int top()
	{
		return queue.peek();
	}
	 
	 void traverse()
	 {
		 Iterator<Integer> iterator = queue.iterator();
		 
		 while(iterator.hasNext()) 
		 {
			 System.out.println(iterator.next());
		 }
	 }
}

public class ImplementStackUsingSingleQueue {

	public static void main(String[] args) {
		
		MyStack mystack=new MyStack();
		mystack.push(10);	
		mystack.push(20);
		mystack.push(30);
		mystack.push(40);
		mystack.pop();
		mystack.traverse();
		System.out.println(mystack.top());
		
	}
}

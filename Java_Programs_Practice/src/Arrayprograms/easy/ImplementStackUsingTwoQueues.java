package Arrayprograms.easy;

import java.util.LinkedList;
import java.util.Queue;

class MyQueues
{
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	
	public MyQueues() {
		super();
		this.queue1=new LinkedList<Integer>();
		this.queue2=new LinkedList<Integer>();
	}
	
	public void push(int newElement)
	{
		queue2.add(newElement);
		
		while(!queue1.isEmpty())
		{
			queue2.add(queue1.poll());
		}
		Queue<Integer> temp=queue1;
		queue1=queue2;
		queue2=temp;		
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		
		return queue1.poll();
	}
	
	public int top()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		
		return queue1.peek();
	}
	
	public boolean isEmpty()
	{
		return queue1.isEmpty();
	}
	
	public int size()
	{
		return queue1.size();
	}
	
	public void print()
	{
		Queue<Integer> tempQueue=new LinkedList<Integer>(queue1);
		
		while(!tempQueue.isEmpty())
		{
			System.out.print(tempQueue.poll()+" ");
		}
		System.out.println();
	}
	
}

public class ImplementStackUsingTwoQueues {

	public static void main(String[] args) {
		
		MyQueues queues=new MyQueues();
		queues.push(10);
		queues.push(20);
		queues.push(30);
		queues.push(40);
		queues.print();
		
		System.out.println(queues.top());
		System.out.println(queues.size());
		System.out.println(queues.isEmpty());
		System.out.println(queues.pop());
		
		queues.print();

	}
}

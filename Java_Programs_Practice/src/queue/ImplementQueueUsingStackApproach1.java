package queue;

import java.util.Stack;

class QueueS1
{
	private Stack<Integer> s1=new Stack<>();
	private Stack<Integer> s2=new Stack<>();
	
	void push(int x)
	{
		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
		}
		
		s1.push(x);
		
		while(!s2.isEmpty())
		{
			s1.push(s2.pop());
		}
	}
	
	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		
		return s1.pop();
	}
	
	int top()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		
		return s1.peek();
	}
	
	boolean isEmpty()
	{
		return s1.isEmpty();
	}
	
	void print()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		
		for(int e:s1)
		{
			System.out.print(e+" ");
		}
		System.out.println();
	}
}
public class ImplementQueueUsingStackApproach1 {

	public static void main(String[] args) {
		
		QueueS1 queueS1=new QueueS1();
		queueS1.push(45);
		queueS1.push(34);
		queueS1.push(12);
		queueS1.push(90);
		queueS1.push(76);
		
		queueS1.print();
		
		System.out.println(queueS1.pop());
		queueS1.print();
		System.out.println(queueS1.top());
		System.out.println(queueS1.isEmpty());

	}
}

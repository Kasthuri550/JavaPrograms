package queue;

import java.util.LinkedList;
import java.util.Queue;

class StackQ2
{
	Queue<Integer> queue=new LinkedList<>();
	
	void push(int x)
	{
		queue.add(x);
		int size=queue.size();
		
		while(size>1)
		{
			queue.add(queue.remove());
			size--;
		}
	}
	
	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}
		
		return queue.remove();
	}
	
	int peek()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}
		
		return queue.peek();
	}
	
	boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	void print()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}
		
		for(int ele:queue)
		{
			System.out.print(ele+" ");
		}
		System.out.println();
	}
}

public class ImplementStackUsingQueueApproach2 {

	public static void main(String[] args) {
		
		StackQ2 stackq2=new StackQ2();
		stackq2.push(46);
		stackq2.push(10);
		stackq2.push(28);
		stackq2.push(76);
		stackq2.push(59);
		
		stackq2.print();
		
		System.out.println(stackq2.pop());
		stackq2.print();
		System.out.println(stackq2.peek());
		System.out.println(stackq2.isEmpty());
	}
}

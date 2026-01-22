package queue;

import java.util.Stack;

/*
 * Time Complexity: O(1) Amortized
 * Space Complexity: O(2n) 
 * */
class QueueS2
{
	private Stack<Integer> s1=new Stack<Integer>();
	private Stack<Integer> s2=new Stack<Integer>();

	void push(int x)
	{
		s1.push(x);
	}

	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}

		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
		}

		return s2.pop();
	}

	int top()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}

		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
		}

		return s2.peek();
	}

	boolean isEmpty()
	{
		return s1.isEmpty() && s2.isEmpty();
	}

	void print()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}

		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
		}

		for(int e:s2)
		{
			System.out.print(e+" ");
		}
		System.out.println();
	}
}
public class ImplementQueueUsingStackApproach2 {

	public static void main(String[] args) {

		QueueS2 queues2=new QueueS2();
		queues2.push(65);
		queues2.push(14);
		queues2.push(76);
		queues2.push(64);
		queues2.push(21);

		queues2.print();

		System.out.println(queues2.pop());
		System.out.println(queues2.top());
		queues2.print();
		System.out.println(queues2.isEmpty());
	}
}

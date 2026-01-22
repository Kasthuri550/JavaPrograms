package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(2n)
 * */
class StackQ
{
	private Queue<Integer> q1=new LinkedList<>();
	private Queue<Integer> q2=new LinkedList<>();

	void push(int x)
	{
		q1.add(x);

		while(!q1.isEmpty())
		{
			q2.add(q1.remove());
		}

		Queue<Integer> temp=q1;
		q1=q2;
		q2=temp;
	}

	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}

		return q1.remove();
	}

	int peek()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}

		return q1.peek();
	}

	boolean isEmpty()
	{
		return q1.isEmpty();
	}

	void print()
	{
		for(int ele:q1)
		{
			System.out.print(ele+" ");
		}
		System.out.println();
	}
}
public class ImplementStackUsingQueueApproach1 {

	public static void main(String[] args) {

		StackQ stackq=new StackQ();
		stackq.push(30);
		stackq.push(21);
		stackq.push(48);
		stackq.push(32);
		stackq.print();	

		System.out.println(stackq.pop());
		System.out.println(stackq.peek());
		System.out.println(stackq.isEmpty());
	}
}

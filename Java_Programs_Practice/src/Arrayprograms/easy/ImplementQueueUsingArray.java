package Arrayprograms.easy;

/*
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * */
class MyQueue
{
	private static final int MAXSIZE=5;
	private int front,rear,currentSize=0;
	private int arr[];

	MyQueue()
	{
		front=-1;
		rear=-1;
		currentSize=0;
		arr=new int[MAXSIZE];
	}

	public void push(int newElement)
	{
		if(currentSize==MAXSIZE)
		{
			System.out.println("Queue is full");
			System.exit(1);
		}
		if(rear==-1)
		{
			rear=0;
			front=0;
		}
		else
			rear=(rear+1)%MAXSIZE;

		arr[rear]=newElement;
		currentSize++;
	}

	public int pop()
	{
		if(front==-1)
		{
			System.out.println("Queue is empty");
			System.exit(1);
		}

		int popped=arr[front];
		if(currentSize==1)
		{
			front=-1;
			rear=-1;
		}
		else
			front=(front+1)%MAXSIZE;
		currentSize--;
		return popped;
	}

	public int top()
	{
		if(front==-1)
		{
			System.out.println("Queue is empty");
			System.exit(1);
		}
		return arr[front%MAXSIZE];
	}

	public int size()
	{
		return currentSize;
	}

	public boolean isEmpty()
	{
		if(currentSize==0)
			return true;

		return false;
	}

	public void print()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}

		if(front<=rear)
		{
			for(int i=front;i<=rear;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
		else
		{
			for(int i=front;i<MAXSIZE;i++)
			{
				System.out.print(arr[i]+" ");
			}
			for(int i=0;i<=rear;i++)
			{
				System.out.println(arr[i]+" ");
			}
		}
		System.out.println();
	}
}

public class ImplementQueueUsingArray {

	public static void main(String[] args) {

		MyQueue queue=new MyQueue();
		queue.push(10);
		queue.push(20);
		queue.push(30);
		queue.push(40);
		queue.push(50);
		queue.print();
		queue.pop();
		queue.push(60);
		queue.pop();
		queue.print();

		System.out.println(queue.top());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());

	}
}

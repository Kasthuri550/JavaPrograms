package queue;

class QueueLL
{
	private static class Node
	{
		int data;
		Node next;

		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}

	private Node front,rear;
	private int size;

	QueueLL()
	{
		this.front=null;
		this.rear=null;
		this.size=0;
	}

	void enqueue(int x)
	{
		Node newNode=new Node(x);

		if(rear==null)
		{
			front=rear=newNode;
		}
		else
		{
			rear.next=newNode;
			rear=newNode;
		}
		size++;
	}

	int dequeue()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}

		int value=front.data;
		front=front.next;

		if(front==null)
		{
			rear=null;
		}
		size--;
		return value;
	}

	int peek()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}

		return front.data;
	}

	boolean isEmpty()
	{
		return rear==null;
	}

	int size()
	{
		return size;
	}
	
	void print()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		
		Node temp=front;
		
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}

public class QueueUsingLinkedList {

	public static void main(String[] args) {

		QueueLL queueLL=new QueueLL();
		queueLL.enqueue(45);
		queueLL.enqueue(80);
		queueLL.enqueue(23);
		queueLL.enqueue(76);
		
		queueLL.print();
		System.out.println(queueLL.dequeue());
		queueLL.print();
		System.out.println(queueLL.peek());
		System.out.println(queueLL.isEmpty());
		System.out.println(queueLL.size());
	}
}

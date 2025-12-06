package queue;

class MyQueue
{
	int arr[],front,rear,size,capacity;
	
	MyQueue(int capacity)
	{
		this.capacity=capacity;
		arr=new int[capacity];
		size=0;
		front=0;
		rear=-1;
	}
	
	void enqueue(int element)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		
		rear=(rear+1)%capacity;
		arr[rear]=element;
		size++;
	}
	
	int dequeue() 
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}
		
		int removed=arr[front];
		front=(front+1)%capacity;
		size--;
		return removed;
	}
	
	int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}
		
		return arr[front];
	}
	
	boolean isEmpty()
	{
		return size==0;
	}
	
	boolean isFull()
	{
		return size==capacity;
	}
	
	void show()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		
		int start=front,count=size;
		
		while(count>0)
		{
			System.out.print(arr[start]+" ");
			start=(start+1)%capacity;
			count--;
		}
		System.out.println();
	}
}
public class QueueUsingArray {

	public static void main(String[] args) {
		
		MyQueue myqueue=new MyQueue(5);
		myqueue.enqueue(78);
		myqueue.enqueue(34);
		myqueue.enqueue(21);
		myqueue.enqueue(54);
		myqueue.show();
		System.out.println(myqueue.dequeue());
		myqueue.show();
		System.out.println(myqueue.peek());
		System.out.println(myqueue.isEmpty());
		System.out.println(myqueue.isFull());
	}
}

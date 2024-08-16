package queue;

class QueueNode
{
	int data;
	QueueNode next;
	
	public QueueNode(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	public QueueNode(int data, QueueNode next) {
		super();
		this.data = data;
		this.next = next;
	}
}
class Queue
{
	QueueNode front,rear;
	int size;
	
	Queue()
	{
		this.front=null;
		this.rear=null;
		this.size=0;
	}
	
	public void enqueue(int data)
	{
		QueueNode newNode=new QueueNode(data);
		if(rear==null)
		{
			this.front=this.rear=newNode;
		}
		else
		{
			this.rear.next=newNode;
			this.rear=newNode;
		}
		this.size++;
	}
	
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}
		
		int poppedData=this.front.data;
		this.front=this.front.next;
		
		if(this.front==null)
		{
			this.rear=null;
		}
		this.size--;
		return poppedData;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}
		return this.front.data;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		
		QueueNode current=this.front;
		
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}
public class ImplementQueueUsingLinkedList {

	public static void main(String[] args) {
		
			
		Queue queue=new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		queue.dequeue();
		
		queue.display();
		
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.peek());

	}
}

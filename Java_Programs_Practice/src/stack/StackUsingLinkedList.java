package stack;

class Node
{
	int data;
	Node next;
	
	public Node(int data) {
		super();
		this.data=data;
		this.next=null;
	}

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
}
class LLStack
{
	Node top;
	
	public LLStack()
	{
		this.top=null;
	}
	
	public boolean isEmpty()
	{
		return top==null;
	}
	public void push(int data)
	{
		Node newNode=new Node(data);
		newNode.next=top;
		top=newNode;
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return -1;
		}
		
		int poppedData=top.data;
		top=top.next;
		return poppedData;
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return -1;
		}
		return top.data;
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return;
		}
		Node current=top;
		
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
}
public class StackUsingLinkedList {

	public static void main(String[] args) {
		
		LLStack stack=new LLStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.display();
		
		stack.pop();
		
		stack.display();
		
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());

	}
}

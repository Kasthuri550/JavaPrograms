package linkedlist;

public class Node
{
	int data;
	Node next;
	
	public Node()
	{
		this.data=0;
		this.next=null;
	}
	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node(int data) {
		super();
		this.data = data;
	}
}
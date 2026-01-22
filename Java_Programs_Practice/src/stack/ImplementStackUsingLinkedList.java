package stack;

/*
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * */
class StackLL
{
	private static class Node
	{
		int data;
		Node next;

		Node(int data)
		{
			this.data=data;
		}
	}

	int size=0;
	Node top;

	void push(int x)
	{
		Node newNode=new Node(x);
		newNode.next=top;
		top=newNode;
		size++;
	}

	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}

		int value=top.data;
		top=top.next;
		size--;
		return value;
	}

	int peek()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}

		return top.data;
	}

	boolean isEmpty()
	{
		return top==null;
	}

	int size()
	{
		return size;
	}

	void show()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}

		Node temp=top;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}

public class ImplementStackUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackLL stackLL=new StackLL();
		stackLL.push(45);
		stackLL.push(32);
		stackLL.push(21);
		stackLL.push(56);

		stackLL.show();

		System.out.println(stackLL.pop());
		System.out.println(stackLL.peek());
		System.out.println(stackLL.isEmpty());
		System.out.println(stackLL.size());
	}
}

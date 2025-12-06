package stack;

class MyStack
{
	int arr[],top,capacity;
	
	MyStack(int size)
	{
		arr=new int[size];
		capacity=size;
		top=-1;
	}
	
	void push(int x)
	{
		if(isFull())
		{
			throw new RuntimeException("Stack Overflow");
		}
		
		arr[++top]=x;
	}
	
	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack Underflow");
		}
		
		return arr[top--];
	}
	
	int peek()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}
		return arr[top];
	}
	
	int size()
	{
		return top+1;
	}
	
	boolean isEmpty()
	{
		return top==-1;
	}
	
	boolean isFull()
	{
		return top==capacity-1;
	}
	
	void show()
	{
		for(int i=0;i<=top;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}

public class ImplementStackUsingArray {

	public static void main(String[] args) {
		
		MyStack mystack=new MyStack(5);
		mystack.push(34);
		mystack.push(89);
		mystack.push(23);
		mystack.push(45);
		mystack.push(78);
		mystack.show();
		System.out.println();
		System.out.println(mystack.peek());
		System.out.println(mystack.pop());
		mystack.show();
		System.out.println(mystack.isFull());
		System.out.println(mystack.isEmpty());
		System.out.println(mystack.size());
		System.out.println(mystack.peek());
		
	}
}

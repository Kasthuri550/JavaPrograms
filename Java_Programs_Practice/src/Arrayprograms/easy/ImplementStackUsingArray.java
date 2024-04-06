package Arrayprograms.easy;

class MyStack
{
	private static final int size=10000;
	private int arr[];
	private int top;
	
	MyStack()
	{
		arr=new int[size];
		top=-1;
	}
	
	public void push(int x)
	{
		if(top==arr.length-1)
		{
			System.out.println("Stack Overflow");
			return;
		}
		
		top++;
		arr[top]=x;
	}
	
	public int pop()
	{
		if(top==-1)
		{
			System.out.println("Stack Underflow");
			return -1;
		}
		int x=arr[top];
		top--;
		return x;
	}
	
	public int top()
	{
		return arr[top];
	}
	
	public int size()
	{
		return top+1;
	}
	
	public boolean isEmpty()
	{
		if(top==-1)
		{
			return true;
		}
		
		return false;
	}
	
	public void print()
	{
		for(int i=0;i<top;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
public class ImplementStackUsingArray {

	public static void main(String[] args) {
		
		MyStack stack=new MyStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.print();		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println(stack.size());
		System.out.println(stack.top());

	}
}

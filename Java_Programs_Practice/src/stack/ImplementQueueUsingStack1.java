package stack;

import java.util.Stack;

class MyQueue
{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();
	
	void push(int newElement)
	{
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.peek());
			stack1.pop();
		}
		
		stack1.push(newElement);
		
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.peek());
			stack2.pop();
		}
		
	}
	
	int pop()
	{
		return stack1.pop();
	}
	
	int top()
	{
		return stack1.peek();
	}
	
	boolean isEmpty()
	{
		return stack1.isEmpty();
	}
	
	void traverse()
	{
		stack1.forEach(ele -> System.out.println(ele));
	}
}

public class ImplementQueueUsingStack1 {

	public static void main(String[] args) {
		
		MyQueue myqueue=new MyQueue();
		myqueue.push(10);
		myqueue.push(20);
		myqueue.push(30);
		myqueue.push(40);
		System.out.println(myqueue.pop());
		myqueue.traverse();

	}
}

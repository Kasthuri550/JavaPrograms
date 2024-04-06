package stack;

import java.util.Stack;

class Queue
{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();

	void push(int newElement)
	{
		stack1.push(newElement);
	}

	int pop()
	{
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.peek());
				stack1.pop();
			}
		}
		
		return stack2.pop();
	}

	int top()
	{
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.peek());
				stack1.pop();
			}
		}
		
		return stack2.peek();
	}

	boolean isEmpty()
	{
		return stack2.isEmpty();
	}

	void traverse()
	{
		stack2.forEach(ele -> System.out.println(ele));
	}
}
public class ImplementQueueUsingStack2 {

	public static void main(String[] args) {

		Queue myqueue=new Queue();
		myqueue.push(10);
		myqueue.push(20);
		myqueue.push(30);
		myqueue.push(40);
		System.out.println("Pop"+myqueue.pop());
		System.out.println("Top"+myqueue.top());
		myqueue.traverse();
		System.out.println("Empty"+myqueue.isEmpty());

	}

}

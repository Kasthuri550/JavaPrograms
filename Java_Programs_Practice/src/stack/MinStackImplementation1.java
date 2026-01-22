package stack;

import java.util.Stack;

/*
 * Time Complexity: O(1)
 * Space Complexity: O(2n)
 * */
class MinStack
{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();
	
	public void push(int val)
	{
		stack1.push(val);
		
		if(stack2.isEmpty() || val<=stack2.peek())
		{
			stack2.push(val);
		}
	}
	
	public void pop()
	{
		if(stack1.isEmpty()) return;
		
		int removed=stack1.pop();
		
		if(removed==stack2.peek())
		{
			stack2.pop();
		}
	}
	
	public int top()
	{
		return stack1.peek();
	}
	
	public int getMin()
	{
		return stack2.peek();
	}
}
public class MinStackImplementation1 {

	public static void main(String[] args) {
		
		minStackApproach1();
	}

	private static void minStackApproach1() {

		MinStack minStack=new MinStack();
		minStack.push(12);
		minStack.push(15);
		minStack.push(10);
		minStack.push(30);
		minStack.push(60);
		minStack.pop();
		
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		
	}
}

package stack;

import java.util.Stack;
/*
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * */
class MiniStack
{
	Stack<Long> stack=new Stack<>();
	long min;

	public void push(int val)
	{
		if(stack.isEmpty())
		{
			stack.push((long)val);
			min=val;
		}
		else
		{
			if(val<min)
			{
				stack.push(2L*val-min);
				min=val;
			}
			else
			{
				stack.push((long)val);
			}
		}
	}

	public void pop()
	{
		if(stack.isEmpty()) return;

		long removed=stack.pop();

		if(removed<min)
		{
			min=2*min-removed;
		}
	}

	public int top()
	{
		long top=stack.peek();
		if(top<min)
		{
			return (int)min;
		}

		return (int)top;
	}

	public int getMin()
	{
		return (int)min;
	}
}
public class MinStackImplementation2 {

	public static void main(String[] args) {

		MiniStack minStack=new MiniStack();
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

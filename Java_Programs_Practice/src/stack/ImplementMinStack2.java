package stack;

import java.util.Stack;

class MinStack2
{
	Stack<Long> stack;
	Long min;
	public MinStack2() {
		super();
		this.stack = new Stack<>();
		min=Long.MAX_VALUE;
	}
	
	public void push(int element)
	{
		Long val=Long.valueOf(element);
		if(stack.isEmpty())
		{
			min=val;
			stack.push(val);
		}
		else
		{
			if(val < min)
			{
				stack.push(2*val-min);
				min=val;
			}
			else
			{
				stack.push(val);
			}
		}
	}
	
	public void pop()
	{		
		Long val=stack.peek();
		if(val < min)
		{
			min=2*min-val;
		}
		
		stack.pop();
	}
	
	public int top()
	{
		Long val= stack.peek();
		
		if(val<min)
			return min.intValue();
		
		return val.intValue();
	}
	
	public int getMin()
	{
		return min.intValue();
	}
}
public class ImplementMinStack2 {

	public static void main(String[] args) {
		
		MinStack2 minStack2=new MinStack2();
		minStack2.push(60);
		minStack2.push(20);
		minStack2.push(30);
		minStack2.push(5);
		minStack2.push(23);
		
		System.out.println(minStack2.top());

	}
}

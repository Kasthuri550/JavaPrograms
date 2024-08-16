package stack;

import java.util.Stack;

class Pair
{
	int element,min;

	public Pair(int element, int min) {
		super();
		this.element = element;
		this.min = min;
	}

	@Override
	public String toString() {
		return "Pair [element=" + element + ", min=" + min + "]";
	}
}
class MinStack1
{
	Stack<Pair> stack;

	public MinStack1() {
		super();
		this.stack =new Stack<>();
	}
	
	public void push(int value)
	{
		int min;
		if(stack.isEmpty())
		{
			min=value;
		}
		else
		{
			min=Math.min(stack.peek().min,value);
		}
		
		stack.push(new Pair(value,min));
	}
	
	public void pop()
	{		
		stack.pop();
	}
	
	public int top()
	{
		return stack.peek().element;
	}
	
	public int getMin()
	{
		return stack.peek().min;
	}
	
	public void show()
	{
		while(!stack.isEmpty())
		{
			System.out.print(stack.peek()+" ");
			stack.pop();
		}
	}
}
public class ImplementMinStack1 {

	public static void main(String[] args) {
		
		MinStack1 minStack=new MinStack1();
		minStack.push(10);
		minStack.push(20);
		minStack.push(12);
		minStack.push(5);
		minStack.push(56);
		
//		minStack.show();
		
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		
//		minStack.show();
		System.out.println(minStack.getMin());

	}
}

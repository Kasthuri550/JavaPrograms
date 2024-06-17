package stack;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class ReverseStackUsingQueue {

	public static void main(String[] args) {
		
		Stack<Integer> stack=new Stack<>();
		stack.push(40);
		stack.push(30);
		stack.push(20);
		stack.push(10);
		
		System.out.println(stack);
		reverse(stack);
		
	}

	private static void reverse(Stack<Integer> stack) {
		
		Queue<Integer> queue=new LinkedList<>();
		
		while(!stack.isEmpty())
		{
			queue.add(stack.pop());
		}
		
		System.out.println(queue);
		
		while(!queue.isEmpty())
		{
			stack.push(queue.poll());
		}
		
		System.out.println(stack);
	}
}

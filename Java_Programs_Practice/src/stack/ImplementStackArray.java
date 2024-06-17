package stack;

class Stack{
	
	int arr[],top;
	
	Stack(int size)
	{
		arr=new int[size];
		top=-1;		
	}
	
	public void push(int newEle)
	{
		arr[++top]=newEle;
	}
	
	public int pop()
	{
		int poppedEle=arr[top];
		top--;
		return poppedEle;
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
		return top==-1;
	}
}

public class ImplementStackArray {

	public static void main(String[] args) {
		
		Stack stack=new Stack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());

	}

}

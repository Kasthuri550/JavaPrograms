package stack;

/*
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * */
class DynamicStack
{
	int arr[],top;

	DynamicStack()
	{
		arr=new int[2];
		top=-1;
	}

	void push(int x)
	{
		if(isFull())
		{
			resize(arr.length*2);
		}

		arr[++top]=x;
	}

	int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack Underflow");
		}

		if(top>0 && top==arr.length/4)
		{
			resize(arr.length/2);
		}
		return arr[top--];
	}

	int peek()
	{
		if(isEmpty())
		{
			throw new RuntimeException("Stack Underflow");
		}

		return arr[top];
	}

	boolean isEmpty()
	{
		return top==-1;
	}

	boolean isFull()
	{
		return top==arr.length-1;
	}

	void resize(int newSize)
	{
		int temp[]=new int[newSize];
		System.arraycopy(arr, 0, temp, 0, top+1);
		arr=temp;
	}

	void show()
	{
		for(int i=0;i<=top;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

public class ImplementDynamicStackUsingArray {

	public static void main(String[] args) {

		DynamicStack dynamicStack=new DynamicStack();
		//		dynamicStack.push(89);
		//		dynamicStack.push(45);
		//		dynamicStack.push(13);
		//		dynamicStack.push(98);

		dynamicStack.show();

		System.out.println(dynamicStack.pop());
		System.out.println(dynamicStack.peek());
		System.out.println(dynamicStack.isEmpty());
		System.out.println(dynamicStack.isFull());
	}
}

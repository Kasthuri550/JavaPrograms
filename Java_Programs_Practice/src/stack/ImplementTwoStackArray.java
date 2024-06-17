package stack;

class TwoStack
{
	int top1,top2,arr[],size;
	TwoStack(int size)
	{
		this.size=size;
		arr=new int[size];
		top1=-1;
		top2=size;
	}
	
	public void push1(int newElement)
	{
		if(top1<top2-1)
		{
			arr[++top1]=newElement;
		}
		else
		{
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}
	
	public void push2(int newElement)
	{
		if(top1<top2-1)
		{
			arr[--top2]=newElement;
		}
		else
		{
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}
	public int pop1()
	{
		if(top1>=0)
		{
			int poppedEle=arr[top1];
			top1--;
			return poppedEle;
		}
		else
		{
			return -1;
		}
	}
	
	public int pop2()
	{
		if(top2<size)
		{
			int poppedEle=arr[top2];
			top2++;
			return poppedEle;
		}
		else
		{
			return -1;
		}
	}
	
	public int size1()
	{
		return top1+1;
	}
	
	public int size2()
	{
		return size-top2;
	}
	
	public boolean empty1()
	{
		return top1==-1;
	}
	
	public boolean empty2()
	{
		return top2==arr.length;
	}
	
	public int top1()
	{
		if(top1>=0)
		{
			return arr[top1];
		}
		else
		{
			return -1;
		}
	}
	
	public int top2()
	{
		if(top2<size)
		{
			return arr[top2];
		}
		else
		{
			return -1;
		}
	}
}
public class ImplementTwoStackArray {

	public static void main(String[] args) {
		
		TwoStack twoStack=new TwoStack(10);
		twoStack.push1(10);
		twoStack.push1(20);
		twoStack.push1(30);
		twoStack.push1(40);
		twoStack.push2(100);
		twoStack.push2(90);
		System.out.println(twoStack.pop1());
		System.out.println(twoStack.size1()+" "+twoStack.size2());
		System.out.println(twoStack.pop2());
		System.out.println(twoStack.top1());
		System.out.println(twoStack.top2());
	}
}

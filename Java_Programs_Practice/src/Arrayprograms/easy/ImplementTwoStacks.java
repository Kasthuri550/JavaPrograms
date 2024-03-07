package Arrayprograms.easy;

import java.util.Arrays;

class TwoStacks
{
	int top1,top2,size;
	int arr[];

	public TwoStacks(int n) {
		
		this.size=n;
		this.top1=-1;
		this.top2=size;
		this.arr=new int[n];
	}
	
	public void push1(int x)
	{
		if(top1<top2-1)
		{
			top1++;
			arr[top1]=x;
		}
		else
		{
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}
	
	public void push2(int x)
	{
		if(top1<top2-1)
		{
			top2--;
			arr[top2]=x;
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
			int x=arr[top1];
			top1--;
			return x;
		}
		else
		{
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}
	
	public int pop2()
	{
		if(top2<size)
		{
			int x=arr[top2];
			top2++;
			return x;
		}
		else
		{
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}

	@Override
	public String toString() {
		return "TwoStacks [arr=" + Arrays.toString(arr) + "]";
	}
}

public class ImplementTwoStacks {

	public static void main(String[] args) {
		
		TwoStacks twoStacks=new TwoStacks(10);
		twoStacks.push1(10);
		twoStacks.push1(20);
		twoStacks.push1(30);
		System.out.println(twoStacks.pop1());
		
		
	}
}

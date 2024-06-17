package linkedlist;

import java.util.Stack;

class LLNode
{
	int data;
	LLNode next;
	
	public LLNode(int data) {
		super();
		this.data = data;
		this.next = null;
	}
}
public class CheckLinkedListPalindrome {

	public static void main(String[] args) {
		
		LLNode llNode=new LLNode(1);
		llNode.next=new LLNode(5);
		llNode.next.next=new LLNode(2);
		llNode.next.next.next=new LLNode(5);
		llNode.next.next.next.next=new LLNode(1);
		
//		System.out.println(checkLLPalindromeBrute(llNode));
		System.out.println(checkLLPalindromeOptimal(llNode));

	}

	private static boolean checkLLPalindromeOptimal(LLNode llNode) {
		
		
		if(llNode==null || llNode.next==null)
			return true;
		
		LLNode slow=llNode;

		LLNode fast=llNode;
		
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		LLNode newHead=reverseLL(slow.next);
		
		LLNode first=llNode,second=newHead;
		
		while(second!=null)
		{
			if(first.data!=second.data)
			{
				reverseLL(newHead);
				return false;
			}
			
			first=first.next;
			second=second.next;
		}
		
		reverseLL(newHead);
		return true;
	}

	private static LLNode reverseLL(LLNode newHead) {
		
		LLNode temp=newHead,prev=null;
		
		while(temp!=null)
		{
			LLNode front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		
		return prev;
	}

	private static boolean checkLLPalindromeBrute(LLNode llNode) {
		
		if(llNode==null || llNode.next==null)
			return true;
		
		LLNode temp=llNode;
		
		Stack<Integer> stack=new Stack<>();
		
		while(temp!=null)
		{
			stack.push(temp.data);
			temp=temp.next;
		}
		
		temp=llNode;
		
		while(temp!=null)
		{
			if(temp.data!=stack.peek())
			{
				return false;
			}
			stack.pop();
			temp=temp.next;
		}
		
		return true;
	}
}

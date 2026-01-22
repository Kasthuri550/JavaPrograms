package linkedlist.medium;

import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {

		Node node=new Node(1);
		node.next=new Node(3);
		node.next.next=new Node(2);
		node.next.next.next=new Node(4);

//		Node reversedNode0=reverseLinkedListBrute(node);
//		Node reversedNode1=reverseLinkedListIterative(node);
		Node reversedNode2=reverseLinkedListRecursive(node);
		print(reversedNode2);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static Node reverseLinkedListRecursive(Node head) {

		if(head==null || head.next==null)
			return head;

		Node newHead=reverseLinkedListRecursive(head.next);
		Node front=head.next;
		front.next=head;
		head.next=null;

		return newHead;
	}

	/*
	 * Time Complexity: O(2n)
	 * Space Complexity: O(n)
	 * */
	private static Node reverseLinkedListBrute(Node head) {

		Stack<Integer> stack=new Stack<>();

		Node temp=head;

		while(temp!=null)
		{
			stack.push(temp.data);
			temp=temp.next;
		}

		temp=head;

		while(temp!=null)
		{
			temp.data=stack.pop();
			temp=temp.next;
		}

		return head;
	}

	private static void print(Node copiedList) {

		Node temp=copiedList;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */	
	private static Node reverseLinkedListIterative(Node head) {

		if(head==null || head.next==null)
			return head;

		Node prev=null;
		Node temp=head;

		while(temp!=null)
		{
			Node front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}

		return prev;
	}
}

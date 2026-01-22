package linkedlist.medium;

import java.util.HashMap;

import org.omg.CORBA.DynamicImplementation;

public class CopyListWithRandomPointer {

	private static class Node
	{
		int data;
		Node next;
		Node random;

		Node(int data)
		{
			this.data=data;
		}
	}

	public static void main(String[] args) {

		Node n1 = new Node(7);
		Node n2 = new Node(13);
		Node n3 = new Node(11);
		Node n4 = new Node(10);
		Node n5 = new Node(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		n1.random = null;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n1;

		Node head = n1;

		//		Node copiedList1=copyListWithRandomPointersBrute(head);
		Node copiedList2=copyListWithRandomPointersOptimal(head);
		print(copiedList2);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static Node copyListWithRandomPointersOptimal(Node head) {

		if(head==null)
			return head;

		Node temp=head;

		while(temp!=null)
		{
			Node copyNode=new Node(temp.data);
			copyNode.next=temp.next;
			temp.next=copyNode;
			temp=temp.next.next;
		}

		temp=head;

		while(temp!=null)
		{
			Node copyNode=temp.next;
			if(temp.random!=null)
				copyNode.random=temp.random.next;
			else
				copyNode.random=null;

			temp=temp.next.next;
		}

		Node dummyNode=new Node(-1);
		Node copyNode=dummyNode;

		temp=head;

		while(temp!=null)
		{
			copyNode.next=temp.next;
			copyNode=copyNode.next;
			temp.next=temp.next.next;
			temp=temp.next;
		}

		return dummyNode.next;
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
	 * Space Complexity: O(n)
	 * */
	private static Node copyListWithRandomPointersBrute(Node head) {

		if(head==null)
			return head;

		Node temp=head;

		HashMap<Node,Node> hashMap=new HashMap<>();

		while(temp!=null)
		{
			hashMap.put(temp,new Node(temp.data));
			temp=temp.next;
		}

		temp=head;

		while(temp!=null)
		{
			Node copyNode=hashMap.get(temp);
			copyNode.next=hashMap.get(temp.next);
			copyNode.random=hashMap.get(temp.random);
			temp=temp.next;
		}

		return hashMap.get(head);
	}
}

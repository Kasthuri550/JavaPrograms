package linkedlist.hard;

import java.util.HashMap;
import java.util.Map;

class Node
{
	int data;
	Node next,random;

	Node()
	{
		this.data=0;
		this.next=null;
		this.random=null;
	}

	Node(int data)
	{
		this.data=data;
		this.next=null;
		this.random=null;
	}

	Node(int data,Node nextNode,Node randomNode)
	{
		this.data=data;
		this.next=nextNode;
		this.random=randomNode;
	}
}

public class CloneLinkedListWithRandomAndNextPointer {

	public static void main(String[] args) {

		Node head = new Node(7);
		head.next = new Node(14);
		head.next.next = new Node(21);
		head.next.next.next = new Node(28);

		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next;
		head.next.next.next.random = head.next;

		System.out.println("Original List Brute force");
		printClonedLL(head);

		Node newNode1=cloneLLBrute(head);

		System.out.println();
		System.out.println("Cloned List Brute force");
		printClonedLL(newNode1);

		System.out.println();

		System.out.println("Original List Optimal");
		printClonedLL(head);

		Node newNode2=cloneLLOptimal(head);

		System.out.println();
		System.out.println("Cloned List Optimal");
		printClonedLL(newNode2);

	}
	/*
	 * Time Complexity: O(3N)
	 * Space Complexity: O(N)
	 */
	private static Node cloneLLOptimal(Node head) {

		if(head==null) return null;

		insertCopyInBetween(head);

		connectRandomPointers(head);

		return getDeepCopyList(head);
	}

	private static Node getDeepCopyList(Node head) {

		Node temp=head;
		Node dummyNode=new Node(-1);
		Node resultNode=dummyNode;

		while(temp!=null)
		{
			resultNode.next=temp.next;
			resultNode=resultNode.next;

			temp.next=temp.next.next;
			temp=temp.next;

		}

		return dummyNode.next;
	}

	private static void connectRandomPointers(Node head) {

		Node temp=head;

		while(temp!=null)
		{
			Node copyNode=temp.next;

			if(temp.random!=null)
			{
				copyNode.random=temp.random.next;
			}
			else
			{
				copyNode.random=null;
			}

			temp=temp.next.next;
		}
	}

	private static void insertCopyInBetween(Node head) {

		Node temp=head;

		while(temp!=null)
		{
			Node node=new Node(temp.data);

			node.next=temp.next;
			temp.next=node;
			temp=temp.next.next;
		}
	}
	/*
	 * Time Complexity: O(2N)
	 * Space Complexity: O(N)+O(N)
	 */
	private static Node cloneLLBrute(Node head) {

		Node temp=head;

		Map<Node,Node> map=new HashMap<>();

		while(temp!=null)
		{
			Node newNode=new Node(temp.data);
			map.put(temp,newNode);
			temp=temp.next;
		}

		temp=head;

		while(temp!=null)
		{
			Node copyNode=map.get(temp);

			copyNode.next=map.get(temp.next);
			copyNode.random=map.get(temp.random);
			temp=temp.next;
		}

		return map.get(head);
	}

	private static void printClonedLL(Node head) {

		while(head!=null)
		{
			System.out.print("Node: "+head.data+" ");

			if(head.random!=null)
			{
				System.out.print("Random: "+head.random.data+" ");
			}
			head=head.next;
		}
	}
}

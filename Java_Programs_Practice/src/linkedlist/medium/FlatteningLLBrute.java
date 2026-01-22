package linkedlist.medium;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Time Complexity: O(n*m + (n*m)log(n*m) + (n*m))
 * Space Complexity: O(n*m)+O(n*m)
 * */
public class FlatteningLLBrute {

	private static class Node {
		int val;
		Node next;
		Node child;

		Node(int val) {
			this.val = val;
		}
	}

	private static Node createInput()
	{
		Node head = new Node(5);
		head.child = new Node(7);
		head.child.child = new Node(8);
		head.child.child.child = new Node(30);

		head.next = new Node(10);
		head.next.child = new Node(20);

		head.next.next = new Node(19);
		head.next.next.child = new Node(22);
		head.next.next.child.child = new Node(50);

		head.next.next.next = new Node(28);
		head.next.next.next.child = new Node(35);
		head.next.next.next.child.child = new Node(40);
		head.next.next.next.child.child.child = new Node(45);

		return head;
	}
	public static void main(String[] args) {

		Node head=createInput();

		Node flattenedList=flatteningListBrute(head);
		print(flattenedList);
	}

	private static void print(Node head) {

		Node temp=head;

		while(temp!=null)
		{
			System.out.println(temp.val+" ");
			temp=temp.child;
		}
	}

	private static Node flatteningListBrute(Node head) {

		if(head==null)
			return head;

		ArrayList<Integer> list=new ArrayList<>();

		while(head!=null)
		{
			Node curr=head;
			while(curr!=null)
			{
				list.add(curr.val);
				curr=curr.child;
			}

			head=head.next;
		}

		Collections.sort(list);

		return convertArrtoLinkedList(list);
	}
	private static Node convertArrtoLinkedList(ArrayList<Integer> list) {

		Node root=new Node(list.get(0));
		Node node=root;

		for(int i=1;i<list.size();i++)
		{
			Node newNode=new Node(list.get(i));
			node.child=newNode;
			node=newNode;			
		}

		return root;
	}
}

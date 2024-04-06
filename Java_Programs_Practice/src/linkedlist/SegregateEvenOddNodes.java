package linkedlist;

import java.util.ArrayList;

public class SegregateEvenOddNodes {

	public static void main(String[] args) {
		
		int arr[]= {34,23,12,56,67};
		
		Node head=insertion(arr);
		
		Node temp=evenOdd(head);
		
		traverse(temp);
		
	}

	private static void traverse(Node temp) {
		
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}

	private static Node evenOdd(Node head) {
		
		ArrayList<Integer> arrayList=new ArrayList<>();
		Node temp=head;
		
		while(temp!=null && temp.next!=null)
		{
			arrayList.add(temp.data);
			temp=temp.next.next;
		}
		
		if(temp!=null)
		{
			arrayList.add(temp.data);
		}
		
		Node mover=head.next;
		
		while(mover!=null && mover.next!=null)
		{
			arrayList.add(mover.data);
			mover=mover.next.next;
		}
		
		if(temp!=null)
		{
			arrayList.add(mover.data);
		}
		
		int i=0;
		temp=head;
		while(temp!=null)
		{
			temp.data=arrayList.get(i);
			temp=temp.next;
			i++;
		}
		
		return temp;
	}

	private static Node insertion(int[] arr) {
		
		Node head=new Node(arr[0]);
		Node mover=head;
		for(int i=1;i<arr.length;i++)
		{
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=temp;
		}
		return head;
	}
}

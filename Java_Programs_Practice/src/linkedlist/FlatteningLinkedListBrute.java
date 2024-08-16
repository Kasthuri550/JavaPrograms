package linkedlist;

import java.util.ArrayList;
import java.util.Collections;

class ListNode
{
	int data;
	ListNode next;
	ListNode bottom;
	
	public ListNode(int data) {
		super();
		this.data = data;
		this.next=null;
		this.bottom=null;
	}

	public ListNode(int data, ListNode next, ListNode bottom) {
		super();
		this.data = data;
		this.next = next;
		this.bottom = bottom;
	}	
}

public class FlatteningLinkedListBrute {

	public static void main(String[] args) {
		
		ListNode head=new ListNode(5);
		head.bottom=new ListNode(7);
		head.bottom.bottom=new ListNode(8);
		head.bottom.bottom.bottom=new ListNode(30);
		head.next=new ListNode(10);
		head.next.bottom=new ListNode(20);
		head.next.next=new ListNode(19);
		head.next.next.bottom=new ListNode(22);
		head.next.next.bottom.bottom=new ListNode(50);
		head.next.next.next=new ListNode(28);	
		head.next.next.next.bottom=new ListNode(35);	
		head.next.next.next.bottom.bottom=new ListNode(40);
		head.next.next.next.bottom.bottom.bottom=new ListNode(45);
		
		ListNode newHead=flattenLL(head);
		
		printLL(newHead);
	}

	private static void printLL(ListNode newHead) {
		
		while(newHead!=null)
		{
			System.out.print(newHead.data+" ");
			newHead=newHead.bottom;
		}
		System.out.println();
	}

	private static ListNode flattenLL(ListNode head) {
		
		ListNode temp=head;
		
		ArrayList<Integer> arrList=new ArrayList<Integer>();
		
		while(temp!=null)
		{
			ListNode bottom=temp;
			while(bottom!=null)
			{
				arrList.add(bottom.data);
				bottom=bottom.bottom;
			}
			temp=temp.next;
		}
		
		Collections.sort(arrList);
		
		ListNode root=new ListNode(arrList.get(0));
		ListNode node=root;
		
		for(int i=1;i<arrList.size();i++)
		{
			ListNode newNode=new ListNode(arrList.get(i));
			node.bottom=newNode;
			node=newNode;			
		}
		
		return root;
	}
}

package linkedlist.medium;

public class RemoveNthNodeOfTheEndOfTheLinkedList {

	public static void main(String[] args) {

		int n = 2;
		Node head = new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);

//		Node removedNth1=removeNthNodeBrute(head,n);
		Node removedNth2=removeNthNodeOptimal(head,n);
		print(removedNth2);
	}

	private static Node removeNthNodeOptimal(Node head, int n) {

		if(head==null)
			return null;

		Node fast=head;

		for(int i=0;i<n;i++)
		{
			fast=fast.next;
		}

		if(fast==null)
			return head.next;

		Node slow=head;

		while(fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next;
		}

		slow.next=slow.next.next;

		return head;
	}

	/*
	 * Time Complexity: O(l)+O(l-n)
	 * Space Complexity: O(1)
	 * */	
	private static void print(Node removedNth) {

		Node temp=removedNth;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node removeNthNodeBrute(Node head,int n) {

		if(head==null)
			return null;

		Node temp=head;
		int count=0;

		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}

		if(count==n)
		{
			return head.next;
		}

		int rem=count-n;

		temp=head;

		while(temp!=null)
		{
			rem--;

			if(rem==0)
				break;

			temp=temp.next;
		}

		temp.next=temp.next.next;

		return head;
	}
}

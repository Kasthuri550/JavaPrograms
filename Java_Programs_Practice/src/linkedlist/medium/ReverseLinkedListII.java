package linkedlist.medium;

public class ReverseLinkedListII {

	public static void main(String[] args) {

		int left = 2, right = 4;

		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);

		Node reversedList=reverseLinkedListII(head,left,right);
		print(reversedList);
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static void print(Node copiedList) {

		Node temp=copiedList;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node reverseLinkedListII(Node head, int left, int right) {

		Node dummyNode=new Node(-1);
		dummyNode.next=head;

		Node leftPrevNode=dummyNode;
		Node currNode=head;

		for(int i=0;i<left-1;i++)
		{
			leftPrevNode=leftPrevNode.next;
			currNode=currNode.next;
		}

		Node subListHead=currNode;
		Node prevNode=null;

		for(int i=0;i<=right-left;i++)
		{
			Node front=currNode.next;
			currNode.next=prevNode;
			prevNode=currNode;
			currNode=front;
		}

		leftPrevNode.next=prevNode;
		subListHead.next=currNode;

		return dummyNode.next;
	}
}

package linkedlist.medium;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {

		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(3);
		head.next.next.next.next=new Node(4);
		head.next.next.next.next.next=new Node(4);
		head.next.next.next.next.next.next=new Node(5);

		Node removeDuplicates=removeDuplicatesII(head);
		print(removeDuplicates);
	}

	private static void print(Node removeDuplicates) {

		Node temp=removeDuplicates;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}

	}

	private static Node removeDuplicatesII(Node head) {

		Node dummy=new Node(-1);
		dummy.next=head;

		Node prev=dummy;
		Node curr=head;

		while(curr!=null)
		{
			if(curr.next!=null && curr.data==curr.next.data)
			{
				int duplicateVal=curr.data;

				while(curr!=null && curr.data==duplicateVal)
				{
					curr=curr.next;
				}

				prev.next=curr;
			}
			else
			{
				prev=curr;
				curr=curr.next;
			}
		}

		return dummy.next;
	}
}

package linkedlist.medium;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {

		Node head=new Node(1);
		head.next=new Node(1);
		head.next.next=new Node(2);
		head.next.next.next=new Node(3);
		head.next.next.next.next=new Node(3);

		Node removedDuplicates=removeDuplicates(head);
		print(removedDuplicates);
	}

	private static void print(Node removedDuplicates) {

		Node temp=removedDuplicates;

		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node removeDuplicates(Node head) {

		if(head==null)
			return head;

		Node curr=head;

		while(curr!=null && curr.next!=null)
		{
			if(curr.data==curr.next.data)
			{
				curr.next=curr.next.next;
			}
			else
			{
				curr=curr.next;
			}
		}

		return head;
	}
}

package linkedlist;
/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class AddOneToLinkedListBetter {

	public static void main(String[] args) {

		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);

		printList(head);

		Node newHead=addOne(head);
		printList(newHead);

	}

	private static Node addOne(Node head) {

		head=reverse(head);
		head=addOneToLinkedList(head);
		head=reverse(head);

		return head;
	}

	private static Node addOneToLinkedList(Node head) {

		Node current=head;
		int carry=1;

		while(current!=null)
		{
			int sum=current.data+carry;
			current.data=sum%10;
			carry=sum/10;
			if(carry==0) break;
			if(current.next==null && carry>0)
			{
				current.next=new Node(carry);
				carry=0;
			}
			current=current.next;
		}
		return head;
	}

	private static Node reverse(Node head) {

		Node prev=null;
		Node current=head;
		Node next=null;

		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}

	private static void printList(Node head) {

		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();

	}
}

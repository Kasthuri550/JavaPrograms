package linkedlist;

public class AddOneToLinkedListOptimal {

	public static void main(String[] args) {
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		
		printList(head);
		
		Node newHead=addOne(head);
		
		printList(newHead);

	}

	private static Node addOne(Node head) {
		
		int carry=addRecursive(head);
		if(carry>0)
		{
			Node newNode=new Node(carry);
			newNode.next=head;
			head=newNode;
		}
		return head;
	}

	private static int addRecursive(Node head) {
		
		if(head==null) return 1;
		
		int carry=addRecursive(head.next);
		
		int sum=head.data+carry;
		head.data=sum%10;
 		return sum/10;
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

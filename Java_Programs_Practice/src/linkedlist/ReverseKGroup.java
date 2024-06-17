package linkedlist;

public class ReverseKGroup {

	public static void main(String[] args) {

		int k=4;

		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(2);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head.next.next.next.next.next=new Node(6);
		head.next.next.next.next.next.next=new Node(7);
//		head.next.next.next.next.next.next.next=new Node(8);
		
		printList(head);
		
		head=reverseKGroup(head,k);
		
		printList(head);

	}

	private static Node reverseKGroup(Node head, int k) {
		
		Node curr=head;
		int count=0;
		
		while(curr!=null && count!=k)
		{
			count++;
			curr=curr.next;
		}
		
		if(count==k)
		{
			curr=reverseKGroup(curr, k);
			
			while(count-->0)
			{
				Node temp=head.next;
				head.next=curr;
				curr=head;
				head=temp;
			}
			head=curr;
		}
		
		return head;
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

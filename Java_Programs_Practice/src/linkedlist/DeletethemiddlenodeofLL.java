package linkedlist;

public class DeletethemiddlenodeofLL {

	public static void main(String[] args) {
				
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
//		head.next.next.next.next=new Node(5);
		
//		Node modifiedHead=deleteMiddleBrute(head);
		Node modifiedHead=deleteMiddleOptimal(head);
		
		printLL(modifiedHead);

	}

	private static Node deleteMiddleOptimal(Node head) {
		
		if(head==null || head.next==null) return null;
		
		Node slow=head,fast=head;
		
		fast=fast.next.next;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		Node deleteNode=slow.next;
		slow.next=slow.next.next;
		deleteNode=null;
		return head;
	}

	private static void printLL(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	private static Node deleteMiddleBrute(Node head) {
		
		if(head==null || head.next==null) return null;
		
		Node temp=head;
		int count=0;
		
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		
		int middle=count/2;
		
		temp=head;
		
		while(temp!=null)
		{
			middle--;
			if(middle==0)
			{
				Node deleteNode=temp.next;
				temp.next=temp.next.next;
				deleteNode=null;
				return head;
			}
			temp=temp.next;
		}
		
		return head;
	}
}

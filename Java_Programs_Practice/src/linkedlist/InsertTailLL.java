package linkedlist;

public class InsertTailLL {

	public static void main(String[] args) {

		int arr[]= {34,23,12,56,67};

		Node head1=insertion(arr);
		Node head2=insertTail(head1,45);
		traverse(head2);
	}

	private static Node insertTail(Node head, int k) {
		
		if(head==null)
		{
			return new Node(k);
		}
		
		Node temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		Node newNode=new Node(k);
		temp.next=newNode;
		
		return head;
	}

	private static void traverse(Node head) {

		Node temp=head;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}

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

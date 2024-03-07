package linkedlist;

public class DeleteTailLL {

	public static void main(String[] args) {

		int arr[]= {34,23,12,56,67};

		Node head1=insertion(arr);
		Node head2=deleteTail(head1);
		traverse(head2);

	}

	private static Node deleteTail(Node head) {
		
		if(head==null||head.next==null)
		{
			return null;
		}
		
		Node temp=head;
		while(temp.next.next!=null)
		{
			temp=temp.next;
		}
		
		temp.next=null;
		
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

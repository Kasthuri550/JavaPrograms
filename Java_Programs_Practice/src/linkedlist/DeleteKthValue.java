package linkedlist;

public class DeleteKthValue {

	public static void main(String[] args) {

		int arr[]= {34,23,12,56,67};
		int k=89;
		Node head1=insertion(arr);
		Node head2=deleteKth(head1,k);
		traverse(head2);
	}

	private static Node deleteKth(Node head, int k) {

		if(head==null)
		{
			return null;
		}

		if(k==head.data)
		{
			Node temp=head;
			head=head.next;
			temp=null;
			return head;
		}

		Node temp=head;
		Node prev=null;

		while(temp!=null)
		{
			if(k==temp.data)
			{
				prev.next=prev.next.next;
				temp=null;
				break;
			}
			prev=temp;
			temp=temp.next;
		}

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

package linkedlist;

public class DeleteKthPosition {

	public static void main(String[] args) {
		
		int arr[]= {34,23,12,56,67};
		int k=5;
		Node head1=insertion(arr);
		Node head2=deleteKth(head1,k);
		traverse(head2);
	}
	
	private static Node deleteKth(Node head, int k) {
		
		if(head==null)
		{
			return null;
		}
		
		if(k==1)
		{
			Node temp=head;
			head=head.next;
			temp=null;
			return head;
		}
		
		int count=0;
		
		Node temp=head;
		Node prev=null;
		
		while(temp!=null)
		{
			count++;
			if(k==count)
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

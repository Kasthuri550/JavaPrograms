package linkedlist;

public class InsertionHeadLL {

	public static void main(String[] args) {
		
		int arr[]= {34,23,12,56,67};

		Node head1=insertion(arr);
		Node head2=insertHead(head1,98);
		traverse(head2);
	}
	
private static Node insertHead(Node list, int newValue) {
	
		if(list==null)
		{
			return new Node(newValue);
		}
		
		Node temp=new Node(newValue,list);
		return temp;
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

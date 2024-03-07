package linkedlist;

public class InsertBeforeKthValue {

	public static void main(String[] args) {

		int arr[]= {34,23,12,56,67};

		Node head1=insertion(arr);
		Node head2=insertKthValue(head1,100,90);
		traverse(head2);

	}

	private static Node insertKthValue(Node head, int x, int val) {

		if(head==null)
		{
			return head;
		}
		
		if(head.data==val)
		{
			Node newNode=new Node(x);
			newNode.next=head;
			return newNode;
		}
		
		Node temp=head;
		
		while(temp.next!=null)
		{
			if(temp.next.data==val)
			{
				Node newNode=new Node(x);
				newNode.next=temp.next;
				temp.next=newNode;
				break;
			}
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

package linkedlist;

public class InsertKthLL {

	public static void main(String[] args) {

		int arr[]= {34,23,12,56,67};

		Node head1=insertion(arr);
		Node head2=insertKthPosition(head1,78,1);
		traverse(head2);
	}

	private static Node insertKthPosition(Node head, int val, int pos) {

		if(head==null)
		{
			if(pos==1)
			{
				return new Node(val);
			}
			else
			{
				return head;
			}
		}
		
		Node temp=head;
		
		if(pos==1)
		{
			Node newNode= new Node(val);
			newNode.next=head;
			return newNode;
		}
		
		int count=0;
		while(temp.next!=null)
		{
			count++;
			if(count==pos-1)
			{
				Node newNode=new Node(val);
				newNode.next=temp.next;
				temp.next=newNode;
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

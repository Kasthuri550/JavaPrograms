package doublyLinkedList;

public class InsertNodeKthPos {

	public static void main(String[] args) {

		int arr[]= {78,23,12,45,56};

		Node head=convertArr2DLL(arr);

		print(head);
		
		Node newHead=insertNodeKthPos(head,67,3);
		
		print(newHead);
	}
	
	private static Node insertNodeKthPos(Node head, int newElement,int position) {
		
		if(position==0)
			return insertAfterHead(head,newElement);
		
		int count=1;
		
		Node temp=head;
		
		while(count<=position)
		{
			temp=temp.next;
			count++;
		}
		
		if(temp.next==null)
		{
			return insertAfterTail(head,newElement);
		}
		else 
		{
			Node front=temp.next;
			Node newNode=new Node(newElement);
			newNode.next=front;
			front.previous=newNode;
			temp.next=newNode;
			newNode.previous=temp;
		}
		
		return head;
	}

	private static Node insertAfterTail(Node head, int newElement) {
		
		Node temp=head;
		Node newNode=new Node(newElement);
		temp.next=newNode;
		newNode.previous=temp;
		
		return head;
	}

	private static Node insertAfterHead(Node head, int newElement) {
		
		Node temp=head;
		Node front=temp.next;
		Node newNode=new Node(newElement);
		newNode.next=front;
		front.previous=newNode;
		temp.next=newNode;
		newNode.previous=temp;
		
		return head;
	}

	private static void print(Node head) {

		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	private static Node convertArr2DLL(int[] arr) {

		Node head=new Node(arr[0]);
		Node temp=head;

		for(int i=1;i<arr.length;i++)
		{
			Node newNode=new Node(arr[i]);
			temp.next=newNode;
			newNode.previous=temp;
			temp=newNode;
		}

		return head;
	}
}

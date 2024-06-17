package doublyLinkedList;

public class InsertBeforeTail {

	public static void main(String[] args) {
		
		int arr[]= {34,45,12,89,76};
		
		Node head=convertArr2DLL(arr);
		print(head);
		Node newHead=insertBeforeTail(head,98);
		print(newHead);

	}

	private static Node insertBeforeTail(Node head, int newElement) {
		
		if(head.next==null)
			return insertBeforeHead(head,newElement);
		
		Node tail=head;
		
		while(tail.next!=null)
		{
			tail=tail.next;
		}
		
		Node prev=tail.previous;
		Node newNode=new Node(newElement);
		newNode.next=tail;
		tail.previous=newNode;
		prev.next=newNode;
		newNode.previous=prev;
		
		return head;
	}

	private static Node insertBeforeHead(Node head, int newElement) {
		
		Node newNode=new Node(newElement);
		
		newNode.next=head;
		head.previous=newNode;
		
		return newNode;
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

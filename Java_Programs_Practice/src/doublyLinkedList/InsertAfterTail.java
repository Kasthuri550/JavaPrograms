package doublyLinkedList;

public class InsertAfterTail {

	public static void main(String[] args) {
		
		int arr[]= {78,23,12,45,56};

		Node head=convertArr2DLL(arr);

		print(head);
		
		Node newHead=insertAfterTail(head,67);
		
		print(newHead);
		
	}
	
	private static Node insertAfterTail(Node head, int newElement) {
		
		Node temp=head;
		
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		Node newNode=new Node(newElement);
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

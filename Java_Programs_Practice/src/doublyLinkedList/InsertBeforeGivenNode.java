package doublyLinkedList;

public class InsertBeforeGivenNode {

	public static void main(String[] args) {

		int arr[]= {78,23,12,45,56};

		Node head=convertArr2DLL(arr);

		print(head);
		
		insertBeforeGivenNode(head.next.next.next.next,100);
		
		print(head);

	}

	private static void insertBeforeGivenNode(Node head, int data) {
		
		Node prev=head.previous;
		Node newNode=new Node(data);
		newNode.next=head;
		head.previous=newNode;
		prev.next=newNode;
		newNode.previous=prev;
		
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

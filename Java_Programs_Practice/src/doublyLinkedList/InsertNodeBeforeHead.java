package doublyLinkedList;

public class InsertNodeBeforeHead {
	
	public static void main(String[] args) {
		
		int arr[]= {77,45,23,89,12,56};
		
		Node head=convertArr2DLL(arr);
		
		print(head);
		
		Node newHead=insertNode(head,67);
		
		print(newHead);
		
	}

	private static Node insertNode(Node head, int newElement) {
		
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

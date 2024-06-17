package doublyLinkedList;

public class DeleteHead {

	public static void main(String[] args) {
		
		int arr[]= {34,69,53,12,90};
		
		Node head=convertArr2DLL(arr);
		
		Node newHead=deleteHeadNode(head);
		
		print(newHead);
	}

	private static void print(Node head) {
		
		while(head!=null)
		{
			System.out.println(head.data+" ");
			head=head.next;
		}
		
	}

	private static Node deleteHeadNode(Node head) {
		
		if(head==null || head.next==null) return null;
		
		Node previous=head;
		head=head.next;
		head.previous=null;
		previous.next=null;
		
		return head;
	}

	private static Node convertArr2DLL(int[] arr) {
		
		Node temp=new Node(arr[0]);
		Node previous=temp;
		
		for(int i=1;i<arr.length;i++)
		{
			Node newNode=new Node(arr[i]);
			previous.next=newNode;
			previous=newNode;
		}
		return temp;
	}
}

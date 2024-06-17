package doublyLinkedList;

public class DeleteNode {

	public static void main(String[] args) {
		
		int arr[]= {34,53,12,77,56};
		
		Node head=convertArr2Dll(arr);
		
		print(head);
		
		deleteNode(head.next.next.next.next);
		
		print(head);

	}

	private static void deleteNode(Node temp) {
		
		Node prev=temp.previous;
		Node front=temp.next;
		
		if(front==null)
		{
			prev.next=null;
			temp.previous=null;
			return;
		}
		
		prev.next=front;
		front.previous=prev;
		
		temp.next=null;
		temp.previous=null;
		
	}

	private static void print(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	private static Node convertArr2Dll(int[] arr) {
		
		Node temp=new Node(arr[0]);
		Node previous=temp;
		
		for(int i=1;i<arr.length;i++)
		{
			Node newNode=new Node(arr[i]);
			previous.next=newNode;
			newNode.previous=previous;
			previous=newNode;			
		}
		
		return temp;
	}
}

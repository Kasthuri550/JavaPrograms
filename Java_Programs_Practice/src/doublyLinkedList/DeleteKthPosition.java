package doublyLinkedList;

public class DeleteKthPosition {

	public static void main(String[] args) {
		
		int arr[]= {12,35,56,87,40},k=5;
		
		Node head=convertArr2DLL(arr);
		
		print(head);
		
		Node modifiedNode = deleteKthElement(head,k);
		
		print(modifiedNode);

	}

	private static Node deleteKthElement(Node head, int k) {
		
		if(head==null) return null;
		
		Node temp=head;
		int count=0;
		
		while(temp!=null)
		{
			count++;
			if(count==k) break;
			
			temp=temp.next;
		}
		
		Node prev=temp.previous;
		Node front=temp.next;
		
		if(prev==null && front==null)
		{
			return null;
		}
		else if(prev==null)
		{
			return deleteHead(head);
		}
		else if(front==null)
		{
			return deleteTail(head);
		}
		
		prev.next=front;
		front.previous=prev;
		temp.next=null;
		temp.previous=null;
		
		return head;
	}

	private static Node deleteTail(Node head) {
		
		if(head==null || head.next==null) return null;
		
		Node tail=head;
		
		while(tail.next!=null)
		{
			tail=tail.next;
		}
		
		Node prev=tail.previous;
		prev.next=null;
		tail.previous=null;
		
		return head;
	}

	private static Node deleteHead(Node head) {
		
		if(head==null || head.next==null) return null;
		
		Node prev=head;
		head=head.next;
		head.previous=null;		
		prev.next=null;
		
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

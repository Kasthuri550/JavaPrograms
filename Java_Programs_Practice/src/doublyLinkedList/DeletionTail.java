package doublyLinkedList;

public class DeletionTail {

	public static void main(String[] args) {
		
		int arr[]= {89,34,12,45,67};
		
		Node newHead=convertArr2DLL(arr);
		
		print(newHead);
		
		Node changeHead=deleteTail(newHead);
		print(changeHead);

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

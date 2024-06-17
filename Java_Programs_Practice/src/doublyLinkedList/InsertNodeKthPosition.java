package doublyLinkedList;

public class InsertNodeKthPosition {

	public static void main(String[] args) {
		
		int arr[]= {78,23,12,45,56};
		
		Node head=convertArr2DLL(arr);
		
		print(head);
		
		Node newHead=insertNodeKthPos(head,32,5);

		print(newHead);
	}

	private static Node insertNodeKthPos(Node head, int newElement,int position) {
		
		if(position==1)
		 return insertBeforeHead(head,newElement);
		
		Node temp=head;
		int count=0;
		
		while(temp!=null)
		{
			count++;
			if(count==position) break;
			
			temp=temp.next;
		}
		
		Node prev=temp.previous;
		Node newNode=new Node(newElement);
		newNode.next=temp;
		temp.previous=newNode;
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

package doublyLinkedList;

class Node
{
	int data;
	Node next;
	Node previous;
	
	Node(int data)
	{
		this.data=data;
		this.next=null;
		this.previous=null;
	}
	
	Node(int data,Node next,Node previous)
	{
		this.data=data;
		this.next=next;
		this.previous=previous;
	}
}

public class Arr2DLL {

	public static void main(String[] args) {
		
		int arr[]= {32,90,45,23,76};
		
		Node head=arr2dll(arr);
		
		printDll(head);
		
	}

	private static void printDll(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		
	}

	private static Node arr2dll(int[] arr) {
		
		Node temp=new Node(arr[0]);
		Node previous=temp;
		
		for(int i=1;i<arr.length;i++)
		{
			Node newNode=new Node(arr[i],null,previous);
			previous.next=newNode;
			previous=newNode;
		}
		
		return temp;
	}
}

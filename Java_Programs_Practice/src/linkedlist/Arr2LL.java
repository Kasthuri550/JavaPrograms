package linkedlist;

public class Arr2LL {

	public static void main(String[] args) {
		int arr[]= {3,4,5,7,8};	
		Node head=convertArr2LL(arr);
		System.out.println(head.data);
		System.out.println(head.next);
	}

	private static Node convertArr2LL(int[] arr) {
		
		Node head=new Node(arr[0]);
		Node mover=head;
		for(int i=1;i<arr.length;i++)
		{
			Node temp=new Node(arr[i]);
			mover.next=temp;
			mover=temp;
		}	
		return head;
	}
}

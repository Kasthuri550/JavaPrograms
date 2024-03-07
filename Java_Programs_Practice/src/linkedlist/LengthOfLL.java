package linkedlist;

public class LengthOfLL {

	public static void main(String[] args) {
		
		int arr[]= {34,56,90,21};
		
		Node head=convertArrtoLL(arr);
		int length=lengthLL(head);
		System.out.println(length);
	}

	private static int lengthLL(Node head) {
		
		Node temp=head;
		int count=0;
		
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		return count;
	}

	private static Node convertArrtoLL(int[] arr) {
		
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

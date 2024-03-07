package linkedlist;

public class Traversal {

	public static void main(String[] args) {
		
		int arr[]= {4,2,9,1,3};
		Node temp=LLTraversal(arr);
		
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		
	}

	private static Node LLTraversal(int[] arr) {
		
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

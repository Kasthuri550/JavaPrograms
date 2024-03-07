package linkedlist;

public class SearchLL {

	public static void main(String[] args) {

		int arr[]= {34,89,76,12,90};
		Node head=convertArrtoLL(arr);
		int boolCheck=checkifPresent(head,89);
		System.out.println(boolCheck);

	}

	private static int checkifPresent(Node head, int k) {
		
		Node temp=head;
		
		while(temp!=null)
		{
			if(temp.data==k)
			{
				return 1;
			}
			temp=temp.next;
		}
		return 0;
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

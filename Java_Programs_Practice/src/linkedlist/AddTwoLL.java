package linkedlist;

public class AddTwoLL {

	public static void main(String[] args) {
		
		
		int arr1[]= {3,5};
		int arr2[]= {4,5,9,9};
		Node head1=insertion(arr1);
		Node head2=insertion(arr2);
		Node head3=add(head1,head2);		
		traverse(head3);
	}

	private static void traverse(Node head3) {
		
		Node temp=head3;
		
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}

	private static Node add(Node head1, Node head2) {
		
		Node temp1=head1;
		Node temp2=head2;
		Node dummyNode=new Node(-1);
		Node dummy=dummyNode;
		int carry=0;
		
		while(temp1!=null || temp2!=null)
		{
			int sum=0;
			
			if(temp1!=null)
			{
				sum+=temp1.data;
				temp1=temp1.next;
			}
				
			if(temp2!=null)
			{
				sum+=temp2.data;
				temp2=temp2.next;
			}
			
			sum+=carry;
			carry=sum/10;
			Node newNode=new Node(sum%10);
			dummy.next=newNode;
			dummy=newNode;				
		}
		
		if(carry>0)
		{
			Node newNode=new Node(carry);
			dummy.next=newNode;
			dummy=newNode;
		}
		return dummyNode.next;
	}

	private static Node insertion(int[] arr1) {
		
		Node head=new Node(arr1[0]);
		Node temp=head;
		
		for(int i=1;i<arr1.length;i++)
		{
			Node newNode=new Node(arr1[i]);
			temp.next=newNode;
			temp=newNode;			
		}
		return head;
	}
}

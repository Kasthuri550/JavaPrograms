package linkedlist;

public class ReverseLinkedListGroupsOfGivenSize {

	public static void main(String[] args) {
		
		int k=4;
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(2);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head.next.next.next.next.next=new Node(6);
		head.next.next.next.next.next.next=new Node(7);
		head.next.next.next.next.next.next.next=new Node(8);
		
		printList(head);
		
		head=reverse(head, k);
		
		printList(head);

	}
	
	 private static void printList(Node head) {
		 
		 while(head!=null)
		 {
			 System.out.print(head.data+" ");
			 head=head.next;
		 }
		 
		 System.out.println();
	}

	public static Node reverse(Node node, int k)
	    {

	        int count=0;
	        Node cur=node;
	        Node prev=null;

	        while(cur!=null && count<k)
	        {
	            Node temp=cur.next;
	            cur.next=prev;
	            prev=cur;
	            cur=temp;
	            count++;
	        }
	        
	        if(cur!=null)
	            node.next=reverse(cur,k);
	        return prev;
	    }
}

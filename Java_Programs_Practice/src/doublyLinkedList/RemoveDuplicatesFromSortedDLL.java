package doublyLinkedList;

public class RemoveDuplicatesFromSortedDLL {

	public static void main(String[] args) {
		
		Node node1=new Node(1);
		Node node2=new Node(1);
		node1.next=node2;
		node2.previous=node1;
		Node node3=new Node(1);
		node2.next=node3;
		node3.previous=node2;
		Node node4=new Node(2);
		node3.next=node4;
		node4.previous=node3;
		Node node5=new Node(3);
		node4.next=node5;
		node5.previous=node4;
		Node node6=new Node(4);
		node5.next=node6;
		node6.previous=node5;
		
		print(node1);
		
		Node head=removeDuplicates(node1);
		
		print(head);
	}

	private static Node removeDuplicates(Node head) {
		
		Node temp=head;
		
		while(temp!=null && temp.next!=null)
		{
			Node nextNode=temp.next;
			
			while(temp!=null && temp.data==nextNode.data)
			{
				nextNode=nextNode.next;
			}
			
			temp.next=nextNode;
			if(nextNode!=null) nextNode.previous=temp;
			
			temp=temp.next;
		}
		
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
}

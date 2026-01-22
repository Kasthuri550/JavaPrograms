package linkedlist.hard;

public class ReverseNodesKGroup {

	public static void main(String[] args) {

		int k = 2;
		Node head = new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);

		Node reverseNodes=reverseNodesKGroup(head,k);
		print(reverseNodes);
	}

	private static void print(Node reverseNodes) {

		Node temp=reverseNodes;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */	
	private static Node reverseNodesKGroup(Node head, int k) {

		Node temp=head,prevNode=null;

		while(temp!=null)
		{
			Node kthNode=getKthNode(temp,k);

			if(kthNode==null)
			{
				if(prevNode!=null)
					prevNode.next=temp;

				break;
			}

			Node nextNode=kthNode.next;
			kthNode.next=null;
			reverseLinkedList(temp);
			if(temp==head)
			{
				head=kthNode;
			}
			else
			{
				prevNode.next=kthNode;
			}

			prevNode=temp;
			temp=nextNode;
		}

		return head;
	}

	private static void reverseLinkedList(Node head) {

		Node temp=head,prev=null;

		while(temp!=null)
		{
			Node front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
	}

	private static Node getKthNode(Node head, int k) {

		k--;
		while(head!=null && k>0)
		{
			k--;
			head=head.next;
		}

		return head;
	}
}

package linkedlist;

public class ReverseLinkedListGroups {

	public static void main(String[] args) {
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		int k=3;
		Node newHead=reverseLLGroups(head,k);
		printLL(newHead);

	}

	private static void printLL(Node head) {
		
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}

	private static Node reverseLLGroups(Node head, int k) {
		
		Node temp=head;
		Node prevLast=null;
		
		while(temp!=null)
		{
			Node kthNode=getKthNode(temp,k);
			if(kthNode==null)
			{
				if(prevLast!=null) prevLast.next=temp;
				break;
			}
			
			Node nextNode=kthNode.next;
			kthNode.next=null;
			reverse(temp);
			
			if(temp==head)
			{
				head=kthNode;
			}
			else
			{
				prevLast.next=kthNode;
			}
			prevLast=temp;
			temp=nextNode;
		}
				
		return head;
	}

	private static Node getKthNode(Node temp, int k) {
		
		k-=k;
		
		while(temp!=null && k>0)
		{
			k--;
			temp=temp.next;
		}
		return temp;
	}

	private static Node reverse(Node head) {
		
		Node temp=head,prev=null;
		
		while(temp!=null)
		{
			Node front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		
		return prev;
	}
}

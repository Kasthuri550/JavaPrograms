package linkedlist;

public class KthfromEndofLinkedList {

	public static void main(String[] args) {
		
		int k = 2, value[] = {1,2,3,4,5,6,7,8,9};
		
		Node head=convertArrToLL(value);
		printLL(head);
//		Node modifiedHead=NthNodeFromEndOfLinkedListBrute(head,k);
		Node modifiedHead=NthNodeFromEndOfLinkedListOptimal(head,k);
		printLL(modifiedHead);

	}

	private static Node NthNodeFromEndOfLinkedListOptimal(Node head, int k) {
		
		if(head==null) return head;
		
		Node fast=head,slow=head;
		
		for(int i=0;i<k;i++)
		{
			fast=fast.next;
		}
		
		if(fast==null)
			return head.next;
		
		while(fast.next!=null)
		{
			fast=fast.next;
			slow=slow.next;
		}
		
		Node deleteNode=slow.next;
		
		slow.next=slow.next.next;
		
		deleteNode=null;
		
		return head;
	}

	private static Node NthNodeFromEndOfLinkedListBrute(Node head,int k) {
		
		if(head==null) return head;
		
		int count=0;
		Node temp=head;
		
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		
		if(count==k)
		{
			Node newHead=head.next;
			return newHead;
		}
		
		int res=count-k;
		
		temp=head;
		while(temp!=null)
		{
			res--;
			if(res==0) break;
			
			temp=temp.next;
		}
		
		Node deleteNode=temp.next;
		
		temp.next=temp.next.next;
		
		deleteNode=null;
			
		return head;
	}

	private static void printLL(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		
		System.out.println();
	}

	private static Node convertArrToLL(int[] value) {
		
		Node head=new Node(value[0]);
		Node temp=head;
		
		for(int i=1;i<value.length;i++)
		{
			Node newNode=new Node(value[i]);
			temp.next=newNode;
			temp=newNode;			
		}
		
		return head;
	}
}

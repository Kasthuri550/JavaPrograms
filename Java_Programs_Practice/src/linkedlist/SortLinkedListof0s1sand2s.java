package linkedlist;

public class SortLinkedListof0s1sand2s {

	public static void main(String[] args) {
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(2);
		head.next.next.next=new Node(1);
		head.next.next.next.next=new Node(2);
		head.next.next.next.next.next=new Node(0);
		head.next.next.next.next.next.next=new Node(2);
		head.next.next.next.next.next.next.next=new Node(2);
		
//		Node newHead=sortLLBrute(head);
		
		Node newHead=sortLLOptimal(head);
		
		printLL(newHead);
	}

	private static Node sortLLOptimal(Node head) {
		
		if(head==null || head.next==null) return head;
		
		Node zeroHead=new Node(-1);
		Node oneHead=new Node(-1);
		Node twoHead=new Node(-1);
		
		Node zero=zeroHead;
		Node one=oneHead;
		Node two=twoHead;
		Node temp=head;
		
		while(temp!=null)
		{
			if(temp.data==0)
			{
				zero.next=temp;
				zero=zero.next;
			}
			else if(temp.data==1)
			{
				one.next=temp;
				one=one.next;
			}
			else
			{
				two.next=temp;
				two=two.next;
			}
			temp=temp.next;
		}
		
		zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
		one.next=twoHead.next;
		two.next=null;
		Node newHead=zeroHead.next;
		zeroHead=null;
		oneHead=null;
		twoHead=null;
		
		return newHead;
	}

	private static void printLL(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	private static Node sortLLBrute(Node head) {
		
		if(head==null || head.next==null) return head;
		
		Node temp=head;
		int count0=0,count1=0,count2=0;
		
		while(temp!=null)
		{
			if(temp.data==0) count0++;
			else if(temp.data==1) count1++;
			else count2++;
			
			temp=temp.next;
		}
		
		temp=head;
		
		while(temp!=null)
		{
			if(count0!=0)
			{
				temp.data=0;
				count0--;
			}
			else if(count1!=0)
			{
				temp.data=1;
				count1--;
			}
			else if(count2!=0)
			{
				temp.data=2;
				count2--;
			}
			temp=temp.next;
		}
		
		return head;
	}
}

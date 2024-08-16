package linkedlist;

public class AddOneToLinkedListBrute {

	public static void main(String[] args) {
		
		Node head=new Node(9);
		head.next=new Node(9);
		head.next.next=new Node(9);
		
		printList(head);
		int num=linkedListToNumber(head);
		
		Node newHead=addOne(num+1);
		
		printList(newHead);
			
	}

	private static void printList(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data);
			head=head.next;
		}
		System.out.println();
	}

	private static Node addOne(int num) {
		
		Node head=null;
		
		while(num>0)
		{
			int digit=num%10;
			Node newNode=new Node(digit);
			
			if(head==null)
			{
				head=newNode;
			}
			else
			{
				newNode.next=head;
				head=newNode;
			}
			
			num/=10;
		}
		
		return head;
	}

	private static int linkedListToNumber(Node head) {
		
		int num=0;
		
		while(head!=null)
		{
			num=num*10+head.data;
			head=head.next;
		}
		return num;
	}
}

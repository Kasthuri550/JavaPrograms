package linkedlist.medium;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class PartitionList {

	public static void main(String[] args) {

		int x = 3;

		Node head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(2);

		Node partitionedList=partitionList(head,x);
		print(partitionedList);		
	}

	private static void print(Node removedDuplicates) {

		Node temp=removedDuplicates;

		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node partitionList(Node head, int x) {

		Node beforeDummy=new Node(-1);
		Node afterDummy=new Node(-1);

		Node before=beforeDummy;
		Node after=afterDummy;

		Node temp=head;

		while(temp!=null)
		{
			if(temp.data<x)
			{
				before.next=temp;
				before=before.next;
			}
			else
			{
				after.next=temp;
				after=after.next;
			}
			temp=temp.next;
		}

		after.next=null;

		before.next=afterDummy.next;

		return beforeDummy.next;
	}
}

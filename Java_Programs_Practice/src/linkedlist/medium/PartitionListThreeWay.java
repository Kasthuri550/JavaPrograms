package linkedlist.medium;

/*
 * Time Complexity: O(n)
 * Space Complexity(auxiliary): O(1)
 * */
public class PartitionListThreeWay {

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(3);

		int x = 3;

		Node result = partitionThreeWay(head, x);
		print(result);
	}

	private static Node partitionThreeWay(Node head, int x) {

		Node lessDummy=new Node(-1);
		Node equalDummy=new Node(-1);
		Node greaterDummy=new Node(-1);

		Node lesser=lessDummy;
		Node equal=equalDummy;
		Node greater=greaterDummy;

		Node temp=head;

		while(temp!=null)
		{
			if(temp.data<x)
			{
				lesser.next=temp;
				lesser=lesser.next;
			}
			else if(temp.data==x)
			{
				equal.next=temp;
				equal=equal.next;
			}
			else
			{
				greater.next=temp;
				greater=greater.next;
			}

			temp=temp.next;
		}

		greater.next=null;

		equal.next=greaterDummy.next;
		lesser.next=equalDummy.next;

		return lessDummy.next;
	}

	private static void print(Node removedDuplicates) {

		Node temp=removedDuplicates;

		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}
}

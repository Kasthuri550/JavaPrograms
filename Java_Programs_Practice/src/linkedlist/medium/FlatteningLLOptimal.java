package linkedlist.medium;

/*
 * Time Complexity: O(n*(2m))
 * Space Complexity: O(1)
 * */
public class FlatteningLLOptimal {

	private static class Node {
		int val;
		Node next;
		Node child;

		Node(int val) {
			this.val = val;
		}
	}

	private static Node createInput()
	{
		Node head = new Node(5);
		head.child = new Node(7);
		head.child.child = new Node(8);
		head.child.child.child = new Node(30);

		head.next = new Node(10);
		head.next.child = new Node(20);

		head.next.next = new Node(19);
		head.next.next.child = new Node(22);
		head.next.next.child.child = new Node(50);

		head.next.next.next = new Node(28);
		head.next.next.next.child = new Node(35);
		head.next.next.next.child.child = new Node(40);
		head.next.next.next.child.child.child = new Node(45);

		return head;
	}

	private static void print(Node head) {

		Node temp=head;

		while(temp!=null)
		{
			System.out.println(temp.val+" ");
			temp=temp.child;
		}
	}

	public static void main(String[] args) {

		Node head=createInput();

		Node flattenedList=flatteningListOptimal(head);
		print(flattenedList);
	}

	private static Node flatteningListOptimal(Node head) {

		if(head==null || head.next==null)
			return head;

		Node mergedNode=flatteningListOptimal(head.next);
		return merge(head,mergedNode);
	}

	private static Node merge(Node list1, Node list2) {

		Node dummyNode=new Node(-1);
		Node temp=dummyNode;

		while(list1!=null && list2!=null)
		{
			if(list1.val<list2.val)
			{
				temp.child=list1;
				temp=list1;
				list1=list1.child;
			}
			else
			{
				temp.child=list2;
				temp=list2;
				list2=list2.child;
			}

			temp.next=null;
		}

		if(list1!=null)
		{
			temp.child=list1;
		}

		if(list2!=null)
		{
			temp.child=list2;
		}

		if(dummyNode.child!=null)
			dummyNode.child.next=null;

		return dummyNode.child;
	}
}

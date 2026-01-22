package linkedlist.medium;

/*
 * Time Complexity: O(m+n)
 * Space Complexity: O(1)
 * */
public class MergeTwoSortedLists {

	public static void main(String[] args) {

		Node list1=new Node(1);
		list1.next=new Node(2);
		list1.next.next=new Node(4);

		Node list2=new Node(1);
		list2.next=new Node(3);
		list2.next.next=new Node(4);

		Node merge=merge2SortedLists(list1,list2);
		print(merge);
	}

	private static void print(Node merge) {

		Node temp=merge;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node merge2SortedLists(Node list1, Node list2) {

		Node temp1=list1,temp2=list2;
		Node dummyNode=new Node(-1);
		Node current=dummyNode;

		while(temp1!=null && temp2!=null)
		{
			if(temp1.data<temp2.data)
			{
				current.next=temp1;
				current=temp1;
				temp1=temp1.next;
			}
			else
			{
				current.next=temp2;
				current=temp2;
				temp2=temp2.next;
			}
		}

		while(temp1!=null)
		{
			current.next=temp1;
			current=temp1;
			temp1=temp1.next;
		}

		while(temp2!=null)
		{
			current.next=temp2;
			current=temp2;
			temp2=temp2.next;
		}

		return dummyNode.next;
	}
}

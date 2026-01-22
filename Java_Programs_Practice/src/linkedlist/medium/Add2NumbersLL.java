package linkedlist.medium;

/*
 * Time Complexity: O(max(m,n))
 * Space Complexity: O(max(m,n))
 * */
public class Add2NumbersLL {

	public static void main(String[] args) {

		Node temp1=new Node(2);
		temp1.next=new Node(4);
		temp1.next.next=new Node(3);

		Node temp2=new Node(5);
		temp2.next=new Node(6);
		temp2.next.next=new Node(8);
		temp2.next.next=new Node(1);

		Node add2=add2Numbers(temp1,temp2);

		print(add2);

		//		System.out.println(add2.toString());
	}

	private static void print(Node add2) {

		Node temp=add2;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node add2Numbers(Node node1, Node node2) {

		Node temp1=node1,temp2=node2;

		Node dummyNode=new Node(-1);
		Node currentNode=dummyNode;

		int carry=0;

		while(temp1!=null || temp2!=null || carry>0)
		{
			int sum=0;

			if(temp1!=null)
			{
				sum+=temp1.data;
				temp1=temp1.next;
			}

			if(temp2!=null)
			{
				sum+=temp2.data;
				temp2=temp2.next;
			}

			sum+=carry;
			Node newNode=new Node(sum%10);
			currentNode.next=newNode;
			currentNode=newNode;
			carry=sum/10;
		}

		return dummyNode.next;
	}
}

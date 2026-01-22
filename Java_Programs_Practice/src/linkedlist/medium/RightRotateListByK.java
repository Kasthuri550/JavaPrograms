package linkedlist.medium;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
public class RightRotateListByK {

	public static void main(String[] args) {

		int k=2;
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);

		Node rightRotated=rightRotateList(head,k);
		print(rightRotated);
	}

	private static void print(Node removedDuplicates) {

		Node temp=removedDuplicates;

		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
	}

	private static Node rightRotateList(Node head, int k) {

		if(head==null || k==0)
			return head;

		Node temp=head;
		int len=1;

		while(temp.next!=null)
		{
			len++;
			temp=temp.next;
		}


		if(k%len==0)
			return head;

		k=k%len;
		temp.next=head;
		Node newNode=findKthNode(head,len-k);
		head=newNode.next;
		newNode.next=null;

		return head;
	}

	private static Node findKthNode(Node head, int k) {

		Node temp=head;
		int count=1;

		while(temp!=null)
		{
			if(count==k)
				return temp;

			count++;
			temp=temp.next;
		}
		return temp;
	}
}

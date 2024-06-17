package linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

	public static void main(String[] args) {
		
		Node[] value = new Node[4];
//		{{1,2,3},{4 5},{5 6},{7,8}};
		value[0]=new Node(1);
		value[0].next=new Node(2);
		value[0].next.next=new Node(3);
		value[1]=new Node(4);
		value[1].next=new Node(5);
		value[2]=new Node(5);
		value[2].next=new Node(6);
		value[3]=new Node(7);
		value[3].next=new Node(8);
		
		int k=4;
		Node head=mergeLinkedList(value,k);
		printList(head);

	}

	private static Node mergeLinkedList(Node[] value,int k) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		
		for(int i=0;i<k;i++)
		{
			while(value[i]!=null)
			{
				pq.add(value[i].data);
				value[i]=value[i].next;
			}
		}
		
		Node head=new Node(0);
		Node tail=head;
		while(pq.size()>0)
		{
			Node minNode=new Node(pq.poll());
			tail.next=minNode;
			tail=tail.next;			
		}
		
		tail.next=null;
		
		return head.next;
		
	}

	private static void printList(Node node) {
		
		while(node!=null)
		{
			System.out.print(node.data+" ");
			node=node.next;
		}
		
	}
}

package linkedlist;

import java.util.HashSet;

public class IntersectionPointOfYLL {

	public static void main(String[] args) {

		Node common=new Node(6);
		common.next=new Node(7);

		Node headA=new Node(1);
		headA.next=new Node(2);
		headA.next.next=new Node(3);

		Node headB=new Node(4);
		headB.next=new Node(5);

		headA.next.next.next=common;

		headB.next.next=common;

		Node intersect1=intersectionPointOfYLLBrute(headA,headB);
		System.out.println(intersect1.toString());

		Node intersect2=intersectionPointOfYLLBetter(headA,headB);
		System.out.println(intersect2);

		Node intersect3=intersectionPointOfYLLOptimal(headA,headB);
		System.out.println(intersect3);
	}

	/*
	 * Time Complexity: O(n+m)
	 * Space Complexity: O(1)
	 * */
	private static Node intersectionPointOfYLLOptimal(Node headA, Node headB) {

		Node p1=headA,p2=headB;

		while(p1!=p2)
		{
			p1=(p1==null)?headB:p1.next;
			p2=(p2==null)?headA:p2.next;
		}

		return p1;
	}

	/*
	 * Time Complexity: O(n+m)
	 * Space Complexity: O(n)
	 * */
	private static Node intersectionPointOfYLLBetter(Node headA, Node headB) {

		HashSet<Node> hashSet=new HashSet<>();

		Node temp1=headA;
		Node temp2=headB;

		while(temp1!=null)
		{
			hashSet.add(temp1);
			temp1=temp1.next;
		}

		while(temp2!=null)
		{
			if(hashSet.contains(temp2))
				return temp2;

			temp2=temp2.next;
		}

		return null;
	}

	/*
	 * Time Complexity: O(n*m)
	 * Space Complexity: O(1)
	 * */
	private static Node intersectionPointOfYLLBrute(Node headA, Node headB) {

		for(Node h1=headA;h1!=null;h1=h1.next)
		{
			for(Node h2=headB;h2!=null;h2=h2.next)
			{
				if(h1==h2)
				{
					return h1;
				}
			}
		}

		return null;
	}
}

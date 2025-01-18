package linkedlist.hard;

import java.util.HashSet;

public class FindIntersectionPointOfYLL {

	public static void main(String[] args) {

		Node headA = new Node(1);
		headA.next = new Node(2);
		headA.next.next = new Node(3);
		headA.next.next.next = new Node(4);
		headA.next.next.next.next = new Node(5);
		headA.next.next.next.next.next = new Node(6);

		Node headB = new Node(9);
		headB.next = new Node(8);
		headB.next.next = headA.next.next.next;

		System.out.println(findIntersectionPointBrute(headA,headB).data);
		System.out.println(findIntersectionPointHashing(headA, headB).data);
		System.out.println(findIntersectionPointBetter(headA, headB).data);
		System.out.println(findIntersectionPointOptimal(headA, headB).data);

	}
	/*
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(1)
	 */
	private static Node findIntersectionPointOptimal(Node headA, Node headB) {

		if(headA==null || headB==null) return null;

		Node temp1=headA;
		Node temp2=headB;

		while(temp1!=temp2)
		{
			temp1=temp1.next;
			temp2=temp2.next;

			if(temp1==temp2) return temp1;

			if(temp1==null)
				temp1=headB;

			if(temp2==null)
				temp2=headA;				
		}

		return temp1;
	}
	/*
	 * Time Complexity: O(2max(m,n))+O(abs(m-n))+O(min(m,n))
	 * Space Complexity: O(1)
	 */
	private static Node findIntersectionPointBetter(Node headA, Node headB) {

		int diff=getDifference(headA,headB);

		if(diff<0)
		{
			while(diff++!=0)
				headB=headB.next;			
		}
		else
		{
			while(diff--!=0)
				headA=headA.next;
		}

		while(headA!=null)
		{
			if(headA==headB)
				return headA;

			headA=headA.next;
			headB=headB.next;
		}

		return null;
	}

	private static int getDifference(Node headA, Node headB) {

		int len1=0,len2=0;
		while(headA!=null||headB!=null)
		{
			if(headA!=null)
			{
				len1++;
				headA=headA.next;
			}

			if(headB!=null)
			{
				len2++;
				headB=headB.next;
			}
		}

		return len1-len2;
	}
	/*
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(m)
	 */
	private static Node findIntersectionPointHashing(Node headA, Node headB) {

		HashSet<Node> set=new HashSet<>();

		while(headA!=null)
		{
			set.add(headA);
			headA=headA.next;
		}

		while(headB!=null)
		{
			if(set.contains(headB))
				return headB;

			headB=headB.next;
		}

		return null;
	}
	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(1)
	 */
	private static Node findIntersectionPointBrute(Node headA, Node headB) {

		while(headA!=null)
		{
			Node tempB=headB;

			while(tempB!=null)
			{
				if(headA==tempB)
					return headA;

				tempB=tempB.next;
			}

			headA=headA.next;
		}

		return null;
	}
}

package linkedlist.medium;

import java.util.HashMap;

public class DetectLoopLL {

	public static void main(String[] args) {

		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// Create a loop
		fifth.next = third;

		System.out.println(detectLoopBrute(head));
		System.out.println(detectLoopOptimal(head));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */	
	private static boolean detectLoopOptimal(Node head) {

		Node slow=head,fast=head;

		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;

			if(slow==fast)
				return true;
		}

		return false;
	}

	/*
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(n)
	 * */	
	private static boolean detectLoopBrute(Node head) {

		HashMap<Node,Integer> hashMap=new HashMap<>();

		Node temp=head;

		while(temp!=null)
		{
			if(hashMap.containsKey(temp))
				return true;

			hashMap.put(temp,1);
			temp=temp.next;
		}

		return false;
	}
}

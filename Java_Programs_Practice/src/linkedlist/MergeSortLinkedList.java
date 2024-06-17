package linkedlist;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		
		Node node=new Node(3);
		node.next=new Node(5);
		node.next.next=new Node(2);
		node.next.next.next=new Node(4);
		node.next.next.next.next=new Node(1);
		
		Node mergedNode=mergeSort(node);
		printList(mergedNode);

	}
	
	private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

	private static Node mergeSort(Node node) {
		
		if(node==null || node.next==null)
			return node;
		
		Node middle=findMiddle(node);
		Node left=node;
		Node right=middle.next;
		middle.next=null;
		
		Node leftSorted=mergeSort(left);
		Node rightSorted=mergeSort(right);
		return merge(leftSorted,rightSorted);	
	}

	private static Node merge(Node left, Node right) {
		
		Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return dummyNode.next;
	}

	private static Node findMiddle(Node node) {
		
		Node slow=node,fast=node.next;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
}

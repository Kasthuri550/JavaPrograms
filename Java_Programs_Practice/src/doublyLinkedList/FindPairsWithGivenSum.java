package doublyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairsWithGivenSum {

	public static void main(String[] args) {
		
		int arr[]= {1,2,4,5,6,8,9},target=7;
		
		Node head=convertArr2DLL(arr);
		
		print(head);
		
		List<List<Integer>> pairList=new ArrayList<>();
//		findPairsBrute(head,target,pairList);
		findPairsOptimal(head,target,pairList);
		
		System.out.println(pairList);
		
	}

	private static void findPairsOptimal(Node head, int target, List<List<Integer>> pairList) {
		
		Node left=head,right=findTail(head);
		
		while(left.data<right.data)
		{
			if(left.data+right.data==target)
			{
				pairList.add(Arrays.asList(left.data,right.data));
				left=left.next;
				right=right.previous;
			}
			else if(left.data+right.data<target)
			{
				left=left.next;
			}
			else
			{
				right=right.previous;
			}
		}
		
	}

	private static Node findTail(Node head) {
		
		Node tail=head;
		
		while(tail.next!=null)
		{
			tail=tail.next;
		}
		
		return tail;
	}

	private static void findPairsBrute(Node head, int target,List<List<Integer>> pairList) {
		
		Node temp1=head;
		
		while(temp1!=null)
		{
			Node temp2=temp1.next;
			
			while(temp2!=null && temp1.data+temp2.data<=target)
			{
				if(temp1.data+temp2.data==target)
				{
					pairList.add(Arrays.asList(temp1.data,temp2.data));
				}
				temp2=temp2.next;
			}
			
			temp1=temp1.next;
		}
		
	}

	private static void print(Node head) {
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	private static Node convertArr2DLL(int[] arr) {
		
		Node head=new Node(arr[0]);
		Node temp=head;
		
		for(int i=1;i<arr.length;i++)
		{
			Node newNode=new Node(arr[i]);
			temp.next=newNode;
			newNode.previous=temp;
			temp=newNode;
		}
		return head;
	}
}

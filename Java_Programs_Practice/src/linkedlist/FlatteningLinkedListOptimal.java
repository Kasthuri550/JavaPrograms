package linkedlist;

public class FlatteningLinkedListOptimal {

	public static void main(String[] args) {
		
		ListNode head=new ListNode(5);
		head.bottom=new ListNode(7);
		head.bottom.bottom=new ListNode(8);
		head.bottom.bottom.bottom=new ListNode(30);
		head.next=new ListNode(10);
		head.next.bottom=new ListNode(20);
		head.next.next=new ListNode(19);
		head.next.next.bottom=new ListNode(22);
		head.next.next.bottom.bottom=new ListNode(50);
		head.next.next.next=new ListNode(28);	
		head.next.next.next.bottom=new ListNode(35);	
		head.next.next.next.bottom.bottom=new ListNode(40);
		head.next.next.next.bottom.bottom.bottom=new ListNode(45);
		
		ListNode flattenHead=flattenLL(head);
		
		printLL(flattenHead);

	}

	private static void printLL(ListNode flattenHead) {
		
		while(flattenHead!=null)
		{
			System.out.print(flattenHead.data+" ");
			flattenHead=flattenHead.bottom;
		}
		System.out.println();
	}

	private static ListNode flattenLL(ListNode head)
	{
		if(head==null || head.next==null) return head;
		
		ListNode mergeHead=flattenLL(head.next);
		
		head=mergeTwoLists(head,mergeHead);
		
		return head;
		
	}

	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		if(list1==null) return list2;
		if(list2==null) return list1;
		
		ListNode dummyNode=new ListNode(-1);
		ListNode current=dummyNode;
		
		while(list1!=null && list2!=null)
		{
			if(list1.data < list2.data)
			{
				current.bottom=list1;
				list1=list1.bottom;
			}
			else
			{
				current.bottom=list2;
				list2=list2.bottom;
			}
			
			current=current.bottom;
		}
		
		if(list1!=null)
		{
			current.bottom=list1;
		}
		else
		{
			current.bottom=list2;
		}
		return dummyNode.bottom;
	}
}

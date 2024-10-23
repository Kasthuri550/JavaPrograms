package Tree.medium;

import java.util.ArrayList;

public class MorrisPreorderTraversalOfABinaryTree {

	public static void main(String[] args) {

		Node root=new Node(10);
		root.left=new Node(20);
		root.left.left=new Node(40);
		root.left.right=new Node(60);
		root.right=new Node(30);
		root.right.left=new Node(50);

		System.out.println(morrisPreorder(root));

	}

	private static ArrayList<Integer> morrisPreorder(Node root) {

		ArrayList<Integer> preorder=new ArrayList<>();

		Node curr=root;

		while(curr!=null)
		{
			if(curr.left==null)
			{
				preorder.add(curr.data);
				curr=curr.right;
			}
			else
			{
				Node prev=curr.left;

				while(prev.right!=null && prev.right!=curr)
				{
					prev=prev.right;
				}

				if(prev.right==null)
				{
					prev.right=curr;
					preorder.add(curr.data);
					curr=curr.left;
				}
				else
				{
					prev.right=null;
					curr=curr.right;
				}
			}
		}

		return preorder;
	}

}

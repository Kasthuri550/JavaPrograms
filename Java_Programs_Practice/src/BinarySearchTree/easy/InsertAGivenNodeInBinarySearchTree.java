package BinarySearchTree.easy;

public class InsertAGivenNodeInBinarySearchTree {
	
	static class Node
	{
		int data;
		Node left,right;
		
		Node()
		{
			
		}
		
		Node(int val)
		{
			this.data=val;
		}

		@Override
		public String toString() {
			return "Node [val=" + data + ", left=" + left + ", right=" + right + "]";
		}
	}

	public static void main(String[] args) {
		
		Node root=new Node(2);
		root.left=new Node(1);
		root.right=new Node(3);
		
		int k=4;
		
		System.out.println(insertNode(root,k));

	}

	private static Node insertNode(Node root, int Key) {

		if(root==null)
			return new Node(Key);
		
		Node curr=root;
		
		while(true)
		{
			if(curr.data<Key)
			{
				if(curr.right!=null)
					curr=curr.right;
				else
				{
					curr.right=new Node(Key);
					break;
				}
			}
			else if(curr.data>Key)
			{
				if(curr.left!=null)
					curr=curr.left;
				else
				{
					curr.left=new Node(Key);
					break;
				}
			}
			else
			{
				break;
			}
		}
		
		return root;
	}
}

package Tree;

class Node
{
	int data;
	Node left,right;
	
	Node(int data)
	{
		this.data=data;
		left=right=null;
	}
}

public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		
		int n1=3,n2=4;
		
		Node root=new Node(5);
		root.left=new Node(2);
		root.left.left=new Node(3);
		root.left.right=new Node(4);
		
		System.out.println(lowestCommonAncestor(root,n1,n2).data);
	}

	private static Node lowestCommonAncestor(Node root, int n1, int n2) {
		
		if(root==null) return null;
		
		if(root.data==n1 || root.data==n2)
			return root;
		
		Node left_lca=lowestCommonAncestor(root.left, n1, n2);
		Node right_lca=lowestCommonAncestor(root.right, n1, n2);
		
		if(left_lca!=null && right_lca!=null) return root;
		
		return left_lca!=null?left_lca:right_lca;		
		
	}
}

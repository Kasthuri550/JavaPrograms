package Tree.easy;

import java.util.ArrayList;
import java.util.Stack;

class TreeNodes
{
	int val;
	TreeNodes left,right;
	public TreeNodes() {
		super();
	}
	public TreeNodes(int val) {
		super();
		this.val = val;
	}
	public TreeNodes(int val, TreeNodes left, TreeNodes right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}	
}
public class IterativePostorderTraversalUsing2Stack {

	public static void main(String[] args) {
		
		TreeNodes treeNodes=new TreeNodes(1);
		treeNodes.left=new TreeNodes(2);
		treeNodes.left.left=new TreeNodes(4);
		treeNodes.left.right=new TreeNodes(5);
		treeNodes.right=new TreeNodes(3);

		System.out.println(postOrderTraversal2Stack(treeNodes));
	}

	private static ArrayList<Integer> postOrderTraversal2Stack(TreeNodes root) {

		ArrayList<Integer> postOrder=new ArrayList<>();
		
		if(root==null) return postOrder;
		
		Stack<TreeNodes> stack1=new Stack<>();
		Stack<TreeNodes> stack2=new Stack<>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty())
		{
			root=stack1.pop();
			stack2.push(root);
			if(root.left!=null) stack1.push(root.left);
			if(root.right!=null) stack1.push(root.right);
		}
		
		while(!stack2.isEmpty())
		{
			postOrder.add(stack2.pop().val);
		}
		
		return postOrder;
	}

}

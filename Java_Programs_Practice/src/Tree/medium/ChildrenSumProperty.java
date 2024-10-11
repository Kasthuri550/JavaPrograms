package Tree.medium;

public class ChildrenSumProperty {

	public static void main(String[] args) {

		Node root=new Node(35);
		root.left=new Node(20);
		root.right=new Node(15);
		root.left.left=new Node(15);
		root.left.right=new Node(5);
		root.right.left=new Node(10);
		root.right.right=new Node(5);
		
		changeTreeApproach1(root);
		System.out.println(changeTreeApproach2(root));
		
		
		System.out.println(root.toString());
	}

	private static int changeTreeApproach2(Node root) {
		
		if(root==null || (root.left==null && root.right==null))
		{
			return 1;
		}
		int leftData=(root.left!=null)?root.left.data:0;
		int rightData=(root.right!=null)?root.right.data:0;
		
		if(root.data==leftData+rightData)
		{
			if(changeTreeApproach2(root.left)==1 && changeTreeApproach2(root.right)==1)
			{
				return 1;
			}
		}
		
		return 0;
	}

	private static void changeTreeApproach1(Node root) {
		
		if(root==null)
			return ;
		
		int child=0;
		
		if(root.left!=null)
			child+=root.left.data;
		
		if(root.right!=null)
			child+=root.right.data;
		
		if(child>=root.data)
		{
			root.data=child;
		}
		else
		{
			if(root.left!=null)
				root.left.data=root.data;
			else if(root.right!=null)
				root.right.data=root.data;
		}
		
		changeTreeApproach1(root.left);
		changeTreeApproach1(root.right);
		
		int tot=0;
		if(root.left!=null)
			tot+=root.left.data;
		
		if(root.right!=null)
			tot+=root.right.data;
		
		if(root.left!=null || root.right!=null) root.data=tot;	
		
	}
}

package Tree.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreorder {

	public static void main(String[] args) {

		int n = 4,inorder[] = {1,6,8,7},preorder[] = {1,6,7,8};
		
		System.out.println(constructTreeFromInorderAndPreorder(inorder,preorder,n));
	}

	private static Node constructTreeFromInorderAndPreorder(int[] inorder, int[] preorder, int n) {
		
		Map<Integer,Integer> inMap=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			inMap.put(inorder[i],i);
		}
		
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
		
	}

	private static Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {

		if(preStart>preEnd || inStart>inEnd) return null;
		
		Node root=new Node(preorder[preStart]);
		int inRoot=inMap.get(root.data);
		int numsLeft=inRoot-inStart;
		
		root.left=buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
		root.right=buildTree(preorder, preStart+numsLeft+1, preEnd, inorder,inRoot+1,inEnd,inMap);
		
		return root;
	}
}

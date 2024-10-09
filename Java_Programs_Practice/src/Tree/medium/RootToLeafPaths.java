package Tree.medium;

import java.util.ArrayList;

public class RootToLeafPaths {

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		
		System.out.println(rootToLeafPaths(root));
	}

	private static ArrayList<ArrayList<Integer>> rootToLeafPaths(Node root) {
		
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		
		ArrayList<Integer> currentPath=new ArrayList<Integer>();
		
		findPaths(root,currentPath,result);
		
		return result;
		
	}

	private static void findPaths(Node root, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> result) {

		if(root==null)
		{
			return;
		}
		
		currentPath.add(root.data);
		
		if(root.left==null && root.right==null)
		{
			result.add(new ArrayList<Integer>(currentPath));
		}
		else
		{
			findPaths(root.left, currentPath, result);
			findPaths(root.right, currentPath, result);
		}
		
		currentPath.remove(currentPath.size()-1);
		
	}
}

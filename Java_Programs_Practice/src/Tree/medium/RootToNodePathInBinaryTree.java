package Tree.medium;

import java.util.ArrayList;

public class RootToNodePathInBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        int B=5;
        
        
        System.out.println(rootToNodePath(root,B));
     
	}

	private static ArrayList<Integer> rootToNodePath(Node root, int B) {
		
		ArrayList<Integer> path=new ArrayList<>();
		
		
		if(findPath(root,B,path))
		{
			return path;
		}
		
		return new ArrayList<>();
		
	}

	private static boolean findPath(Node root, int B, ArrayList<Integer> path) {

		if(root==null)
		{
			return false;
		}
		
		path.add(root.data);
		
		if(root.data==B)
		{
			return true;
		}
		
		if(findPath(root.left, B, path)|| findPath(root.right, B, path))
		{
			return true;
		}
		
		path.remove(path.size()-1);
		
		return false;
	}
}

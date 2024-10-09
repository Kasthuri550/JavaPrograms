package Tree.medium;

public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node() {
		super();
	}
	
	public Node(int data) {
		super();
		this.data = data;
	}

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

package linkedlist.medium;

public class Node {
	// Data stored in the node
	int data;

	// Pointer to the next node in the list
	Node next;

	// Constructor with both data 
	// and next node as parameters
	Node(int data1, Node next1) {
		data = data1;
		next = next1;
	}

	// Constructor with only data as
	// a parameter, sets next to null
	Node(int data1) {
		data = data1;
		next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}

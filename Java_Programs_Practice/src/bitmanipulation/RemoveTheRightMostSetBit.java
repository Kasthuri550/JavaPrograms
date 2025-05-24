package bitmanipulation;

public class RemoveTheRightMostSetBit {

	public static void main(String[] args) {

		int n=40;
		
		System.out.println(removeTheRightMostSetBit(n));
		
	}

	private static int removeTheRightMostSetBit(int n) {

		return n & (n-1);
	}
}

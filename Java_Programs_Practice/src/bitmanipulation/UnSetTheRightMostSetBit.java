package bitmanipulation;

public class UnSetTheRightMostSetBit {

	public static void main(String[] args) {

		int n=12;

		System.out.println(unSetTheRightMostSetBit(n));
	}

	private static int unSetTheRightMostSetBit(int n) {

		return n & (n-1);
	}
}

package bitmanipulation;

public class CheckIfTheIThBitIsSetOrNot {

	public static void main(String[] args) {

		int n = 4, k = 2;
		
		System.out.println(leftShift(n,k));
		System.out.println(rightShift(n,k));
	}

	private static boolean rightShift(int n, int k) {

		return ((n>>k)&1)==1;
	}

	private static boolean leftShift(int n, int k) {

		return (n&(1<<k))!=0;
	}
}

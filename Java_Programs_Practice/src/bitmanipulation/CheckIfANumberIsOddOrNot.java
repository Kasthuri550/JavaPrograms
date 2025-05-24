package bitmanipulation;

public class CheckIfANumberIsOddOrNot {

	public static void main(String[] args) {

		int n=13;

		System.out.println(checkIfANumberIsOddOrNot(n));
	}

	private static boolean checkIfANumberIsOddOrNot(int n) {

		return (n & 1)==1;
	}
}

package bitmanipulation;

public class CheckIfTheNumberIsAPowerOf2 {

	public static void main(String[] args) {
		
		int n=16;
		
		System.out.println(checkIfTheNumberIsAPowerOf2(n));
		
	}

	private static boolean checkIfTheNumberIsAPowerOf2(int n) {

		return (n & (n-1)) == 0;
	}
}

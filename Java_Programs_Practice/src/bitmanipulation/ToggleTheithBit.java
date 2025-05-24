package bitmanipulation;

public class ToggleTheithBit {

	public static void main(String[] args) {

		int n=13,i=2;

		System.out.println(toggleTheithBit(n,i));
	}

	private static int toggleTheithBit(int n, int i) {

		return n^(1<<i);
	}
}

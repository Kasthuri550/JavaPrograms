package bitmanipulation;

public class ClearTheithBit {

	public static void main(String[] args) {

		int n=13,i=2;

		System.out.println(clearTheithBit(n,i));
	}

	private static int clearTheithBit(int n, int i) {

		return n& ~(1<<i);
	}
}

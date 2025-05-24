package bitmanipulation;

public class SetTheRightMostUnsetBit {

	public static void main(String[] args) {

		int n=15;
		
		System.out.println(setTheRightMostUnsetBit(n));
	}

	private static int setTheRightMostUnsetBit(int n) {

		return n | (n+1);
	}

}

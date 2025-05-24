package bitmanipulation;

public class SetTheithBit {

	public static void main(String[] args) {
		
		int n=9,i=2;
		
		System.out.println(setTheithBit(n,i));
	}

	private static int setTheithBit(int n,int i) {

		return (n | (1<<i));
	}
}

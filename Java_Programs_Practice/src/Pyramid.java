
public class Pyramid {

	public static void main(String[] args) {

//		pattern1(9);
//		pattern2(9);
//		pattern3(9);
//		pattern4(9);
//		pattern5(9);
//		pattern6(9);
//		pattern7(9);
		pattern8(9);
	}

	private static void pattern8(int n) {
		
		for(int row=1;row<=n;row++)
		{
			int alphabet=97;
			for(int s=1;s<=n-row;s++)
			{
				System.out.print(" ");
			}
			for(char col=1;col<=row;col++)
			{
				System.out.print((char)(alphabet+row-1)+" ");
			}
			System.out.println();
		}
		
	}

	private static void pattern7(int n) {
		
		for(int row=n;row>=1;row--)
		{
			for(int s=row;s<=n;s++)
			{
				System.out.print(" ");
			}
			for(int col=row;col>=1;col--)
			{
				System.out.print(row+" ");
			}
			System.out.println();
		}
		
	}

	private static void pattern6(int n) {
		
		for(int row=1;row<=n;row++)
		{
			for(int s=row;s>=1;s--)
			{
				System.out.print(" ");
			}
			for(int col=n;col>=row;col--)
			{
				System.out.print("*"+" ");
			}
			System.out.println();
		}
		
	}

	private static void pattern5(int n) {
		
		for(int row=n;row>=1;row--)
		{
			for(int s=1;s<=row-1;s++)
			{
				System.out.print("  ");
			}
			for(int col=row;col<=n-1;col++)
			{
				System.out.print(col+" ");
			}
			for(int col=n;col>=row;col--)
			{
				System.out.print(col+" ");
			}
			System.out.println();
		}
		
	}

	private static void pattern4(int n) {

		for (int row = 1; row <= n; row++) {

			for (int s = 1; s <= n - row; s++) {
				System.out.print("  ");
			}

			for (int col = 1; col <= row; col++) {
				System.out.print(col+" ");
			}
			for (int col = row-1; col >= 1; col--) {
				System.out.print(col+" ");
			}

			System.out.println();
		}
	}

	private static void pattern3(int n) {

		for (int row = 1; row <= n; row++) {
			for (int s = 1; s <= n - row; s++) {
				System.out.print(" ");
			}
			for (int col = 1; col <= row; col++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}

	}

	private static void pattern2(int n) {

		for (int row = 1; row <= n; row++) {
			for (int s = 1; s <= n - row; s++) {
				System.out.print(" ");
			}
			for (int col = 1; col <= row; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
		}

	}

	private static void pattern1(int n) {

		for (int row = 1; row <= n; row++) {
			for (int s = 1; s <= n - row; s++) {
				System.out.print(" ");
			}
			for (int col = 1; col <= row; col++) {
				System.out.print(row + " ");
			}
			System.out.println();
		}

	}

}

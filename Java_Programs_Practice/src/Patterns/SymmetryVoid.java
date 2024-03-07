package Patterns;

public class SymmetryVoid {

	public static void main(String[] args) {
		
		int n=5;
		Symmetry1(n);
		Symmetry2(n);
	}

	private static void Symmetry2(int n) {
		int twice=2*n-2;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("* ");
			}
			
			for(int k=1;k<=twice;k++)
			{
				System.out.print("  ");
			}
			
			for(int l=1;l<=i;l++)
			{
				System.out.print("* ");
			}
			twice-=2;
			System.out.println();
		}
		
	}

	private static void Symmetry1(int n) {
		
		int twice=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i+1;j++)
			{
				System.out.print("* ");
			}
			for(int k=1;k<=twice;k++)
			{
				System.out.print("  ");
			}
			for(int l=1;l<=n-i+1;l++)
			{
				System.out.print("* ");
			}
			twice+=2;
			System.out.println();
		}
		
	}
}

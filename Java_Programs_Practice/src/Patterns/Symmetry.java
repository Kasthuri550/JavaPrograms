package Patterns;

public class Symmetry {

	public static void main(String[] args) {
		
		int n=5;
		
		int twice=2*n-2;
		for(int i=1;i<=2*n-1;i++)
		{
			int stars=i;
			if(stars>n)
			{
				stars=2*n-i;
			}
			for(int j=1;j<=stars;j++)
			{
				System.out.print("* ");
			}
			
			for(int k=1;k<=twice;k++)
			{
				System.out.print("  ");
			}
			
			for(int l=1;l<=stars;l++)
			{
				System.out.print("* ");
			}
			
			if(i<n)
			{
				twice-=2;
			}
			else
			{
				twice+=2;
			}
			
			System.out.println();
		}

	}

}

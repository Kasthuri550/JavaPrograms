package Arrayprograms.hard;

public class PascalTriangleVariation1 {

	public static void main(String[] args) {
		
		int r = 5; 
        int c = 3;
        
        pascalTriangle(r-1,c-1);

	}

	private static void pascalTriangle(int n, int r) {
		
		int result=1;
		for(int i=0;i<r;i++)
		{
			result*=(n-i);
			result/=(i+1);
		}
		
		System.out.println(result);
		
	}
}

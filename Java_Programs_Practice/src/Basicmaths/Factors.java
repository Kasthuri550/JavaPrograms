package Basicmaths;

public class Factors {

	public static void main(String[] args) {
		
		int num=-100;
//		approach1(num);
//		approach2(num);
//		approach3(num);
//		approach4(num);
		approach5(num);
	}

	private static void approach1(int num) {
		
		for(int i=1;i<=num;i++)
		{
			if(num%i==0)
			{
				System.out.print(i+" ");
			}
		}
	}
	
	private static void approach2(int num) {
		
		for(int i=1;i<=num/2;i++)
		{
			if(num%i==0)
				System.out.print(i+" ");
		}
		System.out.println(num);
	}
	
	private static void approach3(int num) {
		
		for(int i=1;i<=Math.sqrt(num);i++)
		{
			if(num%i==0)
			{
				System.out.print(i+" ");
				
				if(num/i != i)
				{
					System.out.print(num/i+" ");
				}
			}
			
		}
		
	}
	
	private static void approach4(int num) {
		
		for(int i=1;i*i<=num;i++)
		{
			if(num%i==0)
			{
				System.out.print(i+" ");
				
				if(num/i != i)
				{
					System.out.print(num/i+" ");
				}
			}
		}
		
	}
	
	private static void approach5(int num) {
		
		for(int i=num;i<=Math.abs(num);i++)
		{
			if(i==0)
			{
				continue;
			}
			else if(num%i==0)
			{
				System.out.print(i+" ");
			}
		}
		
	}
}

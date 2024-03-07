import java.util.Arrays;

public class CheckArraysEquals {

	public static void main(String[] args) {
		
		int a1[]= {1,2,3,4,5};
		int a2[]= {1,2,3,4,5};
		
//		Approach1
//		boolean status=Arrays.equals(a1, a2);
//		
//		if(status)
//		{
//			System.out.println("Arrays are equal");
//		}
//		else
//		{
//			System.out.println("Arrays are not equal");
//		}
		
//		Approach2
		boolean status=CheckSameElement(a1,a2);		
		if(status)
		{
			System.out.println("Arrays are equal");
		}
		else
		{
			System.out.println("Arrays are not equal");
		}
	}

	private static boolean CheckSameElement(int[] a1, int[] a2) {
		
		boolean status=true;
		if(a1.length==a2.length)
		{
			for(int i=0;i<a1.length;i++)
			{
				if(a1[i]!=a2[i])
				{
					status=false;
				}
			}
		}
		else
		{
			status=false;
		}
		
		return status;
			
	}
}

package Recursion;

public class LinearPrintRecursion {

	public static void main(String[] args) {
		
		printnum(1,7);

	}
	
	static void printnum(int start,int end)
	{
		if(end<start)
		{
			return;
		}
		System.out.println(start);
		printnum(start+1,end);
	}

}

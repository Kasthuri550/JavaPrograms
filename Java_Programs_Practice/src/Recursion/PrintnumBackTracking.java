package Recursion;

public class PrintnumBackTracking {

	public static void main(String[] args) {
		
		printnum(1,10);

	}
	
	static void printnum(int start,int end)
	{
		if(end<start)
		{
			return;
		}
		printnum(start,end-1);
		System.out.println(end);
	}

}

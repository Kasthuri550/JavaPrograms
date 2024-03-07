package Recursion;

public class ReversePrint {

	public static void main(String[] args) {
		
		reversenum(1,10);

	}
	
	static void reversenum(int start,int end)
	{
		if(end<start)
		{
			return;
		}
		System.out.println(end);
		reversenum(start,end-1);
	}

}

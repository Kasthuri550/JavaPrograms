package Recursion;

public class ReversePrintBacktracking {

	public static void main(String[] args) {
		
		reverseprint(1,10);

	}
	
	static void reverseprint(int start,int end)
	{
		if(start>end)
		{
			return;
		}
		reverseprint(start+1,end);
		System.out.println(start);
	}

}

package GreedyAlgorithm;

public class ValidParanthesisChecker {

	public static void main(String[] args) {

		String s="(*)))";
		
		System.out.println(checkValidString(s));
		
	}

	private static boolean checkValidString(String s) {

		int minOpen=0,maxOpen=0;
		
		for(char c:s.toCharArray())
		{
			if(c=='(')
			{
				minOpen++;
				maxOpen++;
			}
			else if(c==')')
			{
				minOpen--;
				maxOpen--;
			}
			else 
			{
				minOpen--;
				maxOpen++;
			}
			
			if(minOpen<0)
				minOpen=0;
			
			if(maxOpen<0)
				return false;
		}
		
		return minOpen==0;
	}
}

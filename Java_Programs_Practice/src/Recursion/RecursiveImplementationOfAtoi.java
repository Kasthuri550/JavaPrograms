package Recursion;

//Time Complexity: O(n)

//Space Complexity: O(n)

public class RecursiveImplementationOfAtoi {

	public static void main(String[] args) {
		
		String test1 = "12345";
        String test2 = "-6789";
        String test3 = "12a34";
        
        System.out.println(atoi(test1));
        System.out.println(atoi(test2));
        System.out.println(atoi(test3));
        System.out.println(atoi(""));

	}

	private static int atoi(String str) {

		if(str==null || str.isEmpty())
			return -1;
			
		return atoiRecursive(str,0,0,1);
	}

	private static int atoiRecursive(String str, int index, int out, int sign) {
		
		if(index==str.length())
			return out*sign;
		
		char currentChar=str.charAt(index);
		
		if(currentChar=='-')
		{
			return atoiRecursive(str, index+1, out,-1);
		}
		
		if(currentChar>='0' && currentChar<='9')
		{
			out=out*10+(currentChar-'0');
			return atoiRecursive(str, index+1, out, sign);
		}
		
		return -1;
	}
}

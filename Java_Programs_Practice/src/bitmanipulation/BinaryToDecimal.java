package bitmanipulation;

public class BinaryToDecimal {

	public static void main(String[] args) {

		String b="111";
		
		System.out.println(binaryToDecimal(b));
	}
/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
	private static int binaryToDecimal(String b) {

		int n=b.length(),num=0,power=1;
		
		for(int i=n-1;i>=0;i--)
		{
			if(b.charAt(i)=='1')
				num=num+power;
			power=power*2;
		}
		
		return num;
	}
}

package Stringprograms;

public class MoveSpecialCharactersFront {

	public static void main(String[] args) {
		
//		 String str = "going*for/carrer*-rise";
//		 String str = "going for carrer  rise";
		 String  str = "move these*spaces to/beginning";

		 
		 System.out.println(move(str));
	}

	private static String move(String str) {
		
		int n=str.length();
		String specialChar="";
		String concatStr="";
		
		for(int i=0;i<n;i++)
		{
			if(str.charAt(i)>='a' && str.charAt(i)<='z')
			{
				concatStr+=str.charAt(i);
			}
			else
			{
				specialChar+=str.charAt(i);
			}
		}
		
		
		return specialChar+concatStr;
		
	}
}

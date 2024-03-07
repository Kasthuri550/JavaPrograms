
public class Panagram {

	public static void main(String[] args) {
		
		String str="The quick brown fox jumps over the lazy dog12345 89989";
		
		System.out.println(isPanagram(str.toLowerCase()));

	}

	private static boolean isPanagram(String str) {
		
		if(str.length()<26)
		{
			return false;
		}
		else
		{
			for(char ch='a';ch<='z';ch++)
			{
				if(str.indexOf(ch)<0)
				{
					return false;
				}
			}
		}
		
		return true;
	}

}

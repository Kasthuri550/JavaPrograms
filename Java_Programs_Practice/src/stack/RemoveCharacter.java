package stack;

public class RemoveCharacter {

	public static void main(String[] args) {

		String string1 = "computer",string2 = "cat";
		
		removeChar(string1,string2);

	}

	private static void removeChar(String string1, String string2) {
		
		String[] splitArray = string1.split("");
		String finalStr="";
		for(int i=0;i<string1.length();i++)
		{
			if(!string2.contains(splitArray[i]))
			{
				finalStr+=splitArray[i];
			}
		}
		System.out.println(finalStr);
	}
}

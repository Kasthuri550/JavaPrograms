package Stringprograms.easy;

public class CapitalizeTheTitle {

	public static void main(String[] args) {
		
		String title = "capiTalIze tHe titLe";
		
		capitalizeTitle(title);

	}

	private static void capitalizeTitle(String title) {
		
		StringBuilder result=new StringBuilder();
		
		String words[]=title.split("\\s+");
		
		for(int i=0;i<words.length;i++)
		{
			if(words[i].length()<=2)
			{
				result.append(words[i].toLowerCase());
			}
			else
			{
				result.append(Character.toUpperCase(words[i].charAt(0)));
				result.append(words[i].substring(1).toLowerCase());
			}
			
			if(i < words.length)
			{
				result.append(" ");
			}
		}
		
		System.out.println(result.toString());
	}
}

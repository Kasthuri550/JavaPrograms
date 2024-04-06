package Stringprograms.easy;

public class FirstCapital {

	public static void main(String[] args) {
		
		String str = "todo tuto-generated method stub";
		StringBuilder result = new StringBuilder();

		if(!str.isEmpty())
		{
			String words[]=str.split(" ");
			
			for(int i=0;i<words.length;i++)
			{
				result.append((char)(words[i].charAt(0)+'A'-'a'));
				result.append(words[i].substring(1));
				
				if(i<words.length-1)
				{
					result.append(" ");
				}
			}
		}

		System.out.println(result.toString());

	}

}

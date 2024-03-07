import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterOccurences {

	public static void main(String[] args) {
		
		 String str = "Geeks       For     Geeks               ";
		 occur1(str);
		 occur2(str);

	}

	private static void occur2(String str) {
		
		
		
	}

	private static void occur1(String str) {
		
		str=str.replace(" ","");
		HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
		
		for(int i=0;i<str.length();i++)
		{
			if(hmap.containsKey(str.charAt(i)))
			{
				hmap.put(str.charAt(i),hmap.get(str.charAt(i))+1);
			}
			else
			{
				hmap.put(str.charAt(i),1);
			}
				
		}
		
		
		System.out.println(hmap);
		
	}

}

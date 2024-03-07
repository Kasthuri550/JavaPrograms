import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {

	public static void main(String[] args) {
		
		String str = "teststring";
		approach1(str);
//		approach2(str);
//		approach3(str);
	}

	private static void approach3(String str) {
		
		
		char ch[]=str.toCharArray();
		Arrays.sort(ch);
		
		for(int i=0;i<ch.length;i++)
		{
			int count=1;
			while(i<ch.length-1 && ch[i]==ch[i+1])
			{
				count++;
				i++;
			}
			if(count>1)
			{
			System.out.println(ch[i]+" - "+count);
			}
		}
		
	}

	private static void approach2(String str) {
		
		int n=str.length();
		Map<Character,Integer> map=new HashMap<Character, Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(map.containsKey(str.charAt(i)))
			{
				map.put(str.charAt(i),map.get(str.charAt(i))+1);
			}
			else
			{
				map.put(str.charAt(i),1);
			}
		}
		
		System.out.println(map);
		for(Map.Entry<Character,Integer> mapEntry:map.entrySet())
		{
			if(mapEntry.getValue()>1)
			{
				System.out.println(mapEntry.getKey()+" - "+mapEntry.getValue());
			}
		}
		
	}

	private static void approach1(String str) {
		
//		int n=str.length();"teststring"
		char ch[]=str.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			int count=1;
			for(int j=i+1;j<ch.length;j++)
			{
				if(ch[i]==ch[j] && ch[i]!=' ')
				{
					count++;
					ch[j]='0';
				}
			}
			if(count>1 && ch[i]!='0')
			{
				System.out.println(ch[i]+" - "+count);
			}
		}		
	}

}


public class EvenWordString {

	public static void main(String[] args) {
		
		String s = "i am Geeks for Geeks and a Geek";
		
		evenWord(s);

	}

	private static void evenWord(String s) {
		
		String[] words=s.split(" ");
		
		for(int i=0;i<words.length;i++)
		{
			if(words[i].length()%2==0)
				System.out.println(words[i]);
		}
				
	}
}

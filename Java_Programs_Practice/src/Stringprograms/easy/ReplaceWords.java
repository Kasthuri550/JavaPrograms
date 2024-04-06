package Stringprograms.easy;

public class ReplaceWords {

	public static void main(String[] args) {
		
		String S = "xxforxx xx for xx",oldW = "xx",newW = "Geeks";
		
//		replaceWord1(S,oldW,newW);
		replaceWord2(S, oldW, newW);

	}

	private static void replaceWord2(String s, String oldW, String newW) {
		
		int index=0;
		
		StringBuilder sb=new StringBuilder();
		
		while(index<s.length())
		{
			int startindex=s.indexOf(oldW, index);
			
			if(startindex==-1)
			{
				sb.append(s.substring(index));
				break;
			}
			
			sb.append(s,index,startindex);
			sb.append(newW);
			index=startindex+oldW.length();
		}
		
		System.out.println(sb.toString());
		
	}

	private static void replaceWord1(String s, String oldW, String newW) {
		
	   System.out.println(s.replaceAll(oldW, newW));
		
	}

}

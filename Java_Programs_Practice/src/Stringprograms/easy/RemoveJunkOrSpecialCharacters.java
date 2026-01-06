package Stringprograms.easy;

public class RemoveJunkOrSpecialCharacters {

	public static void main(String[] args) {

		String s="hsjhkjahjkADSGDGE78723785$@$#^#FHFDHSSARasres78783hj";
		
//		s=s.replaceAll("[^a-zA-Z0-9]","");
		s=s.replaceFirst("[^a-zA-Z0-9]", "");
		
		System.out.println(s);
	}

}

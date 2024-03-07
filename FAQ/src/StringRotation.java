
public class StringRotation {

	public static void main(String[] args) {
		
		String str="abcd";
		String substr="bcda";
		rotation1(str,substr);
	}

	private static void rotation1(String str, String substr) {
		
		if(areRotations(str,substr))
		{
			System.out.println("Strings are rotations of each other");
		}
		else
		{
			System.out.println("String are not rotations of each other");
		}
		
	}

	private static boolean areRotations(String str, String substr) {
		
		if(str==null||substr==null)
			return false;
		return (str.length()==substr.length()) && ((str+str).indexOf(substr)!=-1);
	}

}

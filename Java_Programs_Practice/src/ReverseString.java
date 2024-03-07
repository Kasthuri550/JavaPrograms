/**
 * 
 */

/**
 * @author kasthuri
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str="Kasthuri";
		String rev=reverse(str);
		System.out.println(rev);
	}
	
	static String reverse(String str)
	{
		if(str==null)
		{
			throw new IllegalArgumentException("Null is not valid input");
		}
		
		StringBuilder sb=new StringBuilder();
		
		char c[]=str.toCharArray();
		for(int i=c.length-1;i>=0;i--)
		{
			sb.append(c[i]);
		}
		
		return sb.toString();
		
	}

}

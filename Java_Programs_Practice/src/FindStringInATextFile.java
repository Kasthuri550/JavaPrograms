import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindStringInATextFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		if(approach1())
		{
			System.out.println("Present");
		}
		else
		{
			System.out.println("Not Present");
		}
	}

	private static boolean approach1() throws FileNotFoundException {
		
		File file=new File("C:\\Users\\kasthuri\\Desktop\\HTML\\test123.txt");
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine())
		{
			String nextLine = sc.nextLine();
			if(nextLine.contains("sunday"))
			{
				sc.close();
				return true;
			}
		}
		
		sc.close();
		return false;
	}
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromTextFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//		approach1();
//		approach2();
//		approach3();
//		approach4();
//		approach5();
//		approach6();
		approach7();
	}

	private static void approach7() throws IOException {
		
		int i;
		FileInputStream fis=new FileInputStream("C:\\Users\\kasthuri\\Desktop\\HTML\\test21.txt");
		while((i=fis.read())!=-1)
		{
			System.out.print((char)i);
		}
		fis.close();		
	}

	private static void approach6() throws IOException {
		
		String readAllBytes = new String(Files.readAllBytes(Paths.get("C:\\Users\\kasthuri\\Desktop\\HTML\\test.txt")));
	    System.out.println(readAllBytes);
	}

	private static void approach5() throws IOException {
		
		List<String> readAllLines = Files.readAllLines(Paths.get("C:\\Users\\kasthuri\\Desktop\\HTML\\test.txt"),StandardCharsets.UTF_8);
		for(String line:readAllLines)
		{
			System.out.println(line);
		}
	}

	private static void approach4() throws FileNotFoundException,IOException {
		
		int i;
		FileReader fr=new  FileReader("C:\\Users\\kasthuri\\Desktop\\HTML\\test.txt");
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i);
		}
		fr.close();
	}

	private static void approach3() throws FileNotFoundException {
		
		File file=new File("C:\\Users\\kasthuri\\Desktop\\HTML\\test.txt");
		Scanner sc=new Scanner(file);
		
		sc.useDelimiter("\\Z");
		System.out.println(sc.next());
		sc.close();
	}

	private static void approach2() throws FileNotFoundException {
		
		File file=new File("C:\\Users\\kasthuri\\Desktop\\HTML\\test.txt");
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
		sc.close();
	}

	private static void approach1() throws FileNotFoundException,IOException{
		
		FileReader fr=new FileReader("C:\\Users\\kasthuri\\Desktop\\HTML\\test.txt");
		BufferedReader br=new BufferedReader(fr);
		String str="";
		
		while((str=br.readLine())!=null)
		{
			System.out.println(str);
		}
		br.close();
	}

}

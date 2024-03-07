import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteDataIntoTextFile {

	public static void main(String[] args) throws IOException {
		
//		approach1();
//		approach2();
//		approach3();
	}

	private static void approach3() throws IOException {
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\kasthuri\\Desktop\\HTML\\test20");
		fos.write("Arun Kasthuri".getBytes());
		fos.close();
	}

	private static void approach2() throws IOException {
		
		FileWriter fw=new FileWriter("C:\\Users\\kasthuri\\Desktop\\HTML\\test10.txt");
		fw.write("Kasthuri");
		fw.write("Arun kumar");
		fw.close();
	}

	private static void approach1() throws IOException {
		
		FileWriter fw=new FileWriter("C:\\Users\\kasthuri\\Desktop\\HTML\\test123.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Welcome to my world");
		bw.write("Welcome to your world");
		bw.close();
	}

}

package Stringprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataFromTextFile {

	public static void main(String[] args) {

//		readDataFromFile1();
//		readDataFromFile2();
		readDataFromFile3();
	}

	private static void readDataFromFile3() {

		File file=new File("C:\\sample\\examples.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.useDelimiter("\\Z");
		System.out.println(sc.next());
	}

	private static void readDataFromFile2() {

		File file=new File("C:\\sample\\examples.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
	}

	private static void readDataFromFile1() {

		FileReader fr=null;
		try {
			fr = new FileReader("C:\\sample\\examples.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br=new BufferedReader(fr);
		
		String str;
		
		try {
			while((str=br.readLine())!=null)
			{
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

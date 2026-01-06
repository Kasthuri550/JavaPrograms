package Stringprograms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataIntoTextFile {

	public static void main(String[] args) {

		writeDataIntoTextFile();
	}

	private static void writeDataIntoTextFile() {

		FileWriter fw=null;
		try {
			fw = new FileWriter("C:\\sample\\sampletxt.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw=new BufferedWriter(fw);
		
		try {
			bw.write("kasthuri");
			bw.write("Suseela");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

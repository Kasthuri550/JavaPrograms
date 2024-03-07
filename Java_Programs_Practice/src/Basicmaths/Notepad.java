package Basicmaths;

import java.io.IOException;

public class Notepad {

	public static void main(String[] args) {
		
		Runtime rt=Runtime.getRuntime();
		
		try {
			rt.exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

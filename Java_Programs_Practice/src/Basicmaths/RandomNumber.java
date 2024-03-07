package Basicmaths;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		
		random1();

	}

	private static void random1() {
		
		Random random=new Random();
		
		for(int itr=1;itr<=10;itr++)
		{
			System.out.println(random.nextInt(100));
		}
		
	}

}

package Basicmaths;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNum {

	public static void main(String[] args) {

		randomNumber();
		randomString();
		randomAlphabetic();
	}
	
	private static void randomAlphabetic() {

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		int length = 10;

		for (int i = 0; i < length; i++) {

		    int type = random.nextInt(3);

		    if (type == 0) {                  // lowercase
		        sb.append((char) ('a' + random.nextInt(26)));
		    } 
		    else if (type == 1) {             // uppercase
		        sb.append((char) ('A' + random.nextInt(26)));
		    } 
		    else {                            // digit
		        sb.append((char) ('0' + random.nextInt(10)));
		    }
		}

		System.out.println(sb.toString());
	}

	private static void randomString() {

		Random random=new Random();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<6;i++)
		{
			char ch=(char)('a'+random.nextInt(26));
			sb.append(ch);
		}
		
		System.out.println(sb.toString());
	}

	private static void randomNumber()
	{
		Random random=new Random();
		
		System.out.println(random.nextInt(10));
		
		System.out.println(random.nextDouble());
		
		System.out.println(ThreadLocalRandom.current().nextInt(10,50));
		
		System.out.println((int)(Math.random()*100)+1);
	}
}

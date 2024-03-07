import java.util.Random;

public class ShuffleArray {

	public static void main(String[] args) {
		
		String[] str= {"A","B","C","D","E"};
//		shuffle1(str);
		shuffle2(str);
		
		for(int j=0;j<str.length;j++)
		{
			System.out.print(str[j]+" ");
		}
	}

	private static void shuffle2(String[] str) {
		
		Random rand=new Random();
		int noOfElements=str.length;
		
		for(int i=0;i<noOfElements;i++)
		{
			int randomIndex=rand.nextInt(noOfElements);
			String temp=str[randomIndex];
			str[randomIndex]=str[i];
			str[i]=temp;
		}
		
	}

	private static void shuffle1(String[] str) {
		
		int noOfElements=str.length;
		
		for(int i=0;i<noOfElements;i++)
		{
			int s=i+(int)(Math.random()*(noOfElements-i));
			
			String temp=str[s];
			str[s]=str[i];
			str[i]=temp;
		}
	}

}

package hashing;

import java.util.Scanner;

public class FindFrequencyOfElements {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		int hash[]=new int[13];
		
		for(int i=0;i<n;i++)
		{
			hash[arr[i]]++;
		}
		
		System.out.println("Enter number of queries: ");
		int q=sc.nextInt();
		
		while(q>0)
		{
			System.out.println("Enter search element: ");
			int s=sc.nextInt();
			
			System.out.println(s+" -> "+hash[s]);
			q--;
		}

	}
}

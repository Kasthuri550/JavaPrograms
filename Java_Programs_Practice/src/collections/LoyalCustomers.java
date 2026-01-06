package collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * You have 2 files

Each file contains customerId,pageVisited

You need to find most loyal customers

Loyal customer = visited more than 1 unique page

Pages can be across both files
 * */

/*
 * Time Complexity: O(n1+n2)
 * Space Complexity: O(m*p)
 * 
 * where m=number of unique customers
 * 		 n=average number of unique pages per customer
 * */
public class LoyalCustomers {

	public static void main(String[] args) {

		loyalCustomers();
	}

	private static void loyalCustomers() {

		Map<String,Set<String>> customerMap=new TreeMap<>();

		readFiles("C:\\temp\\file1.txt",customerMap);
		readFiles("C:\\temp\\file2.txt",customerMap);

		for(Map.Entry<String,Set<String>> entry:customerMap.entrySet())
		{
			if(entry.getValue().size()>1)
			{
				System.out.println(entry.getKey());
			}
		}
	}

	private static void readFiles(String fileName, Map<String, Set<String>> customerMap) {

		BufferedReader br=null;

		try {
			br=new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line;

		try {
			while((line=br.readLine())!=null)
			{
				String parts[]=line.split(",");
				String customer=parts[0];
				String page=parts[1];

				customerMap.computeIfAbsent(customer,k->new HashSet<>()).add(page);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

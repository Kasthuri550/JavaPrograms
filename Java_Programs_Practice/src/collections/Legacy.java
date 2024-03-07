package collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Legacy {

	public static void main(String[] args) throws IOException {
		
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\abc.properties");
		p.load(fis);
		System.out.println(p.getProperty("username"));
		p.setProperty("location","Chennai");
		FileOutputStream fos=new FileOutputStream("C:\\abc.properties");
		p.store(fos, "Updated by kasthuri");
		Enumeration<?> propertyNames = p.propertyNames();
		while(propertyNames.hasMoreElements())
		{
			System.out.println(propertyNames.nextElement());
		}

	}

}

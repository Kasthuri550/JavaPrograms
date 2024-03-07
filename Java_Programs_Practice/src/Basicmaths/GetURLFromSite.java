package Basicmaths;

import java.net.MalformedURLException;
import java.net.URL;

public class GetURLFromSite {

	public static void main(String[] args) {

		try {
			URL url=new URL("https://www.google.com/");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

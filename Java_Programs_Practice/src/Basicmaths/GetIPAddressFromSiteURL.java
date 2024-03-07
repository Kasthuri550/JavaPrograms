package Basicmaths;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddressFromSiteURL {
	
	public static void main(String[] args) {
		
		try {
			InetAddress inetAddress=InetAddress.getByName("www.technolamror.com");
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}

}

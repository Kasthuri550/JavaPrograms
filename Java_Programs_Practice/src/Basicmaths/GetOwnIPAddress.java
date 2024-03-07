package Basicmaths;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetOwnIPAddress {

	public static void main(String[] args) {
		
		try {
			OwnIPAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	private static void OwnIPAddress() throws UnknownHostException {
		InetAddress inetAddress=InetAddress.getLocalHost();
		System.out.println(inetAddress);
	}

}

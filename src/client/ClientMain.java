package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class ClientMain {
	public static void main(String[] args) throws Exception{
		System.setProperty("javax.net.ssl.trustStore", "clientFIles/client.truststore.jks");
//	    System.setProperty("javax.net.ssl.trustStorePassword", "eit060");
	    System.setProperty("javax.net.ssl.keyStore", "clientFIles/client.keystore.jks");
	    System.setProperty("javax.net.ssl.keyStorePassword", "eit060");
	    
	    SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
	    Socket s = ssf.createSocket("127.0.0.1", 5432);

	    SSLSession session = ((SSLSocket) s).getSession();
	    Certificate[] cchain = session.getPeerCertificates();
	    
	    System.out.println("The Certificates used by peer");
	    for (int i = 0; i < cchain.length; i++) {
	      System.out.println(((X509Certificate) cchain[i]).getSubjectDN());
	    }
		System.out.println("Peer host is " + session.getPeerHost());
	    System.out.println("Cipher is " + session.getCipherSuite());
	    System.out.println("Protocol is " + session.getProtocol());
	    System.out.println("ID is " + new BigInteger(session.getId()));
	    System.out.println("Session created in " + session.getCreationTime());
	    System.out.println("Session accessed in " + session.getLastAccessedTime());
	    
		BufferedReader rd = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream wr = new PrintStream(s.getOutputStream());
		boolean logedIn = false;
		
		Scanner in = new Scanner(System.in);
		
			while(s.isConnected()){
				wr.println(in.next());
				System.out.println(rd.readLine());
			}
			

	}
}

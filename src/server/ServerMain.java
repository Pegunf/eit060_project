package server;

import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class ServerMain {
	public static void main(String[] args) throws Exception{
		System.setProperty("javax.net.ssl.keyStore", "client.keystore.jks");
	    System.setProperty("javax.net.ssl.keyStorePassword", "eit060");
	    
	    SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	    ServerSocket server = ssf.createServerSocket(5432);
	    while (true) {
	      Socket socket = server.accept();
	      SSLSession session = ((SSLSocket) socket).getSession();
	      X509Certificate cert = (X509Certificate) session.getPeerCertificates()[0];
	      
	      server.close();
	    }
	}
}
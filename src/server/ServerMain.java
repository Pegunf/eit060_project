package server;

import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.security.cert.X509Certificate;

public class ServerMain {
	public static void main(String[] args) throws Exception{
		System.setProperty("javax.net.ssl.keyStore", "keystore");
	    System.setProperty("javax.net.ssl.keyStorePassword", "eit060");
	    //lite comments här lolol
	    //TEST COMMENT
	    SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	    ServerSocket server = ssf.createServerSocket(7778);
	    while (true) {
	      SSLSocket socket = (SSLSocket) server.accept();
	      SSLSession session = ((SSLSocket) socket).getSession();
	      X509Certificate cert = (X509Certificate) session.getPeerCertificates()[0];
	      
	      server.close();
	    }
	}
}

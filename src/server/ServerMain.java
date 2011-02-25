package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.*;

import common.CommandAddRecord;
import common.CommandEditRecord;
import common.CommandGetRecordContent;
import common.CommandLibrary;
import common.CommandLogin;
import common.LoginManager;
import common.PasswordInvalidException;
import common.Record;
import common.User;
import common.UserNotFoundException;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
	public static void main(String[] args) throws Exception {
		System.setProperty("javax.net.ssl.trustStore",
				"serverFiles/server.truststore.jks");
		// System.setProperty("javax.net.ssl.trustStorePassword", "eit060");
		System.setProperty("javax.net.ssl.keyStore",
				"serverFiles/server.keystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "eit060");


		SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory
				.getDefault();
		ServerSocket ss = ssf.createServerSocket(5432);
		while (true) {
			Socket s = ss.accept();
			SSLSession session = ((SSLSocket) s).getSession();
			Certificate[] cchain = session.getLocalCertificates();
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

			List<Record> records = new ArrayList<Record>();
			
			Record testRecord1 = new Record(0,2,1,0,0,"LITE CONTNENTT!!!");
			records.add(testRecord1);
			
			LoginManager loginMan = new LoginManager("serverFiles/userdata.txt");
			CommandLibrary cLib = new CommandLibrary();
			/*COMMAND: "getrecord;'id'" */
			cLib.addCommand(new CommandGetRecordContent("getrecord", records,wr));
			/*COMMAND: "addrecord;'id';'nurseid';'patientid';'content'" */
			cLib.addCommand(new CommandAddRecord("addrecord", records,wr));
			/*COMMAND: "login;'username';'password'" */
			cLib.addCommand(new CommandLogin("login",loginMan,wr));
			
			
			
			while (s.isConnected()) {
				String inData = rd.readLine();
				cLib.parseCommand(loginMan.getUser(), inData);
			}

		}
	}
}
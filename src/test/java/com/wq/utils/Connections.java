package com.wq.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Properties;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

//This class used for DB connectivity
public class Connections {


		public static Connection db = null;
		public static Connection devdb = null;
		public	static Statement stmt = null;
		public static ResultSet rs = null;
		public static Session session;
		static int row;
	//	static Random random = new Random();
		//static int num = random.nextInt(900);

		public static void Dev_createSSHTunnelToDev() throws ClassNotFoundException, SQLException {
			String ssh_user = "moneytap";
			String host = "dev.moneytap.com";
			String rhost = "devpg001-mumbai.claxidzirf9s.ap-south-1.rds.amazonaws.com";
			int port = 22;
			try {
				JSch jsch = new JSch();
				// for ssh key
				// Make this configurable
				jsch.addIdentity("./src/test/resources/privateKey.ppk");

				session = jsch.getSession(ssh_user, host, port);
				int lport = 15531;
				int rport = 5432;

				Properties config = new Properties();
				config.put("StrictHostKeyChecking", "no");
				session.setConfig(config);

				session.setConfig("StrictHostKeyChecking", "no");
	//			System.out.println("Establishing Connection...");
				session.connect();
				session.setTimeout(3000000);
				int assignedPort = session.setPortForwardingL(lport, rhost, rport);
	//			System.out.println("localhost:" + assignedPort + " -> " + rhost + ":" + rport);
				Dev_connectToDevDb();
			} catch (Exception e) {
				System.err.print(e);
			}
		}

		public static String Dev_connectToDevDb() {

			final String DB_HOST = "localhost";
			final String DB_PORT = "15531";
			final String DB_USER = "techadminacct";
			final String DB_PASSWD = "cashin2oo8$";
			final String DB_NAME = "cashindb";
			final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
			
			
			try {
				Class.forName("org.postgresql.Driver");
				devdb = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
			} catch (Exception ex) {
				System.out.println(ex);
			}
			return null;

		}

		public static void Dev_Close_connection() throws SQLException, ClassNotFoundException {

			try {
				devdb.close();
				session.disconnect();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}

		public static String Dev_SelectQueryPan(String value) {
			String query = "select otp from otp where phone ='" + value + "' and purpose = 'SIGNUP' and status = 'SENT'";
		//	System.out.println(query);
			return query;
		}
		
		public static LinkedHashMap Dev_SelectQueryCust(String phoneNum) throws ClassNotFoundException, SQLException {
			String query = "select id from customer where phone ='" + phoneNum + "'";
	//		System.out.println(query);
			return(Dev_DB_executequery(query));
		}
		
		public static String Dev_deletePan(String pan) throws ClassNotFoundException, SQLException {
			String deleteQuery = "delete from pancard where pannumber ='" + pan + "'";
		//	System.out.println(deleteQuery);
			Dev_createSSHTunnelToDev();
			stmt = devdb.createStatement();
			int rows = stmt.executeUpdate(deleteQuery);
			stmt.close();
			Dev_Close_connection();
		//	System.out.println("deleted the data successfully...");
			return deleteQuery;
		}
		
		public static String Dev_updateCust(String phone, Object customerId) throws SQLException, ClassNotFoundException {
			
			String query = "update customer set phone ='" + phone + "." + customerId + ".deleted'" + " where phone ='" + phone + "';";
		//	System.out.println(query);
			Dev_createSSHTunnelToDev();
			stmt = devdb.createStatement();
			int rows = stmt.executeUpdate(query);
			stmt.close();
			Dev_Close_connection();
	//		System.out.println("updated the data successfully...");
			return query;
			
		}
				
		@SuppressWarnings({ "rawtypes" })
		public static LinkedHashMap Dev_DB_executequery(String query) throws SQLException, ClassNotFoundException {
			LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
			try {
			
				Dev_createSSHTunnelToDev();
				stmt = devdb.createStatement();
				rs = stmt.executeQuery(query);
				stmt.close();
				Dev_Close_connection();
				ResultSetMetaData md = rs.getMetaData();
				int columns = md.getColumnCount();

				while (rs.next()) {
					for (int i = 1; i <= columns; ++i) {
						hm.put(md.getColumnName(i), rs.getString(i));
						}
				}

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			return hm;
		}

		public static void QA_Close_connection() throws SQLException, ClassNotFoundException {

			try {
				db.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}

}

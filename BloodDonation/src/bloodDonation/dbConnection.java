package bloodDonation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class dbConnection {
	static Statement state;
	static Connection conn;
	/**
	 * DataBase Connection 
	 */
	public static Connection ConnerDb() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/blooddb","root","");
			state = conn.createStatement();
			System.out.print("Connected");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}

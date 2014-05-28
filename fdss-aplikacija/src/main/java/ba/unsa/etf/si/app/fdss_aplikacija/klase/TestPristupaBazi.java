package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestPristupaBazi {

	private static String _imeBaze;
	private static String _username;
	private static String _password;

	public TestPristupaBazi(String i, String un, String p) {

		_imeBaze = i;
		_username = un;
		_password = p;
	}

	public static boolean Testiraj() throws Exception {
		
		_username = "root";
		_password = "";
		_imeBaze = "bazafdss";
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/" + _imeBaze, _username, _password);
		c.setAutoCommit(false);
		
		Statement stmt = c.createStatement();
		stmt.execute("SELECT * FROM uposlenik");

		c.close();
		
		return true;
	}
}
package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestPristupaBazi {

	private static String _imeBaze;
	private static String _username;
	private static String _password;
	
	public TestPristupaBazi() {

		_imeBaze = "bazafdss";
		_username = "root";
		_password = "";
	}

	public TestPristupaBazi(String i, String un, String p) {

		_imeBaze = i;
		_username = un;
		_password = p;
	}

	public static boolean Testiraj() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/" + _imeBaze, _username, _password);
		c.setAutoCommit(false);
		
		Statement stmt = c.createStatement();
		stmt.execute("SELECT * FROM uposlenik");

		c.close();
		
		return true;
	}
	
	public static void exportPodataka(String filename) {
		
        Statement stmt;
        String query;
        
        try {
        	
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/" + _imeBaze, _username, _password);
    		
            stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            //For comma separated file
            query = "SELECT id, ime, prezime, jib, adresa, mjesto, telefon, email, tip, username, password into OUTFILE  '" + filename +
                    "' FIELDS TERMINATED BY ',' FROM uposlenik";
            stmt.executeQuery(query);
            c.close();
            
        } catch(Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Eksportovanje podataka iz baze nije uspjelo. \nRazlog : \n" + e.getClass().getName()+": "+ e.getMessage());
            stmt = null;
        }
    }
	
	public static void importPodataka(String filename)
    {
        Statement stmt;
        String query;
		_username = "root";
		_password = "";
		_imeBaze = "bazafdss";

        try
        {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/" + _imeBaze, _username, _password);
    		
            stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            query = "LOAD DATA INFILE '" + filename + "' INTO TABLE uposlenik FIELDS TERMINATED BY ',' (id, ime, prezime, jib, adresa, mjesto, telefon, email, tip, username, password)";
            stmt.executeUpdate(query);
                
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Importovanje podataka u bazu nije uspjelo. \nRazlog : \n" + e.getClass().getName()+": "+ e.getMessage());
            stmt = null;
        }
    }
}
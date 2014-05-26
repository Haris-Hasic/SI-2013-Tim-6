package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Validacija {
	
	public static boolean validirajJMBG(String jmbg) {
		
		List<Integer> JMBG_N = new ArrayList<Integer>();
		
		for (char c : jmbg.toCharArray()) 
			JMBG_N.add(Character.getNumericValue(c));
		
		if(jmbg.length() != 13)
			return false;
		
		else 
		{
			double eval = 0;
			
			for(int i = 0; i < 6; i++)
				eval += (7 - i) * (JMBG_N.get(i) + JMBG_N.get(i + 6));
			
			return JMBG_N.get(12) == 11 - eval % 11;
		}
	}
	
	public static boolean validirajIBFM(String ibfm) {
		
		boolean cifre = true;
		
		for (int i = 2; i < ibfm.length(); i++) {
			
			if(!Character.isDigit(ibfm.charAt(i)))
				cifre = false;
		}
		
		if(ibfm.length() != 8 || cifre == false)
			return false;
		
		return true;
	}
	
	public static boolean validirajIBFU(String ibfu) {
		
		boolean cifre = true;
		
		for (int i = 2; i < ibfu.length(); i++) {
			
			if(!Character.isDigit(ibfu.charAt(i)))
				cifre = false;
		}
		
		if(ibfu.length() != 8 || cifre == false || Character.getNumericValue(ibfu.charAt(ibfu.length() - 1)) != 0 )
			return false;
		
		return true;
	}
	
	public static boolean validirajWeb(String w) {
		
		return true;
		//return w.matches("/^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$/");
	}
	
	public static boolean validirajEmail(String em) {
		
		//return em.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		return true;
	}
	
	public static boolean validirajTelefon(String tel) {
		
		return tel.matches("[+][0-9]{9,15}");
	}
	
	public static String HesirajMD5(String message){ 
		
		String digest = null; 
		
		try { 
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes("UTF-8")); //converting byte array to Hexadecimal String
			
			StringBuilder sb = new StringBuilder(2*hash.length);
			
			for(byte b : hash)
				sb.append(String.format("%02x", b&0xff));
			
			digest = sb.toString();
		}
		
		catch (UnsupportedEncodingException ex) { 
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
			//Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex);
		} 
		
		catch (NoSuchAlgorithmException ex) { 
			
			JOptionPane.showMessageDialog(null, ex.getMessage());
			//Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex);
		} 
		
		return digest; 
	}
	
	public void poruka(String poruka)
	{
		JOptionPane.showMessageDialog(null, poruka);
	}
}

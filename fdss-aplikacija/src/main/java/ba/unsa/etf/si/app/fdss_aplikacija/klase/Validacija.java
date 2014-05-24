package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.util.ArrayList;
import java.util.List;

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
	
	public void poruka(String poruka)
	{
		JOptionPane.showMessageDialog(null, poruka);
	}
}

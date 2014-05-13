package glavneForme;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class Validator {
//	mozemo je ovako koristiti
//	if(new Validator.ispravanJIB("neki tekst")) bla bla..;
//  ima jos jedna dobra stvar, a to je:
//	http://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html

	
	public Boolean ispravanJIB(String _ulaz)
	{
		if(!_ulaz.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) return false;
		return true;
	}
	
	public Boolean ispravanJIBPoruka(String _ulaz)
	{
		if(!ispravanJIB(_ulaz))
		{
			JOptionPane.showMessageDialog(null,"Pogresan format JIB-a!");
			return false;
		}
		return true;
	}
	
	public Boolean ispravanIBFU(String _ulaz)
	{
		if(!_ulaz.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) return false;
		return true;
	}
	
	public Boolean ispravanIBFUPoruka(String _ulaz)
	{
		if(!ispravanIBFU(_ulaz))
		{
			JOptionPane.showMessageDialog(null,"Pogresan format IBFU-a!");
			return false;
		}
		return true;
	}
	
	public Boolean ispravanIBFM(String _ulaz)
	{
		return ispravanIBFU(_ulaz);
	}
	
	public Boolean ispravanIBFMPoruka(String _ulaz)
	{
		if(!ispravanIBFU(_ulaz))
		{
			JOptionPane.showMessageDialog(null,"Pogresan format IBFM-a!");
			return false;
		}
		return true;
	}
	
	public Boolean ispravanDatum(String _datum)
	{
			if(_datum == null){
				return false;
			}
	 
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
			sdf.setLenient(false);
	 
			try {
	 
				Date date = sdf.parse(_datum);
	 
			} catch (ParseException e) {
	 
				return false;
			}
	 
			return true;
		
	}
	public Boolean ispravanTelefon(String _ulaz)//###-###-###
	{
		if(!_ulaz.matches("[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]")) return false;
		return true;
	}
	
	public Boolean ispravanDatumPoruka(String _ulaz)//###-###-###
	{
		if(!ispravanDatum(_ulaz))
		{
			JOptionPane.showMessageDialog(null,"Pogresan format datuma!");
			return false;
		}
		return true;
	}
	
	public Boolean ispravanTelefonPoruka(String _ulaz)//###-###-###
	{
		if(!ispravanTelefon(_ulaz))
		{
			JOptionPane.showMessageDialog(null,"Pogresan format telefona!");
			return false;
		}
		return true;
	}
	
	
}

package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;

public class Uredjaj implements Serializable{
	
	long Uredjajid;
	public long getUredjajid() {
		return Uredjajid;
	}

	public void setUredjajid(long uredjajid) {
		Uredjajid = uredjajid;
	}

	int jibProizvodaca;
	String tipUredaja;
	String ibfu;
	String ibfm;
	
	public Uredjaj() {
		
	}


	public int getJibProizvodaca() {
		return jibProizvodaca;
	}

	public void setJibProizvodaca(int jibProizvodaca) {
		this.jibProizvodaca = jibProizvodaca;
	}

	public String getTipUredaja() {
		return tipUredaja;
	}

	public void setTipUredaja(String tipUredaja) {
		this.tipUredaja = tipUredaja;
	}

	public String getIbfu() {
		return ibfu;
	}

	public void setIbfu(String ibfu) {
		this.ibfu = ibfu;
	}

	public String getIbfm() {
		return ibfm;
	}

	public void setIbfm(String ibfm) {
		this.ibfm = ibfm;
	}

	@Override
	public boolean equals(Object obj) {
		 if (this == obj)
	           return true;
	       if (obj == null)
	           return false;
	       if (getClass() != obj.getClass())
	           return false;
	       final Uredjaj other = (Uredjaj) obj;
	       if (ibfu != other.getIbfu())
	           return false;
	       return true;
	   }

}

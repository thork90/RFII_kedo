package hu.ingatlankozvetites.beans;

import hu.ingatlankozvetites.dao.DBControl;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Ajanlat implements Serializable{
	int aj_id;
	int ar;
	String cim;
	int terulet;
	boolean elado;
	boolean haz;
	boolean udvar;
	boolean kert;
	boolean terasz;
	boolean erkely;
	boolean medence;
	boolean garazs;
	Date idop;
	String hirdeto_nev;
	
	
	public int getAj_id() {
		return aj_id;
	}


	public void setAj_id(int aj_id) {
		this.aj_id = aj_id;
	}


	public int getAr() {
		return ar;
	}


	public void setAr(int ar) {
		this.ar = ar;
	}


	public String getCim() {
		return cim;
	}


	public void setCim(String cim) {
		this.cim = cim;
	}


	public int getTerulet() {
		return terulet;
	}


	public void setTerulet(int terulet) {
		this.terulet = terulet;
	}


	public boolean isElado() {
		return elado;
	}


	public void setElado(boolean elado) {
		this.elado = elado;
	}


	public boolean isHaz() {
		return haz;
	}


	public void setHaz(boolean haz) {
		this.haz = haz;
	}


	public boolean isUdvar() {
		return udvar;
	}


	public void setUdvar(boolean udvar) {
		this.udvar = udvar;
	}


	public boolean isKert() {
		return kert;
	}


	public void setKert(boolean kert) {
		this.kert = kert;
	}


	public boolean isTerasz() {
		return terasz;
	}


	public void setTerasz(boolean terasz) {
		this.terasz = terasz;
	}


	public boolean isErkely() {
		return erkely;
	}


	public void setErkely(boolean erkely) {
		this.erkely = erkely;
	}


	public boolean isMedence() {
		return medence;
	}


	public void setMedence(boolean medence) {
		this.medence = medence;
	}


	public boolean isGarazs() {
		return garazs;
	}


	public void setGarazs(boolean garazs) {
		this.garazs = garazs;
	}


	public Date getIdop() {
		return idop;
	}


	public void setIdop(Date idop) {
		this.idop = idop;
	}


	public String getHirdeto_nev() {
		return hirdeto_nev;
	}


	public void setHirdeto_nev(String hirdeto_nev) {
		this.hirdeto_nev = hirdeto_nev;
	}

	// ------------------------------------------------------------------------------------------------

	public Ajanlat(){
		aj_id = 0;
		ar = 0;
		cim = "";
		terulet = 0;
		elado = true;
		haz = false;
		udvar = false;
		kert = false;
		terasz = false;
		erkely = false;
		medence = false;
		garazs = false;
		idop = Date.valueOf("2014-10-24");
		hirdeto_nev = "";
	}
	

	public Ajanlat(int ar, String cim, int terulet, boolean elado, boolean haz,
			boolean udvar, boolean kert, boolean terasz, boolean erkely,
			boolean medence, boolean garazs, Date idop, String hirdeto_nev) {
		super();
		this.aj_id = (int) Math.random();
		this.ar = ar;
		this.cim = cim;
		this.terulet = terulet;
		this.elado = elado;
		this.haz = haz;
		this.udvar = udvar;
		this.kert = kert;
		this.terasz = terasz;
		this.erkely = erkely;
		this.medence = medence;
		this.garazs = garazs;
		this.idop = idop;
		this.hirdeto_nev = hirdeto_nev;
	}
	public Ajanlat(int aj_id, int ar, String cim, int terulet, boolean elado,
			boolean haz, boolean udvar, boolean kert, boolean terasz,
			boolean erkely, boolean medence, boolean garazs, Date idop,
			String hirdeto_nev) {
		super();
		this.aj_id = aj_id;
		this.ar = ar;
		this.cim = cim;
		this.terulet = terulet;
		this.elado = elado;
		this.haz = haz;
		this.udvar = udvar;
		this.kert = kert;
		this.terasz = terasz;
		this.erkely = erkely;
		this.medence = medence;
		this.garazs = garazs;
		this.idop = idop;
		this.hirdeto_nev = hirdeto_nev;
	}
	
	@SuppressWarnings("unused")
	private static boolean toBoolean(int i) {
		if (i==1) return true;
		else return false;
	}
	private static int toInt(boolean i) {
		if (i==true) return 1;
		else return 0;
	}
	public static List<Ajanlat> osszesListaz(){		
		DBControl control = new DBControl();
		List<Ajanlat> osszes = null;
		String sql = "SELECT * FROM Ajanlat";
		try {
			osszes = control.getAjanlat(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return osszes;
	}
	
	public static List<Ajanlat> szur(int ar, String cim, int terulet, boolean elado, boolean haz,
			boolean udvar, boolean kert, boolean terasz,
			boolean erkely, boolean medence, boolean garazs, Date idop,
			String hirdeto_nev) {
		DBControl control = new DBControl();
		String szures = "";
		List<Ajanlat> osszes = null;
		String sql = "SELECT * FROM Ajanlat WHERE ";
		
		if (ar > 0) szures += "ar = '"+ar+"' AND ";
		if (!cim.isEmpty()) szures += "cim LIKE '%"+cim+"%' AND ";
		if (terulet > 0) szures += "terulet = "+terulet+" AND ";
		if (elado) szures += "elado = 1 AND "; else if (elado == false) szures += "elado = 0 AND ";
		if (haz) szures += "haz = 1 AND "; else if (haz == false) szures += "haz = 0 AND ";
		if (udvar) szures += "udvar = 1 AND "; else if (udvar == false) szures += "udvar = 0 AND ";
		if (kert) szures += "kert = 1 AND "; else if (kert == false) szures += "kert = 0 AND ";
		if (terasz) szures += "terasz = 1 AND "; else if (terasz == false) szures += "terasz = 0 AND ";
		if (erkely) szures += "erkely = 1 AND "; else if (erkely == false) szures += "erkely = 0 AND ";
		if (medence) szures += "medence = 1 AND "; else if (medence == false) szures += "medence = 0 AND ";
		if (garazs) szures += "garazs = 1 AND "; else if (garazs == false) szures += "garazs = 0 AND ";
		if (idop != null) szures += "idop >= '"+idop+"' AND ";
		if (!hirdeto_nev.isEmpty()) szures += "hirdeto_nev = '"+hirdeto_nev+"' AND ";
		szures=szures.substring(0, szures.length()-4);
		
		
		
		sql+=szures;
		//Logger.getAnonymousLogger(sql);
		try {
			osszes = control.getAjanlat(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return osszes;
	}
	
	/*
	 * 0 - false, 1 - true, 2 - nincs szures
	 * */
	public static List<Ajanlat> szur(int ar, String cim, int terulet, int elado, int haz,
			int udvar, int kert, int terasz,
			int erkely, int medence, int garazs, Date idop,
			String hirdeto_nev) {
		DBControl control = new DBControl();
		String szures = "";
		List<Ajanlat> osszes = null;
		String sql = "SELECT * FROM Ajanlat WHERE ";
		
		if (ar > 0) szures += "ar = '"+ar+"' AND ";
		if (!cim.isEmpty()) szures += "cim LIKE '%"+cim+"%' AND ";
		if (terulet > 0) szures += "terulet = "+terulet+" AND ";
		if (elado==1) szures += "elado = 1 AND "; else if (elado == 0) szures += "elado = 0 AND ";
		if (haz==1) szures += "haz = 1 AND "; else if (haz == 0) szures += "haz = 0 AND ";
		if (udvar==1) szures += "udvar = 1 AND "; else if (udvar == 0) szures += "udvar = 0 AND ";
		if (kert==1) szures += "kert = 1 AND "; else if (kert == 0) szures += "kert = 0 AND ";
		if (terasz==1) szures += "terasz = 1 AND "; else if (terasz == 0) szures += "terasz = 0 AND ";
		if (erkely==1) szures += "erkely = 1 AND "; else if (erkely == 0) szures += "erkely = 0 AND ";
		if (medence==1) szures += "medence = 1 AND "; else if (medence == 0) szures += "medence = 0 AND ";
		if (garazs==1) szures += "garazs = 1 AND "; else if (garazs == 0) szures += "garazs = 0 AND ";
		if (idop != null) szures += "idop >= '"+idop+"' AND ";
		if (!hirdeto_nev.isEmpty()) szures += "hirdeto_nev = '"+hirdeto_nev+"' AND ";
		szures=szures.substring(0, szures.length()-4);
		
		
		
		sql+=szures;
		//Logger.getAnonymousLogger(sql);
		try {
			osszes = control.getAjanlat(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return osszes;
	}
	
	public static void felt(int ar, String cim, int terulet, boolean elado, boolean haz,
			boolean udvar, boolean kert, boolean terasz,
			boolean erkely, boolean medence, boolean garazs, Date idop,
			String hirdeto_nev) {
		Ajanlat tmp = new Ajanlat(ar,cim,terulet,elado,haz,udvar,kert,terasz,erkely,medence,garazs,idop,hirdeto_nev);
		DBControl control = new DBControl();
		String sql = "INSERT INTO Ajanlat ('elado','ar','cim','haz','terulet','udvar','kert','terasz','erkely','medence','garazs','idop','hirdeto_nev') "
				+"VALUES ('"+toInt(tmp.elado)+"',"
				+ "'"+tmp.ar+"'," + "'"+tmp.cim+"'," + "'"+toInt(tmp.haz)+"'," + "'"+tmp.terulet+"'," 
				+ "'"+toInt(tmp.udvar)+"'," + "'"+toInt(tmp.kert)+"'," + "'"+toInt(tmp.terasz)+"'," 
				+ "'"+toInt(tmp.erkely)+"'," + "'"+toInt(tmp.medence)+"'," + "'"+toInt(tmp.garazs)+"',"
				+ "'"+tmp.idop+"'," + "'"+tmp.hirdeto_nev+"'" + ")";
		try {
			control.insert(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	public static void modos(int aj_id, int ar, String cim, int terulet, int elado, int haz,
			int udvar, int kert, int terasz,
			int erkely, int medence, int garazs, Date idop,
			String hirdeto_nev) {
		DBControl control = new DBControl();
		String modos = "  ";
		String sql = "UPDATE Ajanlat SET ";
		
		if (ar > 0) modos += "ar = '"+ar+"', ";
		if (!cim.isEmpty()) modos += "cim = '"+cim+"', ";
		if (terulet > 0) modos += "terulet = "+terulet+", ";
		if (elado==1) modos += "elado = 1, "; else if (elado == 0) modos += "elado = 0, ";
		if (haz==1) modos += "haz = 1, "; else if (haz == 0) modos += "haz = 0, ";
		if (udvar==1) modos += "udvar = 1, "; else if (udvar == 0) modos += "udvar = 0, ";
		if (kert==1) modos += "kert = 1, "; else if (kert == 0) modos += "kert = 0, ";
		if (terasz==1) modos += "terasz = 1, "; else if (terasz == 0) modos += "terasz = 0, ";
		if (erkely==1) modos += "erkely = 1, "; else if (erkely == 0) modos += "erkely = 0, ";
		if (medence==1) modos += "medence = 1, "; else if (medence == 0) modos += "medence = 0, ";
		if (garazs==1) modos += "garazs = 1, "; else if (garazs == 0) modos += "garazs = 0, ";
		if (idop != null) modos += "idop >= '"+idop+"', ";
		if (!hirdeto_nev.isEmpty()) modos += "hirdeto_nev = '"+hirdeto_nev+"', ";
		modos=modos.substring(0, modos.length()-2);
		modos += " WHERE aj_id='"+aj_id+"'";
		sql+=modos;
		
		try {
			control.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void torol(int aj_id) {
		String sql = "DELETE FROM Ajanlat WHERE aj_id='"+aj_id+"'";
		DBControl control = new DBControl();
		try {
			control.delete(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

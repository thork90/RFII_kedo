package hu.ingatlankozvetites.beans;

import hu.ingatlankozvetites.dao.DBControl;

import java.sql.SQLException;
import java.util.List;

public class Felh {
	String felh_nev;
	String nev;
	String email;
	String tel_sz;
	String jelszo;
	
	public String getFelh_nev() {
		return felh_nev;
	}
	public void setFelh_nev(String felh_nev) {
		this.felh_nev = felh_nev;
	}
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel_sz() {
		return tel_sz;
	}
	public void setTel_sz(String tel_sz) {
		this.tel_sz = tel_sz;
	}
	public String getJelszo() {
		return jelszo;
	}
	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}
	
	
	public static void regTorles(String felh_nev){
		String sql = "DELETE FROM Felh WHERE felh_nev='"+felh_nev+"'";
		DBControl control = new DBControl();
		try {
			control.delete(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void adatModosit(String felh_nev, String nev, String jelszo,String email,String tel_sz) {
		String sql2 = null;
		String modos = "  ";
		if (!jelszo.isEmpty())
			sql2 = "UPDATE Felh SET jelszo='"+jelszo+"' WHERE felh_nev='"+felh_nev+"'";
		if (!nev.isEmpty()) modos += "nev = '"+nev+"', ";
		if (!email.isEmpty()) modos += "email = '"+email+"', ";
		if (!tel_sz.isEmpty()) modos += "tel_sz = '"+tel_sz+"', ";
		modos = modos.substring(0, modos.length()-2);
		String sql = "UPDATE Felh SET "+modos+" WHERE felh_nev='"+felh_nev+"'";
		
		DBControl control = new DBControl();
		try {
			control.update(sql);
			if (sql2!=null) control.update(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	public static List<Felh> listazas() {
		DBControl control = new DBControl();
		List<Felh> osszes = null;
		String sql = "SELECT * FROM Felh";
		try {
			osszes = control.getUser(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return osszes;
	}
}

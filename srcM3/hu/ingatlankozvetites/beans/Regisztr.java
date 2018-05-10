package hu.ingatlankozvetites.beans;

import hu.ingatlankozvetites.dao.DBControl;

import java.sql.SQLException;

public class Regisztr {
	String felh_nev;
	String jelszo;
	String jelszo_megeros;
	String nev;
	String email;
	String tel_sz;
	
	public static String reg(String felh_nev, String jelszo, String jelszo_megeros, String nev, String email, String tel_sz){
		DBControl control = new DBControl();
		if (ellenorz(felh_nev,jelszo,jelszo_megeros)) {
			String sql = "INSERT INTO Felh ('felh_nev','jelszo','nev','email','tel_sz') VALUES ('"+felh_nev+"','"+jelszo+"','"+nev+"','"+email+"','"+tel_sz+"')";
			try {
				control.insert(sql);
				return "sikeres reg";
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return "sikertelen";
	}
	
	public static boolean ellenorz(String felh_nev,	String jelszo, String jelszo_megeros) {
		DBControl control = new DBControl();
		try {
			//van ilyen user
			if (control.select("Select * FROM Felh WHERE felh_nev='"+felh_nev+"'")) return false;
			//nem egyezo jelszo
			if (!jelszo.equals(jelszo_megeros)) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}

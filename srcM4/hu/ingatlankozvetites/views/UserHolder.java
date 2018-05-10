package hu.ingatlankozvetites.views;

import hu.ingatlankozvetites.beans.Felh;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class UserHolder extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	String felh_nev;
	String nev;
	String email;
	String tel_sz;
	String jelszo;
	boolean admin;
	//fields
	private Label userNameLabel = new Label();
	private Label userFelhNameLabel = new Label();
	private Label isAdminLabel = new Label();
	private Label mailLabel = new Label();
	private Label phoneLabel = new Label();
	
	public UserHolder(Felh data){
		super();
		if (data==null)
			return;
		
		userNameLabel.setValue("Név: "+data.getNev());
		userFelhNameLabel.setValue("Felhasználónév: "+data.getFelh_nev());
		isAdminLabel.setValue("Típus "+(data.isAdmin()?"Admin":"Nem admin"));
		mailLabel.setValue("Mail: "+data.getEmail());
		phoneLabel.setValue("Telefon: "+data.getTel_sz());
		
		this.addComponent(userNameLabel);
		this.addComponent(userFelhNameLabel);
		this.addComponent(isAdminLabel);
		this.addComponent(mailLabel);
		this.addComponent(phoneLabel);
		
	}
	
}

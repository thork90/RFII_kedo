package hu.ingatlankozvetites.views;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import hu.ingatlankozvetites.beans.Ajanlat;

public class PropertyHolder extends VerticalLayout{
	private static final long serialVersionUID = 1L;
	//constants
	public static final boolean MODE_ADMIN=true;
	public static final boolean MODE_USER=false;
	//fields
	private Label propertyNameTextField = new Label();
	private Label propertyDescriptionField = new Label();
	
	public PropertyHolder(Ajanlat data, boolean mode){
		super();
		if (data==null)
			return;
		if (data.getCim() != null){
			propertyNameTextField.setValue(data.getCim());
		}
		else{
			propertyNameTextField.setValue("nincs megadva");
		}
		propertyDescriptionField.setValue(getPropertyDescriptionString(data));
		
		this.addComponent(propertyNameTextField);
		this.addComponent(propertyDescriptionField);
	}
	
	
	private String getPropertyDescriptionString(Ajanlat data){
		String desc="";
		desc+="ár: "+data.getAr()+" Ft; ";
		desc+="cím: "+data.getCim()+"; ";
		desc+="terület: "+data.getTerulet()+" m2; ";
		desc+="eladó: "+booleanToHunString(data.isElado())+"; ";
		desc+="ház: "+booleanToHunString(data.isHaz())+"; ";
		desc+="udvar: "+booleanToHunString(data.isUdvar())+"; ";
		desc+="kert: "+booleanToHunString(data.isKert())+"; ";
		desc+="terasz: "+booleanToHunString(data.isTerasz())+"; ";
		desc+="medence: "+booleanToHunString(data.isMedence())+"; ";
		desc+="erkély: "+booleanToHunString(data.isErkely())+"; ";
		desc+="garázs: "+booleanToHunString(data.isGarazs())+"; ";
		return desc;
	}
	private String booleanToHunString(boolean data){
		return data?"Igen":"Nem";
	}
}

package hu.ingatlankozvetites.views;

import hu.ingatlankozvetites.beans.Ajanlat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class UploadView extends HorizontalLayout implements View, ClickListener{

	private static final long serialVersionUID = 1L;
	private Button saveButton = new Button("Mentés");
	
	VerticalLayout rootLayout=new VerticalLayout();
	private TextField priceField = new TextField("Ár");
	private TextField addressField= new TextField("Cím");
	private TextField dimensionField = new TextField("Terület (m2)");
	private TextField lastModField = new TextField("Utolsó módosítás");
	private TextField agentNameField = new TextField("Hírdető neve");
	//checkboxes
	
	private CheckBox forSaleBox = new CheckBox("Eladó");
	private CheckBox houseBox = new CheckBox("Ház");
	private CheckBox gardenBox = new CheckBox("Udvar");
	private CheckBox yardBox = new CheckBox("Kert");
	private CheckBox teracceBox = new CheckBox("Terasz");
	private CheckBox balkonyBox = new CheckBox("Erkély");
	private CheckBox poolBox = new CheckBox("Medence");
	private CheckBox garageBox = new CheckBox("Garázs");
	private List<CheckBox> checkList = new ArrayList<CheckBox>(){
		private static final long serialVersionUID = 1L;
		{
			add(forSaleBox);
			add(houseBox);
			add(gardenBox);
			add(yardBox);
			add(teracceBox);
			add(balkonyBox);
			add(poolBox);
			add(garageBox);
		}};
	@Override
	public void enter(ViewChangeEvent event) {
		rootLayout.removeAllComponents();
		initView();
		addComponent(rootLayout);
		rootLayout.setSizeFull();
	}
	
	private void initView(){
		HorizontalLayout uplay = new HorizontalLayout();
		
		uplay.addComponent(priceField);
		priceField.setInputPrompt("200 000 Ft");
		uplay.addComponent(addressField);
		addressField.setInputPrompt("6720 Szeged, Próba utca 1000/b");
		uplay.addComponent(dimensionField);
		dimensionField.setInputPrompt("67");
		uplay.setSizeFull();
		uplay.setSpacing(true);
		uplay.setMargin(true);
		
		HorizontalLayout checkBoxesLayout = new HorizontalLayout();
		for (CheckBox box : checkList){
			checkBoxesLayout.addComponent(box);
		}
		checkBoxesLayout.setSizeFull();
		checkBoxesLayout.setSpacing(true);
		checkBoxesLayout.setMargin(true);
		
		
		HorizontalLayout bottomLayout = new HorizontalLayout();
		bottomLayout.addComponent(lastModField);
		lastModField.setEnabled(false);
		SimpleDateFormat sfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		lastModField.setValue(sfdt.format(new Date()));
		bottomLayout.addComponent(agentNameField);
		agentNameField.setEnabled(false);
		agentNameField.setValue("Próba Péter");
		bottomLayout.addComponent(saveButton);
		bottomLayout.setSizeFull();
		bottomLayout.setSpacing(true);
		bottomLayout.setMargin(true);
		bottomLayout.setComponentAlignment(saveButton, Alignment.BOTTOM_CENTER);
		saveButton.addClickListener(this);
		rootLayout.addComponent(uplay);
		rootLayout.addComponent(checkBoxesLayout);
		rootLayout.addComponent(bottomLayout);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton() == saveButton){
			Ajanlat data;
			try {
				data=fetchData();
			}catch(NumberFormatException e){
				Notification.show("Szöveg helyett számot kell megadni!");
				return;
			} catch (Exception e) {
				Notification.show("Minden szöveges mező kitöltése kötelező");
				return;
			}
			saveProperty(data);
			
		}
	}
	private Ajanlat fetchData() throws NumberFormatException,Exception{
		Ajanlat data=new Ajanlat();
		if (priceField.getValue()==null || priceField.getValue().equals(""))
			throw new Exception();
		if (addressField.getValue()==null || addressField.getValue().equals(""))
			throw new Exception();
		if (dimensionField.getValue()==null || dimensionField.getValue().equals(""))
			throw new Exception();
		data.setAr(Integer.parseInt(priceField.getValue()));
		data.setCim(addressField.getValue());
		data.setTerulet(Integer.parseInt(dimensionField.getValue()));
		data.setHirdeto_nev(agentNameField.getValue());
		data.setElado(forSaleBox.getValue());
		data.setErkely(balkonyBox.getValue());
		data.setGarazs(garageBox.getValue());
		data.setHaz(houseBox.getValue());
		data.setKert(gardenBox.getValue());
		data.setMedence(poolBox.getValue());
		data.setTerasz(teracceBox.getValue());
		data.setUdvar(yardBox.getValue());
		return data;
	}
	private void saveProperty(Ajanlat data){
		Ajanlat.felt(0,data.getCim(),data.getTerulet(),
				data.isElado(),data.isHaz(),data.isUdvar(),
				data.isKert(),data.isTerasz(),data.isErkely(),
				data.isMedence(),data.isGarazs(),data.getIdop(),
				data.getHirdeto_nev());
	}
}

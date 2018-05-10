package hu.ingatlankozvetites.views;

import hu.ingatlankozvetites.beans.Ajanlat;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ActAdsLayoutWithFilter extends VerticalLayout implements View, ClickListener{

	private static final long serialVersionUID = 1L;
	private VerticalLayout rootLayout = new VerticalLayout();
	private TextField searchField= new TextField();
	private Button searchButton = new Button("Keresés");
	private VerticalLayout propertListLayout = new VerticalLayout();
	private List<Ajanlat> propertyList=new ArrayList<Ajanlat>();
	boolean mode=false;
	
	private void initView(){
		rootLayout.removeAllComponents();
		HorizontalLayout searchFieldHolder = new HorizontalLayout();
		searchFieldHolder.addComponent(searchField);
		searchField.setInputPrompt("Kereső szöveg");
		searchFieldHolder.addComponent(searchButton);
		searchButton.addClickListener(this);
		searchFieldHolder.setMargin(true);
		searchFieldHolder.setSpacing(true);
		rootLayout.addComponent(searchFieldHolder);
		propertListLayout.setSpacing(true);
		propertListLayout.setMargin(true);
		rootLayout.addComponent(propertListLayout);
		rootLayout.setSpacing(true);
		addComponent(rootLayout);
	}
	
	private void refreshView(){
		propertListLayout.removeAllComponents();
		for (Ajanlat propertyData: propertyList){
			PropertyHolder propHolder = new PropertyHolder(propertyData, mode);
			propertListLayout.addComponent(propHolder);
		}
	}
	@Override
	public void enter(ViewChangeEvent event) {
		mode=((Boolean)VaadinService.getCurrentRequest().getWrappedSession().getAttribute("MODE")) !=null? 
				((Boolean)VaadinService.getCurrentRequest().getWrappedSession().getAttribute("MODE")): false;
		
		initView();
		propertyList = Ajanlat.osszesListaz();
		refreshView();
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton() == searchButton){
			
		}
	}
}

package com.hust.soict.elearning_lannp.client.ui.shared;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.html.Strong;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.Event;
import com.hust.soict.elearning_lannp.shared.model.User;

public class PanelDescription extends Composite {

	private static PanelDescriptionUiBinder uiBinder = GWT
			.create(PanelDescriptionUiBinder.class);
	private Event event;

	interface PanelDescriptionUiBinder extends
			UiBinder<Widget, PanelDescription> {
	}

	public PanelDescription() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField Image avatar;
	@UiField Strong name;
	@UiField Text content;
	@UiField Button btnRemove;
	@UiField Button btnEdit;
	
	public void setEvent(Event event){
		this.event = event;
	}
	
	public void setAvatar(String url){
		avatar.setUrl(url);
	}
	
	public void setName(String name) {
		this.name.setText(name);
	}
	
	public void setContent(String content) {
		this.content.setText(content);
	}
	
	public void setUser(User user) {
		setName(user.getDisplayName());
		setAvatar(user.getAvatar());		
	}
	
	@UiHandler("btnEdit")
	void onBtnEditClick(ClickEvent e){
		
	}
}

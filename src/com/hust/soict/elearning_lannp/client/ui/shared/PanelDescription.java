package com.hust.soict.elearning_lannp.client.ui.shared;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Strong;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.Event;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;
import com.hust.soict.elearning_lannp.shared.model.User;

public class PanelDescription extends Composite {

	private static PanelDescriptionUiBinder uiBinder = GWT.create(PanelDescriptionUiBinder.class);
	private FormInputAbastract form;
	private Event event;
	private int id;
	private String titleDelete;

	interface PanelDescriptionUiBinder extends UiBinder<Widget, PanelDescription> {
	}

	public PanelDescription() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Image avatar;
	@UiField
	Strong name;
	@UiField
	Div content;
	@UiField
	Button btnRemove;
	@UiField
	Button btnEdit;

	public void setAvatar(String url) {
		avatar.setUrl(url);
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public void setContent(String content) {
		this.content.clear();
		HTML html = new HTML(content);
		this.content.add(html);
	}

	public void setUser(User user) {
		setName(user.getDisplayName());
		setAvatar(user.getAvatar());
	}
	
	public void setEvent(Event e){
		this.event = e;
	}

	public void setForm(FormInputAbastract form) {
		this.form = form;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setTitleDelete(String title){
		this.titleDelete = title;
	}

	@UiHandler("btnEdit")
	void onBtnEditClick(ClickEvent e) {
		this.form.show();
	}
	
	@UiHandler("btnRemove")
	void onBtnRemoveClick(ClickEvent e){
		FormDelete form = new FormDelete(event, id);
		form.show();
		form.setTitle(this.titleDelete);
	}
}

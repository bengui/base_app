package com.bengui.baseapp.models;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.bengui.baseapp.utils.Constants;
import com.bengui.baseapp.utils.JSONParcelableObject;

public class Contact implements JSONParcelableObject<Contact>{
	
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String LNAME = "lname";
	private static final String EMAIL = "email";
	private static final String AGE = "age";
	private static final String COMPANY = "company";
	private static final String DESCRIPTION = "description";
	private static final String TAG = Contact.class.getSimpleName() + " - ";
	
	
	private String id;
	private String name;
	private String lname;
	private String email;
	private int age;
	private String company;
	private String description;
	
	public Contact(){
		id = null;
		name = null;
		lname = null;
		email = null;
		age = 0;
		company = null;
		description = null;
	}
	
	public Contact(String id, String name, String lname, String email, int age, String company, String description){
		
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.email = email;
		this.age = age;
		this.company = company;
		this.description = description;
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getJSON() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ID, id);
			jsonObject.put(NAME, name);
			jsonObject.put(LNAME, lname);
			jsonObject.put(EMAIL, email);
			jsonObject.put(AGE, age);
			jsonObject.put(COMPANY, company);
			jsonObject.put(DESCRIPTION, description);
			return jsonObject.toString();
		} catch (JSONException e) {
			Log.e(Contact.class.getSimpleName(), e.getMessage());
			return null;
		}
	}

	@Override
	public Contact parseJSON(String json) {
		try {
			Contact contact = new Contact();
			JSONObject jsonObject = new JSONObject(json);
			
			contact.setId(jsonObject.getString(ID));
			contact.setName(jsonObject.getString(NAME));
			contact.setLname(jsonObject.getString(LNAME));
			contact.setAge(jsonObject.getInt(AGE));
			contact.setEmail(jsonObject.getString(EMAIL));
			contact.setCompany(jsonObject.getString(COMPANY));
			contact.setDescription(jsonObject.getString(DESCRIPTION));
			
			return contact;
		} catch (JSONException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			return null;
		}
	}
	
	

}
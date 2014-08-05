package com.bengui.baseapp.services;

import org.json.JSONException;

public class ServiceException extends JSONException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String message;
	//private ArrayList<String>;
	    

	public ServiceException() { super(""); }

	public ServiceException(String name, String message) {
		super(name);
		this.message = message;
        this.name = name;
	}
	
	public ServiceException(String name, String message, Throwable cause) {
		super(name);
		this.message = message;
        this.name = name;
	}
	
	//public ServiceError(Throwable cause) { super(cause); }
    

    public String getName(){
        return name;
    }
    
    public String getMessage(){
        return message;
    }


}
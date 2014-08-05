package com.bengui.baseapp.services;


public class ServerException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String message;
	//private ArrayList<String>;
	    

	public ServerException() { super(); }

	public ServerException(String name, String message) {
		super(message);
		this.message = message;
        this.name = name;
	}
	
	public ServerException(String name, String message, Throwable cause) {
		super(name, cause);
		this.message = message;
        this.name = name;
	}
	
	public ServerException(Throwable cause) { super(cause); }
    

    public String getName(){
        return name;
    }
    
    public String getMessage(){
        return message;
    }


}
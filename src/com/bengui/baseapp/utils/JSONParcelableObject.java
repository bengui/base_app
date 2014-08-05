package com.bengui.baseapp.utils;

public interface JSONParcelableObject<T> {

	abstract public String getJSON();
	abstract public T parseJSON(String json);
	
}


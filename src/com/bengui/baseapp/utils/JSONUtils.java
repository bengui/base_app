package com.bengui.baseapp.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bengui.baseapp.services.ServiceException;

public abstract class JSONUtils {
	
	//Error attributes
	private static String TAG_ERR = "err";
	private static String TAG_ERR_NAME = "name";
	private static String TAG_ERR_MESSAGE = "message";
	
	/**
	 * Validate if the response of the services are the JSON type
	 * @param response Server response to validate
	 * @throws ServiceException
	 * @throws JSONException
	 */
	public static void validateJsonObjetc(String response) throws ServiceException, JSONException {
		
		JSONObject jsonResponse;
		JSONArray jsonArray;
		
		try{
			jsonResponse = new JSONObject(response);
			
			if ( jsonResponse.has(TAG_ERR) ) {
				
				JSONObject err = (JSONObject) jsonResponse.getJSONObject(TAG_ERR);
				String nameError = err.getString(TAG_ERR_NAME);
				String messageError = err.getString(TAG_ERR_MESSAGE);
	
				throw new ServiceException(nameError, messageError);
				
			}
		}catch(JSONException e){
			
		
			jsonArray = new JSONArray(response);
			if ( jsonArray.getJSONObject(0).has(TAG_ERR) ) {
				
				JSONObject err = (JSONObject) jsonArray.getJSONObject(0).getJSONObject(TAG_ERR);
				String nameError = err.getString(TAG_ERR_NAME);
				String messageError = err.getString(TAG_ERR_MESSAGE);
				
				throw new ServiceException(nameError, messageError);
				
			}
			
		}
		
	}

	
	
}

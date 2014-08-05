package com.bengui.baseapp.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;

import android.util.Log;

import com.bengui.baseapp.utils.Constants;
import com.bengui.baseapp.utils.JSONUtils;
import com.bengui.baseapp.utils.Utils;

public class HttpClient {
	
	private static final String TAG = HttpClient.class.getSimpleName() + " - ";
	
	public String get(String url){
		return get(url, null);
	}
	
	public String get(String url, List<NameValuePair> paramList){		
		
		// Making HTTP request
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        String response = null;
        
        if (paramList != null) {
		
        	for (NameValuePair params : paramList) {
            	httpGet.getParams().setParameter(params.getName(), params.getValue());
    		}
		}
                
		try {
			
	        HttpResponse httpResponse = httpClient.execute(httpGet);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        response = Utils.inputStreamToString(httpEntity.getContent());
	        
	        JSONUtils.validateJsonObjetc(response);

	        
		} catch (UnsupportedEncodingException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			response = null;
        } catch (ClientProtocolException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
        	response = null;
        } catch (IOException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
            response = null;
        } catch (ServiceException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
        	response = null;
		} catch (JSONException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			response = null;
		}
		
		return response;
		
	}
	
	
	
	public String put(String urlSaveUser, String user) {
				
		// Making HTTP request
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPut = new HttpPost(urlSaveUser);
        
        String response = null;
        String finalResponse = null;
        
		try {
			
			StringEntity entity = new StringEntity(user);
			entity.setContentType("application/json;charset=UTF-8");//text/plain;charset=UTF-8
			entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
			
	        httpPut.setEntity(entity);
			
			
	        HttpResponse httpResponse = httpClient.execute(httpPut);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        
	        response = Utils.inputStreamToString(httpEntity.getContent());
	        
	        JSONUtils.validateJsonObjetc(response);
	        
	        finalResponse = response;
	        
		} catch (UnsupportedEncodingException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			finalResponse = null;
        } catch (ClientProtocolException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
        	finalResponse = null;
        } catch (IOException e) {
            Log.e(Constants.LOG_TAG, TAG + e.getMessage());
            finalResponse = null;
        } catch (ServiceException e) {
			Log.e(TAG,e.toString());
			finalResponse = null;
		} catch (JSONException e) {
			Log.e(TAG,e.toString());
			finalResponse = null;
		}
		
		return finalResponse;
	}
	
	public String update(String urlUpdateUser, String user) {
		
		// Making HTTP request
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(urlUpdateUser);
        
        String response = null;
        String finalResponse = null;
        
		try {
			
			StringEntity entity = new StringEntity(user);
			entity.setContentType("application/json;charset=UTF-8");//text/plain;charset=UTF-8
			entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
			
	        httpPost.setEntity(entity);
			
			
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        
	        response = Utils.inputStreamToString(httpEntity.getContent());
	        
	        JSONUtils.validateJsonObjetc(response);
	        
	        finalResponse = response;
	        
		} catch (UnsupportedEncodingException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			finalResponse = null;
        } catch (ClientProtocolException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
        	finalResponse = null;
        } catch (IOException e) {
            Log.e(Constants.LOG_TAG, TAG + e.getMessage());
            finalResponse = null;
        } catch (ServiceException e) {
			Log.e(TAG,e.toString());
			finalResponse = null;
		} catch (JSONException e) {
			Log.e(TAG,e.toString());
			finalResponse = null;
		}
		
		return finalResponse;
	}


	public String delete(String urlDeleteUser, String userId) {
		
		// Making HTTP request
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(urlDeleteUser);
        
        String response = null;
        String finalResponse = null;
        
		try {
			
			StringEntity entity = new StringEntity(userId);
			entity.setContentType("application/json;charset=UTF-8");//text/plain;charset=UTF-8
			entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
			
	        httpPost.setEntity(entity);
			
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        
	        response = Utils.inputStreamToString(httpEntity.getContent());
	        
	        JSONUtils.validateJsonObjetc(response);
	        
	        finalResponse = response;
	        
		} catch (UnsupportedEncodingException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			finalResponse = null;
        } catch (ClientProtocolException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
        	finalResponse = null;
        } catch (IOException e) {
            Log.e(Constants.LOG_TAG, TAG + e.getMessage());
            finalResponse = null;
        } catch (ServiceException e) {
        	Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			finalResponse = null;
		} catch (JSONException e) {
			Log.e(Constants.LOG_TAG, TAG + e.getMessage());
			finalResponse = null;
		}
		
		return finalResponse;
		
	}
	



}
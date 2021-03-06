package com.pathik.flysync;


import android.content.Context;
import android.content.SharedPreferences;

public class DataBase {
	private static SharedPreferences setting;
	private final String NAME = "com.pathik.flysync.setting";
	private static final int VERSION = 5;
	
	

	
	public DataBase(Context context) {
		
		if(setting == null){
			setting = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);			
		}
		
		
		if(setting.getInt("version", 0) != VERSION){
			
			SharedPreferences.Editor editor = setting.edit();
			editor.putInt("version", VERSION);
			
			//username and password
			editor.putString("username", "admin");
			editor.putString("password", "admin");
			
			//selective synchronization
			editor.putBoolean("music", true);
			editor.putBoolean("gallery", true);
			editor.putBoolean("contacts", true);
			editor.putBoolean("call_log", true);
			editor.putBoolean("file", true);
			editor.putBoolean("app", true);
			editor.putBoolean("sms", true);
			
			editor.commit();
		}
	}
	
	public void addString(String key,String value){
		SharedPreferences.Editor editor = setting.edit();
		editor.putString(key, value);
		editor.commit();
	}
	public void addBoolean(String key,boolean value){
		SharedPreferences.Editor editor = setting.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	
	public void addInt(String key,int value){
		SharedPreferences.Editor editor = setting.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	public String getString(String key){
		return setting.getString(key, "");
	}
	
	
	public boolean getBoolean(String key){
		return setting.getBoolean(key, false);
	}
	

	public int getInt(String key){
		return setting.getInt(key, 0);
	}
}

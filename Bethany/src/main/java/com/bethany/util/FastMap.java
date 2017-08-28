package com.bethany.util;

import java.util.HashMap;

public class FastMap extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FastMap(){
	}
	
    public FastMap(String key, Object value){
		this.put(key, value);
	}
	
	public static FastMap fMap(String key,Object value){
		return new FastMap(key,value);
	}
	
	public FastMap putFKV(String key,Object value){
		this.put(key, value);
		return this;
	}
	
	
}

package com.bethany.vo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息类
 */
public class ResMessage implements Serializable{
	

	private static final long serialVersionUID = -5653611917558451335L;
	//成功
	public static int SUCCESS = 0;
	//失败
	public static int FAIL = 1;
	//需要登录
	public static int REQ_LOGIN = 2;

	public static int CHECK_FAIL = 3;
	
	private int res;
	
	private String message;
	
	private Object obj ;

	private Map<String, Object> data = new HashMap<String, Object>();;
	
	public ResMessage(int res, String message){
		this.res=res;
		this.message=message;
	}
	
	public ResMessage(int res, String message, Object obj){
		this.res=res;
		this.message=message;
		this.obj = obj;
	}
	
	public static ResMessage success(){
		return new ResMessage(SUCCESS, "成功!");
	}
	
	public static ResMessage success(String message){
		return new ResMessage(SUCCESS,message);
	}
	
	public static ResMessage fail(){
		return new ResMessage(FAIL, "失败!");
	}

	public static ResMessage fail(String message){
		return new ResMessage(FAIL,message);
	}
	public static ResMessage checkFail(String key,String message){
		return new ResMessage(CHECK_FAIL,message).putData("key",key);
	}
	
	public boolean isSuccess(){
			return SUCCESS == getRes();
	}



	
	
	public ResMessage putData(String key,Object value){
		if(null == data.get(key)){
			data.put(key, value);
			return this;
		}else{
			data.put(key, value);
			return this;
		}
	}


	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	

}

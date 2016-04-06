package com.wechat.lixinwechat.action.userBindAction;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.wechat.lixinwechat.action.ApiBaseAction;


public class userBind extends ApiBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952672370753974717L;
	
	private String result;
	

	
	public String doExec(){
		// 处理跨域请求问题
		super.sethttp(ServletActionContext.getResponse());
		
		// 将前台传来的参数copy到javabean中，方便处理
		HttpServletRequest request = ServletActionContext.getRequest();
	
		
		//用户绑定
		
		
		
		try {
			result=URLDecoder.decode("1", "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}

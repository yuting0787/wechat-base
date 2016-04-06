package com.wechat.lixinwechat.action;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

public class ApiBaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public void sethttp(HttpServletResponse response){
		
		// 处理跨域请求问题
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
	}
}

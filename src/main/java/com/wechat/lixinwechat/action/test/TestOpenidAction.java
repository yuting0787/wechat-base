package com.wechat.lixinwechat.action.test;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.sword.wechat4j.oauth.OAuthManager;
import org.sword.wechat4j.oauth.protocol.get_access_token.GetAccessTokenRequest;
import org.sword.wechat4j.oauth.protocol.get_access_token.GetAccessTokenResponse;

import com.wechat.lixinwechat.action.ApiBaseAction;

import net.sf.json.JSONObject;


public class TestOpenidAction extends ApiBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952672370753974717L;
	
	// 前台对应的参数bean
	private TestInputBean param = new TestInputBean();
	
	private JSONObject result;
	
	public String doExec() throws Exception{
		// 处理跨域请求问题
		super.sethttp(ServletActionContext.getResponse());
		
		// 将前台传来的参数copy到javabean中，方便处理
		HttpServletRequest request = ServletActionContext.getRequest();
		//BeanUtils.populate(param, request.getParameterMap());
		
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		// 取得accessToken
		GetAccessTokenResponse accessToken = OAuthManager.getAccessToken(new GetAccessTokenRequest(code));
		System.out.println(accessToken.getOpenid());
		
		return SUCCESS;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}

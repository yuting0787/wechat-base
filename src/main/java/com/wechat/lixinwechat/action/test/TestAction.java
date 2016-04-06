package com.wechat.lixinwechat.action.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.sword.wechat4j.message.CustomerMsg;
import org.sword.wechat4j.oauth.OAuthManager;
import org.sword.wechat4j.user.UserManager;

import com.wechat.lixinwechat.action.ApiBaseAction;

import net.sf.json.JSONObject;


public class TestAction extends ApiBaseAction{

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
/*		HttpServletRequest request = ServletActionContext.getRequest();
		BeanUtils.populate(param, request.getParameterMap());*/
		
		// 向前台返回值
		TestOutBean testOutBean = new TestOutBean();
		List<String> imageUrl = new ArrayList<String>();
		imageUrl.add("http://image.baidu.com/150309101F7.jpg");
		imageUrl.add("http://image.baidu.com/0.jpg");
		testOutBean.setName("余廷");
		testOutBean.setPassword("yuting0787");
		testOutBean.setImageUrl(imageUrl);

		// 将出力Bean转成json对象
		result = JSONObject.fromObject(testOutBean);// 将list转换为json数组
		
		UserManager userManager = new UserManager();
		
/*		List<Object> userList = userManager.subscriberList();
		if(userList.size() > 0){
			String toUserOpenId = userList.get(0).toString();
			// String content = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0e81c3bee622d60&redirect_uri=http%3A%2F%2Fnba.bluewebgame.com%2Foauth_response.php&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
			String content = 
			CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
			customerMsg.sendText(content);
		}*/
		
		String redirectURI = "http://192.168.1.164:8080/bookinglecture/dist/demos/infinite.html";	
/*		Follwers userList = userManager.subscriberList();
		if(userList.getData().getOpenid().size() > 0){
			String toUserOpenId = userList.getData().getOpenid().get(0).toString();
			// String content = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0e81c3bee622d60&redirect_uri=http%3A%2F%2Fnba.bluewebgame.com%2Foauth_response.php&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
			String content = OAuthManager.generateRedirectURI(redirectURI, "snsapi_userinfo", "test info");
			CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
			customerMsg.sendText(content);
		}*/
		
/*			String toUserOpenId = "o_aBuwce_en6jRvR_XuWS7IAiHCc";
			// String content = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0e81c3bee622d60&redirect_uri=http%3A%2F%2Fnba.bluewebgame.com%2Foauth_response.php&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
			String content = OAuthManager.generateRedirectURI(redirectURI, "snsapi_userinfo", "testinfo");
			CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
			customerMsg.sendText(content);*/

		
		
		return SUCCESS;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}

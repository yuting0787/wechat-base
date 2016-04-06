package com.wechat.lixinwechat.action.authAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.sword.wechat4j.oauth.OAuthManager;
import org.sword.wechat4j.oauth.protocol.get_access_token.GetAccessTokenRequest;
import org.sword.wechat4j.oauth.protocol.get_access_token.GetAccessTokenResponse;

import com.wechat.lixinwechat.action.ApiBaseAction;


public class getAuthDispatch extends ApiBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952672370753974717L;

	private  String Openid;
	private  String result;

	public String doExec() {
		// 处理跨域请求问题
		super.sethttp(ServletActionContext.getResponse());

		// 将前台传来的参数copy到javabean中，方便处理
		HttpServletRequest request = ServletActionContext.getRequest();

		String code = request.getParameter("code");
		String state = request.getParameter("state");

		// OAuthManager oaManager = new OAuthManager();

		GetAccessTokenRequest tokenRequest = new GetAccessTokenRequest(code);
		// System.out.println(code);
		try {

			GetAccessTokenResponse tokenResponse = OAuthManager.getAccessToken(tokenRequest);

			Openid=tokenResponse.getOpenid();
			System.out.println(tokenResponse.getOpenid());
			//用户绑定页面
			if (state.equals("1")) {

				result= "userBind";
			}
			//讲座发表页面
			if (state.equals("2")) {

				result= "lecturePublish";
			}
			//讲座浏览页面
			if (state.equals("3")) {

				result= "lectureView";
			}
			//个人信息页面
			if (state.equals("4")) {

				result= "person";
			}
			// UserManager userManager = new UserManager();
			// Follwers userList = userManager.subscriberList();
			// String toUserOpenId =
			// userList.getData().getOpenid().get(0).toString();
			// CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
			//
			// customerMsg.sendText("您已绑定成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			result= "error";
		}
		return result;

	}

	public String getOpenid() {
		return Openid;
	}

	public void setOpenid(String openid) {
		Openid = openid;
	}

	
}

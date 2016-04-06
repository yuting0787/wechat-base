package com.wechat.lixinwechat.action.JzAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.wechat.lixinwechat.action.ApiBaseAction;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * 讲座信息取得
 * @author tom
 *
 */
public class QueryJzListAction extends ApiBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952672370753974717L;
	
	private JSONArray result;
	
	public String doExec() throws Exception{
		// 处理跨域请求问题
		super.sethttp(ServletActionContext.getResponse());
		
		// 将前台传来的参数copy到javabean中，方便处理
		HttpServletRequest request = ServletActionContext.getRequest();
		String jzTitle = request.getParameter("jzTitle");
		
		// 取得选课信息一览
//		List<JzinfoOutputBean> outputList = tabJzinfoReaddaoMapper.selectByTitle(jzTitle);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		
		// 将出力Bean转成json对象
		result = JSONArray.fromObject(null,jsonConfig);// 将list转换为json数组
		
		return SUCCESS;
	}

	
	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}
}

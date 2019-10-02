package com.internousdev.ecsite.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object>session;
	private String errorMessage;

	public String execute(){
		if(!(loginUserId.equals(""))&& !(loginPassword.equals(""))&& !(userName.equals(""))){
			session.put("loginUserId",loginUserId);
			session.put("loginPassword",loginPassword);
			session.put("userName",userName);
		}else{
			setErrorMessage("ñ¢ì¸óÕÇÃçÄñ⁄Ç™Ç†ÇËÇ‹Ç∑ÅB");
			result=ERROR;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String Password){
		this.loginPassword=loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
	public Map<Stirng,Object>getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}

package com.internousdev.ecsite.action;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private Stirng userName;
	private Map<String,Object>session;
	private UserCreateCompleteDAO userCreateCompleteDAO=new UserCreateCompleteDAO(){

		public String execute() throws SQLException{
			UserCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
					session.get("loginPassword").toString(),
					session.get("userName").toString());
			String result=SUCCESS;
			return result;
		}
		public Stirng getLoginUserId(){
			return loginUserId;
		}
		public void setLoginUserId(Stirng loginUserId){
			this.loginUserId=loginUserId;
		}
		public String getLoginPassword(){
			return loginPassword;
		}
		public void setLoginPassword(Stirng loginPassword){
			this.loginPassword=loginPassword;
		}
		public String getUserName(){
			return userName;
		}
		public void setUserName(Stirng userName){
			this.userName=userName;
		}
		public Map<String,Object>getSession(){
			return this.session;
		}
		@Override
		public void setSession(Map<Stirng,Object>session){
			this.session=session;
		}
	}

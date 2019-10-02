package com.internousdev.ecsite.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();
	public String execute() throws SQLException{
		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());
		String result=SUCCESS;
		return result;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		thia.session=session;
	}
}

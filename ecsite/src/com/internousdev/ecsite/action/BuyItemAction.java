package com.internousdev.ecsite.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private int count;
	private String pay;
	public String execute(){
		String result =SUCCESS;
		session.put("count");
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount*intPrice);
		String payment;
		if(pay.equals("1")){
			payment="Œ»‹à•¥‚¢";
			session.put("pay",payment);
		}else{
			payment="¸Ú¼Þ¯Ä¶°ÄÞ";
			session.put("pay",payment);
		}
		return result;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}

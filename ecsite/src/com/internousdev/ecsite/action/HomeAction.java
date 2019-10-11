package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		// ActionSupportのｸﾗｽからexecute機能の継承
		String result = "login";
		// executeﾒｿｯﾄﾞの戻り値としてﾛｸﾞｲﾝ画面に遷移
		if (session.containsKey("login_user_id")) {
			// ﾛｸﾞｲﾝ画面でidをputした場合にsessionの判定
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result = SUCCESS;
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

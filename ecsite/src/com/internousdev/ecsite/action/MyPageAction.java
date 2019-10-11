package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlag;
	private String message;

	public String execute() throws SQLException {
		if (!session.containsKey("login_user_id")) {
			return ERROR;
		}
		if (deleteFlag == null) {
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
		} else if (deleteFlag.equals("1")) {
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

		if (res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

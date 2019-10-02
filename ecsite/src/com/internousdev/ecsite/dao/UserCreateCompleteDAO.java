package com.internousdev.ecsite.dao;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserCreateCompleteDAO {
	public void createUser(String loginUserId,String loginUserPassword,String userName) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=new Connection();
		DateUtil dateUtil=new DateUtil();
		String sql="INSERT FROM login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?,)";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2,loginUserPassword);
			ps.setString(3,userName);
			ps.setString(4,dateUtil.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			con.close();
		}
	}
}

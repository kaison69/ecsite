package com.internousdev.ecsite.util;

import com.mysql.jdbc.Connection;

public class DBConnector {
	private String driverName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost/ecsite";
	private String user="root";
	private String password="mysql";
	public Connection getConnection(){
		Connection con=null;
		try{
			Class.forName(driverName);
			con=(Connection) DriverManager.getConnection(url,user,password);
			//	蝙句､画鋤縺ｮ�ｽｷ�ｽｬ�ｽｽ�ｾ�繧偵＠縺ｦ縺�繧� String蝙九°繧会ｽｵ�ｾ鯉ｾ橸ｽｼ�ｾ橸ｽｪ�ｽｸ�ｾ�蝙九↓�ｼ�
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return con;
	}
}

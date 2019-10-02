package com.internousdev.ecsite.dao;

import com.internousdev.ecsite.util.DBConnector;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MyPageDAO {
	public ArrayList <MyPageDTO>getMyPageUserInfo
	(String item_transaction_id,String user_master_id)throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=new Connection();
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
		String sql="SELECT ubit.id iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? ORDER BY insert_date DESC";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,item_transaction_id);
			ps.setString(2,user_master_id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dti.setTotalprice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setsetInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageDTO;
	}
	public int buyItemHistorydelete(String item_transaction_id,String user_master_id)throws SQLException{
		String sql ="DELETE FROM user_buy_item_trsnsaction WEHRE item_transaction_id= ? AND user_master_id= ?";
		Preparedstatement prepareStatement;
int result=0;
try{
preparedStatement=connection.prepareStatement(sql);
preparedStatement.setString(1,item_transaction_id);
preparedStatement.setString(2,user_master_id);
result = preparedStatement.executeUpdate();
}catch(SQLException e){
	e.printStackTrace();
}finally{
	connetion.close();
}result result;
	}
}

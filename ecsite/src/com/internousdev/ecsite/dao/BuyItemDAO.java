package com.internousdev.ecsite.dao;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.mysql.jdbc.PreparedStatement;

public class BuyItemDAO {
	public BuyItemDTO getBuyItemInfo(){
		DBConnector db= new DBConnector();
		BuyItemDTO buyItemDTO=new BuyItemDTO();

		String sql="SELECT id,item_name,item_price FROM item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				BuyItemDTO.setId(rs.getInt("id"));
				BuyItemDTO.setItemName(rs.getString("item_name"));
				BuyItemDTO.setItemPrice(rs.getString("item_price"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
}

package com.internousdev.ecsite.util;

import org.apache.struts2.components.Date;

public class DateUtil {
	public String getDate(){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
}

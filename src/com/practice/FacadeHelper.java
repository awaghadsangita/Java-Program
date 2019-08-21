package com.practice;

import java.sql.Connection;

public class FacadeHelper {
	public void generateReport(String DBtype,String reportType,String tablename)
	{
		switch(DBtype)
		{
		case "MySql":
				Connection con=MysqlHelper.getConnection();
				MysqlHelper obj=new MysqlHelper();
				switch(reportType)
				{
				case "PDF":
						obj.generatePDFReport(tablename, con);
						break;
				case "Text":
						obj.generateTextReport(tablename, con);
						break;
				}
				break;
		case "Oracle":
			Connection conn=OracleHelper.getConnection();
			OracleHelper obj1=new OracleHelper();
			switch(reportType)
			{
			case "PDF":
				obj1.generatePDFReport(tablename, conn);
				break;
			case "Text":
				obj1.generatePDFReport(tablename, conn);
				break;
			}
				
		}
	}
}

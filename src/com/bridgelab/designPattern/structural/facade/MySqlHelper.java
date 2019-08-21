package com.bridgelab.designPattern.structural.facade;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class MySqlHelper {
	public static Connection getMySqlDBConnection() throws SQLException{
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "root", "admin");
		return conn;
	}
	public void generateMySqlPDFReport(String tableName, Connection con) throws FileNotFoundException, DocumentException, SQLException{
		Document doc=new Document();
		File file=new File("/home/user/Sangita/Java_Projects/jsonFiles/AddressBook/address.pdf");
		PdfWriter.getInstance(doc, new FileOutputStream(file));
		String query="Select * from "+tableName;
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next())
		{
			String record=rs.getInt(0)+":"+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4);
			Paragraph p=new Paragraph();
			p.add(record);
			doc.add(p);
		}
		doc.close();
		System.out.println("PDF Report is Created");
	}
	
	public void generateMySqlTextReport(String tableName, Connection con) throws SQLException, IOException{
		String query="Select * from "+tableName;
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		File file=new File("/home/user/Sangita/Java_Projects/jsonFiles/AddressBook/address.pdf");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		while(rs.next())
		{
			String record=rs.getInt(0)+":"+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4);
			bw.write(record+"\n");
		}
		bw.close();
	}
	
}

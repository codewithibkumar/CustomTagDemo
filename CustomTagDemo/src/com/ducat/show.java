package com.ducat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class show extends TagSupport{

		String roll;
		JspWriter out;
				
		public String getRoll() {
			return roll;
		}
		public void setRoll(String roll) {
			this.roll = roll;
		}
		@Override
		public int doStartTag() throws JspException {
			out = pageContext.getOut();
			try {
				out.println(new java.util.Date());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Load the driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
	//Get Connection with dbms
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/anshuldb","root","pass");
	// create or execute statement	
		PreparedStatement ps = con.prepareStatement("select roll,name, course, fee from students where roll=?");
		ps.setInt(1, Integer.parseInt(roll));
		ResultSet rs =ps.executeQuery();
	//processed returned data
		while(rs.next())
		{
			out.print(rs.getInt(1)+"\t");
			out.print(rs.getString(2)+"\t");
			out.print(rs.getString(3)+"\t");
			out.println(rs.getFloat(4)+"<br/>");
		}
	//connection close
		con.close();
			}catch(ClassNotFoundException e) {}
			catch(java.sql.SQLException e) {
				try {
					out.println(e+"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// TODO Auto-generated method stub
			return super.doStartTag();
		}
		@Override
		public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
		}
		
}

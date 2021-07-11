package com.student.manage;

import java.sql.DriverManager;
import java.sql.Connection;
public class ConnectionProvider {
	static Connection con;
         public static Connection createConnection()
         {
        	 
        	 //Load the driver
        	 try {
        		 Class.forName("org.postgresql.Driver");
        		 
        		 String user="postgres";
        		 String password="1wdpfoafii#R";
        		 String url="jdbc:postgresql://localhost:5432/student_manage";
        		 //create connection
        		 con = DriverManager.getConnection(url,user,password);
        		 
        		 
        		 
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	 
        	 return  con;
        	 
        	 
        	 
        	 
         }
}

package com.student.manage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class StudentDao {
	
	public  static boolean insertStudentToDB(Student st)
	{
		
		boolean flag=false;
		
		try
		{
		Connection con = ConnectionProvider.createConnection();
		String q = "insert into students(sname,sphone,scity) values(?,?,?)";
		
		//Dynamic query --prepared statement
		
	PreparedStatement pstmt=	con.prepareStatement(q);
		//set the values of parameter
	pstmt.setString(1,st.getStudentName());
	pstmt.setString(2,st.getStudentPhone());
	pstmt.setString(3,st.getStudentCity());
	
	//Execute
	pstmt.executeUpdate();
	flag=true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		//Insert to Db
		try
		{
		Connection con = ConnectionProvider.createConnection();
		String q = "delete from students where sid=?";
		
		
		//Dynamic query --prepared statement
		
	PreparedStatement pstmt=	con.prepareStatement(q);
		//set the values of parameter
	pstmt.setInt(1,userId);
	
	//Execute
	pstmt.executeUpdate();
	flag=true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}

	public static void showAllStudents() {
		// TODO Auto-generated method stub
		
		
		
		try
		{
		Connection con = ConnectionProvider.createConnection();
		String q = "select * from students";
		
		
		Statement statement = con.createStatement();
		 ResultSet set =statement.executeQuery(q);
		 
		 while(set.next())
		 {
			 int id=set.getInt(1);
			 String name = set.getString(2);
			 String phone =set.getString(3);
			 String city = set.getString(4);
			 System.out.println(" Id "+id +" Name "+ name+" Phone "+ phone+ " City "+city);
			 
			 
		 }
	
	//Execute
	

		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}

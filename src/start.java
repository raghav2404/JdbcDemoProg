import java.io.*;

import com.student.manage.Student;
import com.student.manage.StudentDao;
public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
            System.out.println("Welcome");
	
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
	//Connect Driver
	
	while(true)
	{
		
		System.out.println("Press 1 to Add student");;
		System.out.println("Press 2 to Delete student");
		System.out.println("Press 3 to Display student");
		System.out.println("Press 4 to Exit ");
		int c=Integer.parseInt(br.readLine());
		if(c==1)
		{
			
			System.out.println("Enter user name:");
			String name=br.readLine();
			
			System.out.println("Enter user phone:");
			String phone=br.readLine();
			System.out.println("Enter user city:");
			String city=br.readLine();
			
			//Create student object
			Student st = new Student(name,phone,city);
		boolean ans=	StudentDao.insertStudentToDB(st);
		if(ans)
		{
			System.out.println("Successfully Added");
		}
		else
		{
			System.out.println("Something Went Wrong");
		}
			System.out.println(st);
			
			
			
		}
		else if(c==2)
		{
			System.out.println("Enter User Id to Delete");
			int userId = Integer.parseInt(br.readLine());
			boolean f=StudentDao.deleteStudent(userId);
			if(f)
			{
				System.out.println("Successfully Deleted User with id "+userId);
			}
			else
			{
				System.out.println("Something Went Wrong");
			}
				
				
			
		}
		else if(c==3)
		{
			StudentDao.showAllStudents();
		}
		else if(c==4)
		{
			break;
		}
		else
		{
			
		}
			
	
	System.out.println("Thank you for using this App");
	
	
	}
	

}
}

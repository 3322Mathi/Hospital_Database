package HospitalDynamicCreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HospitalMainblock {
	static Scanner sc= new Scanner(System.in);
	
	
	public static void insertion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		
		PreparedStatement ps= con.prepareStatement("insert into patient values(?, ?, ?, ?, ?, ?)");
		
		System.out.println("enter the patient id");
		int pid= sc.nextInt();
		System.out.println("enter the name");
		String name= sc.next();
		System.out.println("enter the age");
		int age= sc.nextInt();
		System.out.println("enter the gender");
		String gender= sc.next();
		System.out.println("enter the disease name");
		String disease= sc.next();
		System.out.println("enter the admission date");
		String date= sc.next();
		
		ps.setInt(1,pid);
		ps.setString(2,name);
		ps.setInt(3,age);
		ps.setString(4,gender);
		ps.setString(5,disease);
		ps.setString(6,date);
		
		int res=ps.executeUpdate();
		if(res==0)
		{
			System.out.println("cannot value to insert");
		}
		else
		{
			System.out.println("value is inserted successfully");
		}
		con.close();
		
		
	}
	
	
	public static void updation() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		PreparedStatement ps= con.prepareStatement("update patient set disease=?, admission_date=? where name=?");
		
		
		System.out.println("enter the disease name");
		String disease= sc.next();
		System.out.println("enter the admission date");
		String date= sc.next();
		System.out.println("could you give a name for reference.");
		String name= sc.next();
	
		ps.setString(1,disease);
		ps.setString(2,date);
		ps.setString(3,name);
		
		int res=ps.executeUpdate();
		if(res==0)
		{
			System.out.println("cannot value to be update");
		}
		else
		{
			System.out.println("value is update successfully");
		}
		con.close();
		
		
	}
	
	
	public static void displayall() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		Statement st= con.createStatement();
		ResultSet display=st.executeQuery("select * from patient");
		while(display.next())
		{
			System.out.println(display.getInt("pid")+" "+display.getString("name")+" "+
		display.getInt("age")+" "+display.getString("gender")+" "+display.getString("disease")+" "+
					display.getString("admission_date"));
		}
		con.close();
		
	}
	
	public static void displayAgeWise()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		Statement st= con.createStatement();
		ResultSet display=st.executeQuery("select name , disease from patient where age>=45");
		while(display.next())
		{
			System.out.println(display.getString("name")+" "+display.getString("disease")+" ");
		}
		con.close();
	}
	
	public static void displayAdmissionWise() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		PreparedStatement ps= con.prepareStatement("select * from patient where admission_date=?");
		System.out.println("enter the admission date for retrive a data");
		String date= sc.next();
		ps.setString(1,date);
		ResultSet res= ps.executeQuery();
		while(res.next())
		{
			System.out.println(res.getInt("pid")+" "+res.getString("name")+" "+
		res.getInt("age")+" "+res.getString("gender")+" "+res.getString("disease")+" "+
					res.getString("admission_date"));
		}
		con.close();
		
		
	}
	
	public static void dynamicdelete()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		PreparedStatement ps= con.prepareStatement("delete from patient where pid=?");
		System.out.println("enter the patient id for deletion the details");
		int pid= sc.nextInt();
		ps.setInt(1,pid);
		int res= ps.executeUpdate();
		if(res==0)
		{
			System.out.println("unsuccessful");
		}
		else {
			System.out.println("deleted the records successfully");
		}
		
		con.close();
		
	}
	
	
	public static void upateAdmissionDate() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Mathi@3322");
		PreparedStatement ps= con.prepareStatement("update patient set admission_date=? where gender=?");
		System.out.println("enter the admission date");
		String date= sc.next();
		System.out.println("enter the gender");
		String gender= sc.next();
		
		ps.setString(1,date);
		ps.setString(2,gender);
		
		int res= ps.executeUpdate();
		 
		if(res==0)
		{
			System.out.println("no update");
		}
		else {
			System.out.println("updated");
		}
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// insertion();
		//updation();
		//displayall();
		//displayAgeWise();
		//displayAdmissionWise();
		//dynamicdelete();
		//upateAdmissionDate();
		
		
		
		
		
		

	}

}

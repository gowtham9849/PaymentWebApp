package payment.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import payment.web.entity.User;

public class UserDao {
	Connection con;
	public UserDao() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PaymentWabApp", "root", "root");
	}
	
	public int RegisterDb(User u) throws SQLException {
		String DatePattern = "yyyy-mm-dd";
		
		SimpleDateFormat format = new SimpleDateFormat(DatePattern);
			Statement st = con.createStatement();
			
			String egQuery ="insert into User(FirstName,LastName,PhoneNo,EMailId,DateOfBirth,Address,PassWord,CurrWalletBalance)"
					+ "values('"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getPhno()+"','"+u.getEmailId()+"','"+format.format(u.getDateOfBirth())+"',"
							+ "'"+u.getAddress()+"','"+u.getPassWord()+"','"+0+"')";
			return st.executeUpdate(egQuery);			
	}
	
	public int LoginDb(String Phno,String Password) throws SQLException{


		String lquery = "SELECT PhoneNo, PassWord, UserId FROM User WHERE PhoneNo = ? AND PassWord = ?";
	    PreparedStatement pstmt = con.prepareStatement(lquery);
	    
	    pstmt.setString(1, Phno);
	    pstmt.setString(2, Password);
	    
	    ResultSet res = pstmt.executeQuery();
	    if(res.next()) {
	    	System.out.println(res.getInt("UserId"));
	    	return res.getInt("UserId");
	    	
	    }
	    
	        return 0;
	}
	
	public String UserNameDb(int userID)  throws SQLException {
		
			Statement st = con.createStatement();
			String userq = "Select FirstName,LastName from User where UserId = '"+userID+"'";
			ResultSet res =  st.executeQuery(userq);
			
			if(res.next()) {
		    	
			    	System.out.println(res.getString("FirstName")+" " + res.getString("LastName"));
			    	return res.getString("FirstName")+"" + res.getString("LastName");
		    	
		    }
			
			return null;
	}

	
}
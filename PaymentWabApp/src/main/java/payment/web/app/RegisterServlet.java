package payment.web.app;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import payment.web.dao.UserDao;
import payment.web.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String Phno = request.getParameter("phno");
		String Email = request.getParameter("email");
		String Dob = request.getParameter("dob");
		String Address = request.getParameter("address");
		String Password = request.getParameter("password");
		String ConfirmPassWord = request.getParameter("Confirm");
		String DatePattern = "yyyy-mm-dd";
		
		SimpleDateFormat format = new SimpleDateFormat(DatePattern);
		
		Date dateb = null;
		try {
		  dateb = format.parse(Dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Password.equals(ConfirmPassWord)) {
		User u = new User();
		u.setFirstName(Fname);
		u.setLastName(Lname);
		u.setPhno(Phno);
		u.setEmailId(Email);
		u.setDateOfBirth(dateb);
		u.setAddress(Address);
		u.setPassWord(ConfirmPassWord);
		
		try {
			UserDao udb = new UserDao();
			if(udb.RegisterDb(u)>0) {
				response.setContentType("text/html");
				response.getWriter().write("REGISTRATION SUCCESSFULL");
				RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
				rd.include(request, response);
			}else{
				response.setContentType("text/html");
				response.getWriter().write("Please Enter The Correct Password");
				RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	}
	

}
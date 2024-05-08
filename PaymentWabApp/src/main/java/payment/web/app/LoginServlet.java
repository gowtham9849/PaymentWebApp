package payment.web.app;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionContext;
import payment.web.dao.BankAcctUserDao;
import payment.web.dao.UserDao;
import payment.web.entity.BankAccount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Phno = request.getParameter("Phno");
		String PassWord = request.getParameter("PassWord");
		System.out.println(Phno+PassWord);
		int UserId = 0;
		String UserName =null;
		try {
			UserDao db = new UserDao();
			BankAcctUserDao Bdb = new BankAcctUserDao();
			UserId = db.LoginDb(Phno, PassWord);
			 UserName = db.UserNameDb(UserId);
			 System.out.println(UserName);
			 HttpSession session = request.getSession();
				session.setAttribute("user", UserId);
				session.setAttribute("name", UserName);
			if(UserId != 0) {
				
				
				request.setAttribute("name", UserName);
				request.setAttribute("UserId", UserId);
				
				List<BankAccount> balist = Bdb.BankAcctList(UserId);
				session.setAttribute("Balist", balist);
				
				Cookie ck = new Cookie("UserName",UserName);
				response.addCookie(ck);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/Dashboard.jsp");
				rd.forward(request, response);
				
			}else {
//				HttpSession session = request.getSession();
				response.setContentType("text/html");
				response.getWriter().write("LOGIN FAILED PLEASE ENTER THE CREDENTIALS");
				RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
				rd.include(request, response);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
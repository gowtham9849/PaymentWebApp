package payment.web.app;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class BankAcctListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BankAcctListServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession rd = request.getSession();
		int UserId = (int) request.getAttribute("UserId");
		
		
		
		
		
	}

}

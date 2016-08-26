package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Election")
public class PresidentServlet extends HttpServlet{
	
	int TERM_MAX = 44;

	private PresidentDAO presidentDAO;
	@Override
	public void init() throws ServletException {
		presidentDAO = new PresidentFileDAO(getServletContext());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int term = Integer.parseInt(req.getParameter("term"));
		if (!((term > TERM_MAX ) || (term < 1))){
			req.setAttribute("thepresident", presidentDAO.getPresident(term));
			req.setAttribute("theterm", term);
			req.getRequestDispatcher("/results.jsp").forward(req, resp);;
		}
		else System.out.println("Invalid Term, please correct your input!");
	}	
}

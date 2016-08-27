package web;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
		String button = req.getParameter("button");
		HttpSession session = req.getSession();
		
		if (button.equals("Submit")){
			int term = Integer.parseInt(req.getParameter("term"));
			
			if (!((term > TERM_MAX) || (term < 1))){
				session.setAttribute("term", term);
				req.setAttribute("thepresident", presidentDAO.getPresident(term));
				req.setAttribute("thefact", presidentDAO.getFact(term));
			}
			req.setAttribute("theterm", term);
		}
		if (button.equals("Next")){
			int oldterm = (int)(session.getAttribute("term"));
			int newterm = oldterm + 1;
			if (newterm > TERM_MAX) newterm = 1;
			session.setAttribute("term", newterm);
			req.setAttribute("thepresident", presidentDAO.getPresident(newterm));
			req.setAttribute("thefact", presidentDAO.getFact(newterm));
		}
		if (button.equals("Previous")){
			int oldterm = (int)(session.getAttribute("term"));
			int newterm = oldterm - 1;
			if (newterm <  1) newterm = TERM_MAX;
			session.setAttribute("term", newterm);
			req.setAttribute("thepresident", presidentDAO.getPresident(newterm));
			req.setAttribute("thefact", presidentDAO.getFact(newterm));
		}
		
		req.getRequestDispatcher("/results.jsp").forward(req, resp);
	}
}	

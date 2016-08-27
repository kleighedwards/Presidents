package web;

import java.io.IOException;

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
	
		String termString = "1";
		int term = 0;
		String button = req.getParameter("button");
		HttpSession session = req.getSession();
		
		// if new session, and the Submit button is pressed without term input, get President Washington
		if(session.getAttribute("term") == null || session.getAttribute("term") == ""){
			session.setAttribute("term", "1");
		}
		
		if (button.equals("Submit")){
			
			// read user input for President's term
			termString = req.getParameter("term");
			
			// if Submit button is pressed with empty field, get the last selected President
			if(termString == null || termString == ""){
				term =  ((int)(session.getAttribute("term")));
			}
			
			// if input is not an Integer, get the last selected President
			try {
				term = Integer.parseInt(termString);}
			catch (IllegalArgumentException e){
				term =  ((int)(session.getAttribute("term")));				
			}
			
			// if term is in range, get the President
			if (!((term > TERM_MAX) || (term < 1))){
				session.setAttribute("term", term);
				req.setAttribute("thepresident", presidentDAO.getPresident(term));
				req.setAttribute("thefact", presidentDAO.getFact(term));
			}
			
			req.setAttribute("term", term);
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
		
		// if term is too big or small, continue to JSP for error message
		req.getRequestDispatcher("/results.jsp").forward(req, resp);
	}
}	

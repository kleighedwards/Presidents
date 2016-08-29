package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Election")
public class PresidentServlet extends HttpServlet {

	int TERM_MAX = 44;

	private PresidentDAO presidentDAO;

	@Override
	public void init() throws ServletException {
		presidentDAO = new PresidentFileDAO(getServletContext());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<President> filtered = null;
		String termString = "1";
		int term = 0;
		int oldterm = 0;
		int newterm = 0;
		String button = req.getParameter("button");
		HttpSession session = req.getSession();

		// if new session, and the Submit button is pressed without term input,
		// default to first president in list
		if (session.getAttribute("term") == null || session.getAttribute("term") == "") {
			session.setAttribute("filter", "All Presidents");
			session.setAttribute("term", 1);
			session.setAttribute("termD", 1);
			session.setAttribute("termR", 1);
			session.setAttribute("termW", 1);
			session.setAttribute("termI", 1);
			session.setAttribute("termF", 1);
		}

		// read user input for President's term
		String fbutton = req.getParameter("Filter");
		if (fbutton == null){
			session.setAttribute("filter", "All Presidents");
			fbutton = "All Presidents";
		}

		// Filtered Lists
		switch (fbutton) {
		case ("All Presidents"): {
			filtered = presidentDAO.filter(presidentDAO.getPresidents(), (p) -> p.getNumber() > 0);
			session.setAttribute("filter", "All Presidents");
			break;
		}
		case ("Democrats"): {
			filtered = presidentDAO.filter(presidentDAO.getPresidents(), (p) -> p.getParty().contains("Democrat"));
			session.setAttribute("filter", "Democrats");
			oldterm = term = (Integer) (session.getAttribute("termD"));
			break;
		}
		case ("Republicans"): {
			filtered = presidentDAO.filter(presidentDAO.getPresidents(), (p) -> p.getParty().contains("Republican"));
			session.setAttribute("filter", "Republicans");
			oldterm = term = (Integer) (session.getAttribute("termR"));
			break;
		}
		case ("Whigs"): {
			filtered = presidentDAO.filter(presidentDAO.getPresidents(), (p) -> p.getParty().contains("Whig"));
			session.setAttribute("filter", "Whigs");
			oldterm = term = (Integer) (session.getAttribute("termW"));
			break;
		}
		case ("Independents"): {
			filtered = presidentDAO.filter(presidentDAO.getPresidents(), (p) -> p.getParty().contains("Independent"));
			session.setAttribute("filter", "Independents");
			oldterm = term = (Integer) (session.getAttribute("termI"));
			break;
		}
		case ("Federalists"):
			filtered = presidentDAO.filter(presidentDAO.getPresidents(), (p) -> p.getParty().contains("Federalist"));
			session.setAttribute("filter", "Federalists");
			oldterm = term = (Integer) (session.getAttribute("termF"));
		}

		// Filtered Actions
		switch (fbutton) {
			case ("Democrats"):
			case ("Republicans"):
			case ("Whigs"):
			case ("Independents"):
			case ("Federalists"): {
				int listSize = filtered.size();
				if (button.equals("Submit")) {
	
					// if term is in range, get the President
					if (!((term > listSize) || (term < 1))) {
						req.setAttribute("thepresident", filtered.get(term - 1));
						req.setAttribute("thefact", presidentDAO.getFact(filtered.get(term - 1).getNumber()));
					}
	
					req.setAttribute("term", term);
				}
	
				if (button.equals("Next")) {
					newterm = oldterm + 1;
					if (newterm > listSize)
						newterm = 1;
					switch (fbutton) {
						case ("Democrats"):
							session.setAttribute("termD", newterm);
							break;
						case ("Republicans"):
							session.setAttribute("termR", newterm);
							break;
						case ("Whigs"):
							session.setAttribute("termW", newterm);
							break;
						case ("Independents"):
							session.setAttribute("termI", newterm);
							break;
						case ("Federalists"):
							session.setAttribute("termF", newterm);
					}
					req.setAttribute("thepresident", filtered.get(newterm - 1));
					req.setAttribute("thefact", presidentDAO.getFact(filtered.get(newterm - 1).getNumber()));
				}
	
				if (button.equals("Previous")) {
					newterm = oldterm - 1;
					if (newterm < 1)
						newterm = listSize;
					switch (fbutton) {
						case ("Democrats"):
							session.setAttribute("termD", newterm);
							break;
						case ("Republicans"):
							session.setAttribute("termR", newterm);
							break;
						case ("Whigs"):
							session.setAttribute("termW", newterm);
							break;
						case ("Independents"):
							session.setAttribute("termI", newterm);
							break;
						case ("Federalists"):
							session.setAttribute("termF", newterm);
					}
					req.setAttribute("thepresident", filtered.get(newterm - 1));
					req.setAttribute("thefact", presidentDAO.getFact(filtered.get(newterm - 1).getNumber()));
				}
	
				break;
			}
			case ("All Presidents"): {
				termString = req.getParameter("term");
	
				if (button.equals("Submit")) {
	
					// if Submit button is pressed with empty field, get the last
					// selected President
					if (termString == null || termString == "") {
						oldterm = (Integer) (session.getAttribute("term"));
						if (oldterm == 0) {
							session.setAttribute("term", 1);
							termString = req.getParameter("term");
						}
					}
	
					// if input is not an Integer, get the last selected President
					try {
						term = Integer.parseInt(termString);
					} catch (IllegalArgumentException e) {
						term = (Integer) (session.getAttribute("term"));
					}
	
					// if term is in range, get the President
					if (!((term > TERM_MAX) || (term < 1))) {
						session.setAttribute("term", term);
						req.setAttribute("thepresident", filtered.get(term - 1));
						req.setAttribute("thefact", presidentDAO.getFact(filtered.get(term - 1).getNumber()));
					}
	
					req.setAttribute("term", term);
				}
	
				if (button.equals("Next")) {
					oldterm = (Integer) (session.getAttribute("term"));
					newterm = oldterm + 1;
					if (newterm > TERM_MAX)
						newterm = 1;
					session.setAttribute("term", newterm);
					req.setAttribute("thepresident", filtered.get(newterm - 1));
					req.setAttribute("thefact", presidentDAO.getFact(filtered.get(newterm - 1).getNumber()));
				}
	
				if (button.equals("Previous")) {
					oldterm = (Integer) (session.getAttribute("term"));
					newterm = oldterm - 1;
					if (newterm < 1)
						newterm = TERM_MAX;
					session.setAttribute("term", newterm);
					req.setAttribute("thepresident", filtered.get(newterm - 1));
					req.setAttribute("thefact", presidentDAO.getFact(filtered.get(newterm - 1).getNumber()));
				}
	
				break;
			}
		}

		// if term is too big or small, continue to JSP for error message
		req.getRequestDispatcher("/results.jsp").forward(req, resp);
	}
}
package web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentFileDAO implements PresidentDAO {
	private static final String filename1 = "WEB-INF/presidents.csv";
	private static final String filename2 = "WEB-INF/funfacts.csv";
	private ServletContext servletContext;
	private List<President> presidents;
	private List<Fact> facts;
	

	public PresidentFileDAO(ServletContext context) {
		servletContext = context;
		presidents = new ArrayList<>();
		loadPresidentsFromFile();
		facts = new ArrayList<>();
		loadFactsFromFile();
	}
	
	public List<President> getPresidents() {
		return presidents;
	}
	
	public List<Fact> getFacts() {
		return facts;
	}
	
	public President getPresident(int term) {
		return this.presidents.get(term-1);
	}
	
	public Fact getFact(int term) {
		return this.facts.get(term-1);
	}
	

	private void loadPresidentsFromFile() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		InputStream is = servletContext.getResourceAsStream(filename1);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
			    int number = Integer.parseInt(tokens[0].trim());
			    String fname = tokens[1].trim();
			    String mname = tokens[2].trim();
			    String lname = tokens[3].trim();
			    int[] termArray = getTerms(tokens[4].trim());
			    String party = tokens[5].trim();
			    presidents.add(new President(number, fname, mname, lname, termArray[0], termArray[1], party));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		for(President index: presidents){
			System.out.println(index);
		}
	}
	
	private void loadFactsFromFile() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		InputStream is = servletContext.getResourceAsStream(filename2);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(":");
			    int number = Integer.parseInt(tokens[0].trim());
			    System.out.println("token[0]: " + number);
			    String statement = tokens[1].trim();
			    System.out.println("token[1]: " + statement);
			    facts.add(new Fact(number, statement));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		for(Fact index: facts){
			System.out.println(index);
		}
	}

	private int[] getTerms(String terms) {
		// The terms are separated by a dash
		String[] termTokens = terms.split("-");
		int startTerm = Integer.parseInt(termTokens[0]);
		int endTerm = Integer.parseInt(termTokens[1]);
		return new int[] { startTerm, endTerm };
	}

	@Override
	public String toString() {
		return "PresidentFileDAO [presidents=" + presidents + "]";
	}
	
}

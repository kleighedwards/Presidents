package web;

public class Fact {
	private int number;
	private String statement;

	public Fact (int number, String statement) {
		this.number = number;
		this.statement = statement;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Override
	public String toString() {
		return "Fact [number=" + number + ", statement=" + statement + "]";
	}
	
}

package web;

public class President {
	private int number;
	private String firstName;
	private String middleName;
	private String lastName;
	private int startTerm;
	private int endTerm;
	private String party;

	public President(int number, String firstName, String middleName,
			String lastName, int startTerm, int endTerm, String party) {
		super();
		this.number = number;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.startTerm = startTerm;
		this.endTerm = endTerm;
		this.party = party;
	}

	public int getNumber() {
		Short k = new Short((short)9);
		String s = null;
//		System.out.println(s + null);
		label: if(true) {
//			System.out.println("break label");
			break label; //this is valid
			}
		switch(1){
			case 1:{
			}
//			default:
		}
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getOrdinal() {
		int term = this.number;
		
	    String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
	    switch (term % 100) {
	    case 11:
	    case 12:
	    case 13:
	        return term + "th";
	    default:
	        return term + sufixes[term % 10];

	    }
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getStartTerm() {
		return startTerm;
	}

	public void setStartTerm(int startTerm) {
		this.startTerm = startTerm;
	}

	public int getEndTerm() {
		return endTerm;
	}

	public void setEndTerm(int endTerm) {
		this.endTerm = endTerm;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return number + " " + firstName + " " + middleName + " " + lastName + " " + startTerm + "-" + endTerm + "-" + party;
	}
}
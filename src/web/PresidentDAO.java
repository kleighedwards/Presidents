package web;

import java.util.ArrayList;
import java.util.List;

public interface PresidentDAO {
	public List<President> getPresidents();
	public President getPresident(int term);
	public List<Fact> getFacts();
	public Fact getFact(int term);
}

package web;

import java.util.List;
import java.util.function.Predicate;

public interface PresidentDAO {
	public List<President> getPresidents();
	public President getPresident(int term);
	public List<Fact> getFacts();
	public Fact getFact(int term);
	public List<President> filter(List<President> presidents,
			Predicate <President> predicate);
}

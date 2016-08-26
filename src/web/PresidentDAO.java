package web;

import java.util.ArrayList;
import java.util.List;

public interface PresidentDAO {
	public List<President> getPresidents();
	public President getPresident(int term);
	
}

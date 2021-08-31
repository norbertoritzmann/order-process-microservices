package common;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Entry> entries;

	private UUID userID;

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(final List<Entry> entries) {
		this.entries = entries;
	}

	public UUID getUserID() {
		return userID;
	}

	public void setUserID(final UUID userID) {
		this.userID = userID;
	}
}

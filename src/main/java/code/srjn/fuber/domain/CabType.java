package code.srjn.fuber.domain;

/**
 * enum for type of cabs
 * 
 * @author Srajan
 *
 */
public enum CabType {
	ALL("all"), NORMAL("normal"), PINK("pink");

	private String type;

	private CabType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return type;
	}

}

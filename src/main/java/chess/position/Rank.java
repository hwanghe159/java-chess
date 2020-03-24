package chess.position;

public enum Rank {
	ONE("1"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8");

	private final String name;

	Rank(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

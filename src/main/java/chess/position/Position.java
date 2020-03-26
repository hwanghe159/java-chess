package chess.position;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position {

    private static final Map<String, Position> CACHE = new HashMap<>();

    static {
        //        Arrays.stream(File.values())
        //                .map(file -> Arrays.stream(Rank.values())
        //                        .map(rank -> CACHE.put(getKey(file, rank), new Position(file, rank))));
        for (File file : File.values()) {
            for (Rank rank : Rank.values()) {
                CACHE.put(getKey(file, rank), new Position(file, rank));
            }
        }
    }

    private final File file;
    private final Rank rank;

    private Position(File file, Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    public static Position of(File file, Rank rank) {
        return CACHE.get(getKey(file, rank));
    }

    public static Position of(String key) {
        return CACHE.get(key);
    }

    private static String getKey(File file, Rank rank) {
        return file.getName() + rank.getName();
    }

    public static List<Position> findDiagonalTrace(Position start, Position end) {
        return null;
    }

    public boolean isStraight(Position other) {
        if (this.file == other.file && this.rank == other.rank) {
            return false;
        }
        return this.file == other.file || this.rank == other.rank;
    }

    public boolean isDiagonal(Position other) {
        return isSameSum(other) || isSameDifference(other);
    }

    public boolean isSameSum(Position other) {
        return this.getFileNumber() + this.getRankNumber() == other.getFileNumber() + other.getRankNumber();
    }

    public boolean isSameDifference(Position other) {
		return this.getFileNumber() - this.getRankNumber() == other.getFileNumber() - other.getRankNumber();
    }

    public boolean isNotDiagonal(Position other) {
        return !isDiagonal(other);
    }

    public boolean isNotStraight(Position other) {
        return !isStraight(other);
    }

    public boolean isSameRank(Position other) {
        return this.rank == other.rank;
    }

    public File getFile() {
        return this.file;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getFileNumber() {
        return this.file.getNumber();
    }

    public int getRankNumber() {
        return this.file.getNumber();
    }
}

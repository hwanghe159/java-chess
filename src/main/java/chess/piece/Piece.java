package chess.piece;

import chess.position.Position;

import java.util.List;

public abstract class Piece {
    protected final Team team;
    protected final String symbol;

    public Piece(Team team, String symbol) {
        this.team = team;
        this.symbol = team.isBlack() ? symbol.toUpperCase() : symbol.toLowerCase();
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void updateHasMoved() {
        //TODO:이동여부
    }

    public boolean isSameTeam(Piece piece) {
        return this.team == piece.team;
    }

    public boolean isSameTeam(Team team) {
        return this.team == team;
    }

    public boolean isNotSameTeam(Team turn) {
        return !isSameTeam(turn);
    }

    public abstract boolean isInvalidMovementWithoutConsideringOtherPieces(Position source, Position target);

    public abstract List<Position> movePathExceptSourceAndTarget(Position source, Position target);
}

package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

public class Queen extends ChessFigure {
    public Queen(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        //TODO: how does Queen can move on chess board?
        return false;
    }
}

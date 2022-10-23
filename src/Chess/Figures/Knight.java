package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2658' : '\u265e', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        //TODO: how does Knight can move on chess board?
        return false;
    }
}

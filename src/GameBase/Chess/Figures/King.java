package GameBase.Chess.Figures;

import GameBase.Chess.ChessFigure;
import GameBase.Base.Coordinate;

public class King extends ChessFigure {
    public King(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2654' : '\u265a', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        if (Math.abs(from.getX() - coordinateTo.getX()) <= 1 && Math.abs(from.getY() - coordinateTo.getY()) <= 1) {
            return true;
        } else {
            return false;
        }
    }
}

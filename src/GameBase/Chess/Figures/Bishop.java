package GameBase.Chess.Figures;

import GameBase.Chess.ChessFigure;
import GameBase.Base.Coordinate;

public class Bishop extends ChessFigure {
    public Bishop(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2657' : '\u265d', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        if (Math.abs(coordinateTo.getX() - from.getX()) == Math.abs(coordinateTo.getY() - from.getY())) {
            return true;
        } else {
            return false;
        }
    }
}

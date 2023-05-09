package GameBase.Chess.Figures;

import GameBase.Chess.ChessFigure;
import GameBase.Base.Coordinate;
import GameBase.Chess.ChessGame;

public class Rook extends ChessFigure {
    public Rook(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2656' : '\u265c', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate to) {
        boolean isStepX = from.getY() == to.getY();
        boolean isStepY = from.getX() == to.getX();
        return isStepX ^ isStepY;
    }
}

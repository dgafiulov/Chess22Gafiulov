package GameBase.Chess.Figures;

import GameBase.Base.Coordinate;
import GameBase.Chess.ChessFigure;

public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2658' : '\u265e', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate to) {
        //TODO: how does Knight can move on chess board?
        Coordinate from = this.from;
        return (Math.abs(from.getX() - to.getX()) == 1 && Math.abs(from.getY() - to.getY()) == 3) ||
                (Math.abs(from.getX() - to.getX()) == 3 && Math.abs(from.getY() - to.getY()) == 1);
    }
}

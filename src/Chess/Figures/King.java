package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

public class King extends ChessFigure {
    public King(boolean colorIsWhite, Coordinate coordinateFrom) {
        super(colorIsWhite, colorIsWhite ? '\u2654' : '\u265a', coordinateFrom);
    }

    @Override
    public boolean canMove(Coordinate coordinateTo) {
        //TODO: how does King can move on chess boardR?
        return false;
    }
}

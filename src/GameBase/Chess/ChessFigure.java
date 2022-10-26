package GameBase.Chess;

import GameBase.Base.Coordinate;
import GameBase.Base.Figure;

public abstract class ChessFigure extends Figure {

    public ChessFigure(boolean colorIsWhite, char symbol, Coordinate coordinateFrom) {
        super(colorIsWhite, symbol, coordinateFrom);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }


}

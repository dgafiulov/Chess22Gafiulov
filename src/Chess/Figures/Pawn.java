package Chess.Figures;

import Chess.Base.Coordinate;
import Chess.ChessFigure;

public class Pawn extends ChessFigure {

    boolean isFirstStep;

    public Pawn(boolean colorIsWhite, Coordinate coordinate) {
        super(colorIsWhite, colorIsWhite ? '\u2659' : '\u265f', coordinate);
        this.isFirstStep = true;
    }


    @Override
    public boolean canMove(Coordinate coordinateTo) {
        //TODO: how does Pawn can move on chess board?
        if (colorIsWhite) {
            if (isFirstStep) {
                if (coordinateFrom.getX() == coordinateTo.getX()
                        && (coordinateTo.getY() - coordinateFrom.getY() == 2
                        || coordinateTo.getY() - coordinateFrom.getY() == 1)) {
                    isFirstStep = false;
                    return true;
                } else return false;

            } else {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && coordinateTo.getY() - coordinateFrom.getY() == 1;
            }
        } else {
            if (isFirstStep) {
                if (coordinateFrom.getX() == coordinateTo.getX()
                        && (coordinateFrom.getY() - coordinateTo.getY() == 2
                        || coordinateFrom.getY() - coordinateTo.getY() == 1)) {
                    isFirstStep = false;
                    return true;
                } else return false;
            } else {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && coordinateFrom.getY() - coordinateTo.getY() == 1;
            }
        }
    }
}
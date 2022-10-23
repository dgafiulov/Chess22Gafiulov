package Chess.Figures;

import Chess.ChessFigure;
import Chess.Base.Coordinate;

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
                return coordinateFrom.getX() == coordinateTo.getX()
                        && (coordinateTo.getY() - coordinateFrom.getY() == 2
                        || coordinateTo.getY() - coordinateFrom.getY() == 1);
            } else {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && coordinateTo.getY() - coordinateFrom.getY() == 1;
            }
        } else {
            if (isFirstStep) {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && (coordinateFrom.getY() - coordinateTo.getY() == 2
                        || coordinateFrom.getY() - coordinateTo.getY() == 1);
            } else {
                return coordinateFrom.getX() == coordinateTo.getX()
                        && coordinateFrom.getY() - coordinateTo.getY() == 1;
            }
        }
    }
}
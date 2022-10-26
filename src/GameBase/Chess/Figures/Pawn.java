package GameBase.Chess.Figures;

import GameBase.Base.Coordinate;
import GameBase.Chess.ChessFigure;

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
                if (from.getX() == coordinateTo.getX()
                        && (coordinateTo.getY() - from.getY() == 2
                        || coordinateTo.getY() - from.getY() == 1)) {
                    isFirstStep = false;
                    return true;
                } else return false;

            } else {
                return from.getX() == coordinateTo.getX()
                        && coordinateTo.getY() - from.getY() == 1;
            }
        } else {
            if (isFirstStep) {
                if (from.getX() == coordinateTo.getX()
                        && (from.getY() - coordinateTo.getY() == 2
                        || from.getY() - coordinateTo.getY() == 1)) {
                    isFirstStep = false;
                    return true;
                } else return false;
            } else {
                return from.getX() == coordinateTo.getX()
                        && from.getY() - coordinateTo.getY() == 1;
            }
        }
    }
}
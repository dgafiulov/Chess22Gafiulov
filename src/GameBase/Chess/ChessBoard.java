package GameBase.Chess;

import GameBase.Base.Board;
import GameBase.Base.Coordinate;
import GameBase.Base.Movable;
import GameBase.Chess.Figures.*;

import java.util.Arrays;

public class ChessBoard extends Board {
    private static final int chessFieldSize;

    static {
        chessFieldSize = 8;
    }

    private static ChessBoard instance;


    private ChessBoard() {
        this.field = new ChessFigure[chessFieldSize][chessFieldSize];
        for (Movable[] cf : field) Arrays.fill(cf, null);

    }

    public static ChessBoard getInstance() {
        if (instance == null) instance = new ChessBoard();
        return instance;
    }

    private void resetField() {
        for (Movable[] cf : field) Arrays.fill(cf, null);
    }

    public void newField() {
        this.resetField();
        // white
        field[0][0] = new Rook(true, new Coordinate(0, 0));
        field[0][1] = new Knight(true, new Coordinate(1, 0));
        field[0][2] = new Bishop(true, new Coordinate(2, 0));
        field[0][3] = new Queen(true, new Coordinate(3, 0));
        field[0][4] = new King(true, new Coordinate(4, 0));
        field[0][5] = new Bishop(true, new Coordinate(5, 0));
        field[0][6] = new Knight(true, new Coordinate(6, 0));
        field[0][7] = new Rook(true, new Coordinate(7, 0));
        for (int i = 0; i < chessFieldSize; i++)
            field[1][i] = new Pawn(true, new Coordinate(i, 1));
        //black
        field[7][0] = new Rook(false, new Coordinate(0, 7));
        field[7][1] = new Knight(false, new Coordinate(1, 7));
        field[7][2] = new Bishop(false, new Coordinate(2, 7));
        field[7][3] = new Queen(false, new Coordinate(3, 7));
        field[7][4] = new King(false, new Coordinate(4, 7));
        field[7][5] = new Bishop(false, new Coordinate(5, 7));
        field[7][6] = new Knight(false, new Coordinate(6, 7));
        field[7][7] = new Rook(false, new Coordinate(7, 7));
        for (int i = 0; i < chessFieldSize; i++)
            field[6][i] = new Pawn(false, new Coordinate(i, 6));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" |A|B|C|D|E|F|G|H\n").append("-----------------\n");
        for (int i = 0; i < chessFieldSize; i++) {
            sb.append(8 - i);
            for (int j = 0; j < chessFieldSize; j++)
                sb.append("|").append(
                        field[chessFieldSize - 1 - i][j] != null ? field[chessFieldSize - 1 - i][j] : " "
                );
            sb.append("\n-----------------\n");
        }
        sb.append(" |A|B|C|D|E|F|G|H\n").append("-----------------\n");
        return sb.toString();
    }

    public boolean canMove(Coordinate from, Coordinate to, int stepCounter) {
        if (field[from.getY()][from.getX()] == null) return false;
        else {
            ChessFigure tempFrom = (ChessFigure) field[from.getY()][from.getX()];
            ChessFigure tempTo = (ChessFigure) field[to.getY()][to.getX()];
            System.out.println("from = " + from);
            System.out.println("Ffrom = " + tempFrom);
            boolean destIsOk; //checks if destination point is empty or has opposite color
            if (tempTo == null) {
                destIsOk = true;
            } else {
                if (tempFrom.isColorIsWhite() != tempTo.isColorIsWhite()) {
                    destIsOk = true;
                } else {
                    destIsOk = false;
                }
            }
            if ((stepCounter % 2 == 1) == tempFrom.isColorIsWhite()) {
                switch (tempFrom.getClass().getSimpleName()) {
                    case "Bishop":
                        if (tempFrom.canMove(to)) {
                            if (isLineEmpty(from, to)) {
                                return destIsOk;
                            }
                        }
                        return false;
                    case "King":
                        if (tempFrom.canMove(to)) {
                            return destIsOk;
                        } else {
                            return false;
                        }
                    case "Queen":
                        if (tempFrom.canMove(to)) {
                            if (isLineEmpty(from, to)) {
                                return destIsOk;
                            }
                        }
                    case "Rook":
                        if (tempFrom.canMove(to)) {
                            Coordinate fc = new Coordinate(from.getX(), from.getY());
                            Coordinate tc = new Coordinate(to.getX(), to.getY());
                            if (isLineEmpty(fc, tc)) {
                                return destIsOk;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    case "Knight":
                        if (tempFrom.canMove(to))
                            return destIsOk;
                        else return false;
                    case "Pawn":
                        if (tempFrom.canMove(to))
                            if (tempTo == null) return from.getX() == to.getX();
                            else
                                return tempFrom.isColorIsWhite() != tempTo.isColorIsWhite() && from.getX() != to.getX();
                        else return false;
                    default:
                        return false;
                }
            } else {
                return false;
            }
        }
    }

    public void move(Coordinate from, Coordinate to) {
        ((ChessFigure) field[from.getY()][from.getX()]).moveTo(to);
        field[to.getY()][to.getX()] = field[from.getY()][from.getX()];
        field[from.getY()][from.getX()] = null;
    }

    public boolean isLineEmpty(Coordinate from, Coordinate to) {
        int c1;
        int c2;
        if (from.getX() == to.getX() && from.getY() != to.getY()) {
            if (to.getY() > from.getY()) {
                c1 = from.getY();
                c2 = to.getY();
            } else {
                c1 = to.getY();
                c2 = from.getY();
            }

            for (int i = c1 + 1; i < c2; i++) {
                if (field[i][from.getX()] != null) {
                    return false;
                }
            }
            return true;
        } else if (from.getY() == to.getY() && from.getX() != to.getX()) {
            if (to.getY() > from.getY()) {
                c1 = from.getX();
                c2 = to.getX();
            } else {
                c1 = to.getX();
                c2 = from.getX();
            }

            for (int i = c1 + 1; i < c2; i++) {
                if (field[from.getY()][i] != null) {
                    return false;
                }
            }
            return true;
        } else if (Math.abs(to.getX() - from.getX()) == Math.abs(to.getY() - from.getY())) {
            int c1x;
            int c1y;
            int c2x;
            int c2y;

            int coefx;
            int coefy;

            if (to.getX() >= from.getX()) {
                c1x = from.getX();
                c2x = to.getX();
                coefx = 1;
            } else {
                c1x = to.getX();
                c2x = from.getX();
                coefx = -1;
            }

            if (to.getY() >= from.getY()) {
                c1y = from.getY();
                c2y = to.getY();
                coefy = 1;
            } else {
                c1y = to.getY();
                c2y = from.getY();
                coefy = -1;
            }

            if (Math.abs(c2x - c1x) == Math.abs(c2y - c1y)) {
                for (int i = 1; i < c2x - c1x; i++) {
                    System.out.println("current coordinate is " + from.getY() + (i * coefy) + " " + from.getX() + (i * coefx));
                    if (field[(from.getY() + (i * coefy))][(from.getX() + (i * coefx))] != null) {
                        System.out.println("coefx " + coefx);
                        System.out.println("coefy " + coefy);
                        System.out.println("not empty is " + (from.getY() + (i * coefy)) + " " + (from.getX() + (i * coefx)));
                        System.out.println(field[from.getY() + (i * coefy)][from.getX() + (i * coefx)]);
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

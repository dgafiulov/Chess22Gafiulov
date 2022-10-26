package GameBase.Base;

public abstract class Figure implements Movable {

    protected boolean isOnBoard;  // true = onBoard
    protected char symbol;
    protected Coordinate from;
    protected boolean colorIsWhite; // true = white, false = black

    public Figure(boolean colorIsWhite, char symbol, Coordinate from) {
        this.colorIsWhite = colorIsWhite;
        this.isOnBoard = true;
        this.symbol = symbol;
        this.from = from;
    }

    public void move(Coordinate to) {
        this.from = to;
    }

    public boolean isColorIsWhite() {
        return colorIsWhite;
    }
}

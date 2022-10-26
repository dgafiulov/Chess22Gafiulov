package GameBase.Base;

import java.util.Arrays;

public class Board {
    protected Figure[][] field;
    private final int sizeX;
    private final int sizeY;

    /**
     * @param sizeX - size of X-Axis field
     * @param sizeY - size of Y-Axis field
     */
    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.field = new Figure[sizeY][sizeX];
        for (Figure[] f : field) {
            Arrays.fill(f, null);
        }
    }

    public void resetField() {
        this.field = new Figure[sizeY][sizeX];
        for (Figure[] f : field) {
            Arrays.fill(f, null);
        }
    }
}
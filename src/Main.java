import Chess.Base.Coordinate;
import Chess.Figures.Pawn;

public class Main {
    public static void main(String[] args) {
        Pawn p1, p2;
        p1 = new Pawn(true, new Coordinate(1, 1));
        p2 = new Pawn(false, new Coordinate(1, 7));
        System.out.println(p1);
        Coordinate goTo1,goTo2;
        goTo1 = new Coordinate(1, 3);
        if (p1.canMove(goTo1))
            p1.move(goTo1);
        System.out.println(p1);
        goTo1 = new Coordinate(1, 5);
        if (p1.canMove(goTo1))
            p1.move(goTo1);
        System.out.println(p1);
        goTo1 = new Coordinate(1, 4);
        if (p1.canMove(goTo1))
            p1.move(goTo1);
        System.out.println(p1);
        System.out.println(p2);
        goTo2 = new Coordinate(1, 5);
        if (p2.canMove(goTo2))
            p2.move(goTo2);
        System.out.println(p2);
        goTo2 = new Coordinate(1, 3);
        if (p2.canMove(goTo2))
            p1.move(goTo2);
        System.out.println(p2);
        goTo2 = new Coordinate(1, 4);
        if (p2.canMove(goTo2))
            p2.move(goTo2);
        System.out.println(p2);
    }
}
package GameBase.Chess;

import GameBase.Base.Coordinate;

import java.util.Scanner;

public class ChessGame {
    private final ChessBoard board;
    public static ChessGame instance;

    private ChessGame() {
        board = ChessBoard.getInstance();
    }

    public static ChessGame getInstance() {
        if (instance == null) instance = new ChessGame();
        return instance;
    }

    public void newGame() {
        boolean isEndGame = false;
        board.newField();
        int step = 1;
        Coordinate from = new Coordinate(1, 1);
        Coordinate to = new Coordinate(1, 2);
        while (!isEndGame) {
            System.out.println("Press \"exit\" to stop game!");
            String exit = (new Scanner(System.in)).nextLine().toLowerCase();
            if (exit.equals("exit")) {
                System.out.println("Thank you for game! Bye!!! Bye!!!");
                isEndGame = true;
            } else {
                //TODO something
                System.out.println("your turn is: " + exit);
                System.out.println(board);
                if (board.canMove(from, to))
                    board.move(from, to);
                from = to;
                to = new Coordinate(1, to.getY() + step);
            }
        }
    }
}
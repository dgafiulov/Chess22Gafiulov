package GameBase.Game;

import GameBase.Chess.ChessGame;

public class Main {

    public static void main(String[] args) {
        ChessGame chess = ChessGame.getInstance();
        chess.newGame();
    }
}
package controller;
import model.*;
import rule.RuleChecker;
import ui.ConsoleUI;

public class GameController {
    private Board board;
    private Player[] players;
    private int currentTurn;
    private RuleChecker ruleChecker;
    private ConsoleUI ui;

    public void startGame() {
        board = new Board(5); // 15x15 caro
        players = new Player[] {
            new HumanPlayer("Player 1", 'X'),
            new HumanPlayer("Player 2", 'O') // hoặc AIPlayer
        };
        ruleChecker = new RuleChecker();
        ui = new ConsoleUI();

        boolean gameOver = false;
        while (!gameOver) {
            ui.displayBoard(board);
            Player current = players[currentTurn];
            Move move = current.makeMove(board);
            board.updateCell(move);

            if (ruleChecker.isWinningMove(board, move)) {
                ui.displayWinner(current);
                gameOver = true;
            } else if (board.isFull()) {
                ui.displayDraw();
                gameOver = true;
            } else {
                currentTurn = 1 - currentTurn;
            }
        }
    }
}

package controller;

import model.*;
import rule.RuleChecker;
import ui.BoardPanel;
import javax.swing.*;

public class GameController {
    private Board board;
    private Player[] players;
    private int currentTurn;
    private RuleChecker ruleChecker;
    private BoardPanel boardPanel;

    private boolean gameOver = false;

    public void startGame() {
        board = new Board(15);
        players = new Player[] {
            new HumanPlayer("Player 1", 'X'),
            new HumanPlayer("Player 2", 'O')
        };
        ruleChecker = new RuleChecker();

        // Tạo GUI
        boardPanel = new BoardPanel(board, this);
        JFrame frame = new JFrame("Caro Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(boardPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        currentTurn = 0;
    }

    // Nhận click từ BoardPanel
    public void handleClick(int row, int col) {
        if (gameOver) return;

        if (!board.isCellEmpty(row, col)) {
            JOptionPane.showMessageDialog(null, "Ô đã được đánh rồi!");
            return;
        }

        Player current = players[currentTurn];
        Move move = new Move(row, col, current);
        board.updateCell(move);
        boardPanel.refresh();

        if (ruleChecker.isWinningMove(board, move)) {
            JOptionPane.showMessageDialog(null, current.getName() + " thắng rồi!");
            gameOver = true;
        } else if (board.isFull()) {
            JOptionPane.showMessageDialog(null, "Hòa rồi!");
            gameOver = true;
        } else {
            currentTurn = 1 - currentTurn;
        }
    }
}

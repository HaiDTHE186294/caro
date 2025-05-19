package model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, char symbolChar) {
        super(name, symbolChar);
    }

    @Override
    public Move makeMove(Board board) {
        int row, col;
        do {
            System.out.printf("%s, enter your move (row col): ", name);
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (board.getCell(row, col).getState() != CellState.EMPTY);
        return new Move(row, col, this);
    }
}

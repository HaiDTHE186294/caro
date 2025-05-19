package model;

import java.util.Random;

public class AIPlayer extends Player {
    private Random random = new Random();

    public AIPlayer(String name, char symbolChar) {
        super(name, symbolChar);
    }

    @Override
    public Move makeMove(Board board) {
        int size = board.getSize();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (board.getCell(row, col).getState() != CellState.EMPTY);
        System.out.println(name + " chose: " + row + " " + col);
        return new Move(row, col, this);
    }
}

package rule;

import model.*;

public class RuleChecker {
    private static final int WIN_COUNT = 3;

    public boolean isWinningMove(Board board, Move move) {
        int[][] directions = {
            {0, 1}, {1, 0}, {1, 1}, {1, -1}
        };
        for (int[] dir : directions) {
            int count = 1;
            count += countDirection(board, move, dir[0], dir[1]);
            count += countDirection(board, move, -dir[0], -dir[1]);
            if (count >= WIN_COUNT)
                return true;
        }
        return false;
    }

    private int countDirection(Board board, Move move, int dRow, int dCol) {
        int count = 0;
        int row = move.getRow() + dRow;
        int col = move.getCol() + dCol;
        CellState symbol = move.getPlayer().getSymbol();
        while (row >= 0 && row < board.getSize() &&
               col >= 0 && col < board.getSize() &&
               board.getCell(row, col).getState() == symbol) {
            count++;
            row += dRow;
            col += dCol;
        }
        return count;
    }
}

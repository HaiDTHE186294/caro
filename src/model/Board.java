package model;

public class Board {
    private Cell[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int r = 0; r < size; r++)
            for (int c = 0; c < size; c++)
                grid[r][c] = new Cell(r, c, CellState.EMPTY);
    }

    public boolean isFull() {
        for (Cell[] row : grid)
            for (Cell cell : row)
                if (cell.getState() == CellState.EMPTY)
                    return false;
        return true;
    }

    public void updateCell(Move move) {
        grid[move.getRow()][move.getCol()].setState(move.getPlayer().getSymbol());
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }

    public void display() {
        // Simple console-based board rendering
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                System.out.print(cell.getState().getChar() + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col].getState() == CellState.EMPTY;
    }
}

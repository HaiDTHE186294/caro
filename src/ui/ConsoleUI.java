package ui;

import model.Board;
import model.Cell;
import model.CellState;

public class ConsoleUI {

    public void displayBoard(Board board) {
        int size = board.getSize();

        // In dòng đầu tiên: tiêu đề cột
        System.out.print("   ");
        for (int col = 0; col < size; col++) {
            System.out.printf(" %2d ", col);
        }
        System.out.println();

        // In các hàng
        for (int row = 0; row < size; row++) {
            System.out.printf(" %2d", row); // đánh số hàng

            for (int col = 0; col < size; col++) {
                Cell cell = board.getCell(row, col);
                String symbol = switch (cell.getState()) {
                    case X -> "X";
                    case O -> "O";
                    default -> " ";
                };
                System.out.printf("| %s ", symbol);
            }

            System.out.println("|");

            // In dòng phân cách
            System.out.print("   ");
            for (int col = 0; col < size; col++) {
                System.out.print("----");
            }
            System.out.println("-");
        }
    }

    public void displayWinner(model.Player winner) {
        System.out.println("\n=====================");
        System.out.println("🎉 " + winner.getName() + " wins!");
        System.out.println("=====================\n");
    }

    public void displayDraw() {
        System.out.println("\n=====================");
        System.out.println("🤝 It's a draw!");
        System.out.println("=====================\n");
    }
}

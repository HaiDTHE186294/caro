package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Board;
import model.CellState;
import controller.GameController;

public class BoardPanel extends JPanel {
    private static final int CELL_SIZE = 40;
    private Board board;
    private GameController controller;

    public BoardPanel(Board board, GameController controller) {
        this.board = board;
        this.controller = controller;

        setPreferredSize(new Dimension(board.getSize() * CELL_SIZE, board.getSize() * CELL_SIZE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = e.getX() / CELL_SIZE;
                int row = e.getY() / CELL_SIZE;
                controller.handleClick(row, col);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = board.getSize();

        // Vẽ lưới bàn cờ
        g.setColor(Color.BLACK);
        for (int i = 0; i <= size; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, size * CELL_SIZE);
            g.drawLine(0, i * CELL_SIZE, size * CELL_SIZE, i * CELL_SIZE);
        }

        // Vẽ ký hiệu từ mỗi CellState
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                CellState state = board.getCell(r, c).getState();
                char symbol = state.getChar();

                if (!state.isEmpty()) {
                    FontMetrics fm = g.getFontMetrics();
                    int textWidth = fm.charWidth(symbol);
                    int textHeight = fm.getAscent();

                    int x = c * CELL_SIZE + (CELL_SIZE - textWidth) / 2;
                    int y = r * CELL_SIZE + (CELL_SIZE + textHeight) / 2 - 4;

                    g.drawString(String.valueOf(symbol), x, y);
                }
            }
        }
    }

    public void refresh() {
        repaint();
    }
}

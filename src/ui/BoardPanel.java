package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Board;
import model.Move;
import model.Player;
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
        for (int i = 0; i <= size; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, size * CELL_SIZE); // dọc
            g.drawLine(0, i * CELL_SIZE, size * CELL_SIZE, i * CELL_SIZE); // ngang
        }

        // Vẽ các dấu X, O
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char ch = board.getCell(r, c).getState().getChar();
                if (ch != '\0') {
                    if (ch == 'X') {
                        g.setColor(Color.RED);
                        g.drawLine(c * CELL_SIZE + 5, r * CELL_SIZE + 5,
                                   (c+1) * CELL_SIZE - 5, (r+1) * CELL_SIZE - 5);
                        g.drawLine((c+1) * CELL_SIZE - 5, r * CELL_SIZE + 5,
                                   c * CELL_SIZE + 5, (r+1) * CELL_SIZE - 5);
                    } else if (ch == 'O') {
                        g.setColor(Color.BLUE);
                        g.drawOval(c * CELL_SIZE + 5, r * CELL_SIZE + 5,
                                   CELL_SIZE - 10, CELL_SIZE - 10);
                    }
                }
            }
        }
    }

    public void refresh() {
        repaint();
    }
}

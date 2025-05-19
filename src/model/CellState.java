package model;

public enum CellState {
    EMPTY('·'),
    X('X'),
    O('O');

    private final char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getChar() {
        return symbol;
    }
}

package model;

public abstract class Player {
    protected String name;
    protected CellState symbol;

    public Player(String name, char symbolChar) {
        this.name = name;
        this.symbol = (symbolChar == 'X') ? CellState.X : CellState.O;
    }

    public String getName() { return name; }
    public CellState getSymbol() { return symbol; }

    public abstract Move makeMove(Board board);
}

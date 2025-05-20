package model;

public abstract class Player {
    protected String name;
    protected CellState symbol;
    

    public Player(String name, char symbolChar) {
        this.name = name;
        this.symbol = new CellState(symbolChar); // tạo ký hiệu mới
    }

    public String getName() {
        return name;
    }

    public CellState getSymbol() {
        return symbol;
    }
}

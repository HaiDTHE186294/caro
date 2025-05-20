package model;

public class CellState {
    public static final CellState EMPTY = new CellState(' '); // mặc định

    private final char symbol;

    public CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getChar() {
        return symbol;
    }
    
     public boolean isEmpty() {
        return symbol == '\0';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CellState other = (CellState) obj;
        return this.symbol == other.symbol;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(symbol);
    }
}

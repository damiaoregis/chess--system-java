package boardgame;

public class Position {
    private int row;
    private int colun;

    public Position(int row, int colun) {
        this.row = row;
        this.colun = colun;
    }

    public int getColun() {
        return colun;
    }

    public void setColun(int colun) {
        this.colun = colun;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return row + ", " +colun;
    }
}

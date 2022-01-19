public class Cell{

    private int liveNeighbours = 0;



    private Integer column;



    private Integer row;
    private boolean isLive;

    private Cell(int column, int row, boolean isLive){
        this.column =column;
        this.row=row;
        this.isLive = isLive;
    }


    public static Cell createLive(int column, int row){
        Cell liveCell = new Cell(column,row, true);
        return liveCell;
    }


    public static Cell createDead(int column, int row){
        Cell deadCell = new Cell(column,row, false);
        return deadCell;
    };

    public static Cell createSame(Cell cell){
        int column = cell.getColumn();
        int row = cell.getRow();
        boolean isLive = cell.getIsLive();
        Cell sameCell = new Cell(column,row, isLive);
        return sameCell;
    };

    public int getLiveNeighbours() {
        return liveNeighbours;
    }

    public void setLiveNeighbours(int liveNeighbours) {
        this.liveNeighbours = liveNeighbours;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(boolean live) {
        isLive = live;
    }

}


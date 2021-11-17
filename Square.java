public class Square{
    private final int row, col;
    private SquareType sqType;
 
    public Square(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
 
    public SquareType getSquareType()
    {
        return sqType;
    }
 
    public void setSquareType(SquareType sqType)
    {
        this.sqType = sqType;
    }
 
    public int getRow()
    {
        return row;
    }
 
    public int getCol()
    {
        return col;
    }
}
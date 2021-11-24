public class Square{
    private final int row, col;
    private SquareType square_type = SquareType.EMPTY;
 
    public Square(int row, int col){
        this.row = row;
        this.col = col;
    }
 
    public SquareType getSquareType(){
        return square_type;
    }
 
    public void setSquareType(SquareType square_type){
        this.square_type = square_type;
    }
 
    public int getRow(){
        return row;
    }
 
    public int getCol(){
        return col;
    }
}

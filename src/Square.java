package src;

// square class associated with each coordinate on the board
public class Square{

    ///////////////// ATTRIBUTES /////////////////
    
    // stores coordinates of the square
    private final int row, col;
    // by default, a square is set empty
    private SquareType square_type = SquareType.EMPTY;
 
    ///////////////// CONSTUCTOR /////////////////
    
    public Square(int row, int col){
        this.row = row;
        this.col = col;
    }
 
    ///////////////// METHODS /////////////////
    
    // getter and setter for square type
    public SquareType getSquareType(){
        return square_type;
    }
    public void setSquareType(SquareType square_type){
        this.square_type = square_type;
    }
 
    // getters for coordinates
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}

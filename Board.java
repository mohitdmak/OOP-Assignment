public class Board {
 
    final int ROW_COUNT, COL_COUNT;
    private Square[][] squares;
 
    public Board(int rowCount, int columnCount){
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;
 
        squares = new Square[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++){
            for (int column = 0; column < COL_COUNT; column++){
                squares[row][column] = new Square(row, column);
            }
        }
    }
 
    public Square[][] getSquares(){
        return squares;
    }
 
    public void setSquares(Square[][] squares){
        this.squares = squares;
    }
 
    public void generateFood(){
        System.out.println("Going to generate food");
        int row;
        int column;
        while(true){
            row = (int)(Math.random() * ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);
            if(squares[row][column].getSquareType()!=SquareType.SNAKE_NODE)
                 break;
        }
        squares[row][column].setSquareType(SquareType.FOOD);
        System.out.println("Food is generated at: " + row + " " + column);
    }
}

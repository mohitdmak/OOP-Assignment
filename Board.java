public class Board {
 
    final int ROW_COUNT, COL_COUNT;
    private Square[][] squares;
    final BoardSize board_size;
 
    public Board(BoardSize board_size){
        this.board_size = board_size;
        if(board_size == BoardSize.SMALL){
            ROW_COUNT = 8;
            COL_COUNT = 8;
        }
        else if(board_size == BoardSize.MEDIUM){
            ROW_COUNT = 10;
            COL_COUNT = 10;
        }
        else if(board_size == BoardSize.BIG){
            ROW_COUNT = 12;
            COL_COUNT = 12;
        }
        else{
            ROW_COUNT = 12;
            COL_COUNT = 12;
        }
 
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

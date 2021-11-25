package src;

import java.util.*;

// Board class organizing all square
public class Board {
 
    ///////////////// ATTRIBUTES /////////////////
    
    // final integers for size of board
    final int ROW_COUNT, COL_COUNT;
    private Square[][] squares;
    // stores enum type for board size
    final BoardSize board_size;
    // maps board size type to length of side
    Map<BoardSize, Integer> get_side_length = new HashMap<BoardSize, Integer>(){{
        put(BoardSize.SMALL, 8); 
        put(BoardSize.MEDIUM, 10);
        put(BoardSize.BIG, 12);
    }};
 
    ///////////////// CONSTRUCTOR /////////////////
    
    public Board(BoardSize board_size){
        // store board size and accordingly assign row and column counts
        this.board_size = board_size;
        ROW_COUNT = get_side_length.get(board_size);
        COL_COUNT = get_side_length.get(board_size);
 
        // create 2D array of squares
        squares = new Square[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++){
            for (int column = 0; column < COL_COUNT; column++){
                squares[row][column] = new Square(row, column);
            }
        }
    }
 
    ///////////////// METHODS /////////////////
    
    // getter for all squares
    public Square[][] getSquares(){
        return squares;
    }
 
    // random food generation in the board
    public void generateFood(){
        int food_row;
        int food_column;
        // keep finding a random position till we obtain an emtpy square
        while(true){
            // generate random rows and columns within limits
            food_row = (int)(Math.random() * ROW_COUNT);
            food_column = (int)(Math.random() * COL_COUNT);
            // check if square is empty
            if(squares[food_row][food_column].getSquareType() != SquareType.SNAKE_NODE && squares[food_row][food_column].getSquareType() != SquareType.SNAKE_HEAD){
                 break;
            }
        }
        // set found random square's type to food
        squares[food_row][food_column].setSquareType(SquareType.FOOD);
    }
}

package src;

import java.util.Scanner;
import java.util.*;


// To represent and completely manage the Snake Game
public class Game {

    ///////////////// ATTRIBUTES /////////////////
    
    // storing direction ints as easily accessible variables
	public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    // following variables store the snake, board, current_direction and game status in static fields, as we want to have only 1 ref of each during a run
	private static Snake snake;
	private static Board board;
	private static int direction;
	private static boolean gameOver;

    // mapping user input strings to boardsize types
    static Map<String, BoardSize> get_board_size = new HashMap<String, BoardSize>(){{
        put("SMALL", BoardSize.SMALL);
        put("MEDIUM", BoardSize.MEDIUM);
        put("BIG", BoardSize.BIG);
    }};

    ///////////////// CONSTRUCTOR /////////////////
    
	public Game(Snake snake, Board board){
		this.snake = snake;
		this.board = board;
	}

    ///////////////// METHODS /////////////////

    // static getters
	public static Snake getSnake(){
		return snake;
	}
	public static Board getBoard(){
		return board;
	}
	public static boolean isGameOver(){
		return gameOver;
	}
	public static int getDirection(){
		return direction;
	}

    // static setters
	public static void setGameOver(boolean gameOver){
		gameOver = gameOver;
	}
	public static void setDirection(int dir){
		direction = dir;
	}

    // this function updates the state of game (types of squares and snake/food coordinates) either regularly or when user inputs 
	public void update(){
        // proceed if snake is moving in a legit way
		if (!gameOver){
			if (direction != DIRECTION_NONE){
                // get next position based on direction
				Square nextSquare = getNextSquare(snake.getHead());
                // check for crashes or out of bounds
				if(nextSquare == null || snake.checkCrash(nextSquare)){
					setDirection(DIRECTION_NONE);
					gameOver = true;
				}
				else{
                    // grow snake in case it reaches a food square, else simply move
					if(nextSquare.getSquareType() == SquareType.FOOD){
						snake.grow(nextSquare);
						board.generateFood();
					}
                    else{
                        snake.move(nextSquare);
                    }
				}
			}
		}
	}

    // finds the next square based on current square and current direction
	private Square getNextSquare(Square currentPosition){
        // get current coordinates
		int row = currentPosition.getRow();
		int col = currentPosition.getCol();

        // update coordinates based on direction
		if (direction == DIRECTION_RIGHT){
			col++;
		}
		else if (direction == DIRECTION_LEFT){
			col--;
		}
		else if (direction == DIRECTION_UP){
			row--;
		}
		else if (direction == DIRECTION_DOWN){
			row++;
		}

        // create nextsquare object
        Square nextSquare;
        if(row >= board.ROW_COUNT || col >= board.COL_COUNT || row < 0 || col < 0){
            nextSquare = null;
            this.gameOver = true;
        }
        else{
            nextSquare = board.getSquares()[row][col];
        }
		return nextSquare;
	}

    // start function initiates the game
    public static Game start(String board_selection){

        // create board according to user input
        Board board = new Board(get_board_size.get(board_selection));
        // first position of snake head and create snake object
		Square first_head = board.getSquares()[0][0];
		Snake snake = new Snake(first_head);
        // create game and set necessary variables
		Game new_game = new Game(snake, board);
		new_game.gameOver = false;
		new_game.setDirection(Game.DIRECTION_RIGHT);
        // generate food and return game object
        board.generateFood();

        return new_game;
    }
}

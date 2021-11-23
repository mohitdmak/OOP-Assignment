import java.util.Scanner;
import java.util.*;


// To represent Snake Game
public class Game {
    /////////////////////////////////////////////////////////////////////// GUI Implementation
    public static void main(String[] args){
        signupGUI.createUI();
    }


    /////////////////////////////////////////////////////////////////////// GFG IMPLEMENTATION
	// public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
	// DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
	// private Snake snake;
	// private Board board;
	// private int direction;
	// private boolean gameOver;

	// public Game(Snake snake, Board board){
	// 	this.snake = snake;
	// 	this.board = board;
	// }

	// public Snake getSnake(){
	// 	return snake;
	// }

	// public void setSnake(Snake snake){
	// 	this.snake = snake;
	// }

	// public Board getBoard(){
	// 	return board;
	// }

	// public void setBoard(Board board){
	// 	this.board = board;
	// }

	// public boolean isGameOver(){
	// 	return gameOver;
	// }

	// public void setGameOver(boolean gameOver){
	// 	this.gameOver = gameOver;
	// }

	// public int getDirection(){
	// 	return direction;
	// }

	// public void setDirection(int direction){
	// 	this.direction = direction;
	// }

	// // We need to update the game at regular intervals,
	// // and accept user input from the Keyboard.
	// public void update(){
	// 	System.out.println("Going to update the game");
	// 	if (!gameOver) {
	// 		if (direction != DIRECTION_NONE) {
	// 			Square nextSquare = getNextSquare(snake.getHead());

	// 			if (snake.checkCrash(nextSquare)) {
	// 				setDirection(DIRECTION_NONE);
	// 				gameOver = true;
	// 			}
	// 			else {
	// 				snake.move(nextSquare);
	// 				if (nextSquare.getSquareType() == SquareType.FOOD) {
	// 					snake.grow();
	// 					board.generateFood();
	// 				}
	// 			}
	// 		}
	// 	}
	// }

	// private Square getNextSquare(Square currentPosition){
	// 	System.out.println("Going to find next cell");
	// 	int row = currentPosition.getRow();
	// 	int col = currentPosition.getCol();

	// 	if (direction == DIRECTION_RIGHT){
	// 		col++;
	// 	}
	// 	else if (direction == DIRECTION_LEFT){
	// 		col--;
	// 	}
	// 	else if (direction == DIRECTION_UP){
	// 		row--;
	// 	}
	// 	else if (direction == DIRECTION_DOWN){
	// 		row++;
	// 	}

	// 	Square nextSquare = board.getSquares()[row][col];

	// 	return nextSquare;
	// }

	// public static void main(String[] args){

	// 	System.out.println("Going to start game");

	// 	Square initPos = new Square(0, 0);
	// 	Snake initSnake = new Snake(initPos);
	// 	Board board = new Board(10, 10);
	// 	Game newGame = new Game(initSnake, board);
	// 	newGame.gameOver = false;
	// 	newGame.direction = DIRECTION_RIGHT;

	// 	// We need to update the game at regular intervals,
	// 	// and accept user input from the Keyboard.

	// 	// here I have just called the different methods
	// 	// to show the functionality
	// 	for (int i = 0; i < 5; i++){
	// 		if (i == 2)
	// 			newGame.board.generateFood();
	// 		newGame.update();
	// 		if (i == 3)
	// 			newGame.direction = DIRECTION_RIGHT;
	// 		if (newGame.gameOver == true)
	// 			break;
	// 	}
	// }
// }


    /////////////////////////////////////////////////////////////////// my custom cli implementation
// class Game{

//     // trial run
//     public static void main(String[] args){
//         int valid_action = 0;
//         Player current = null;

//         do{
//             if(current != null){
//                 System.out.println("\nWelcome (User :" + current.username + ") (ID : " + current.id + ") (Pass : " + current.get_password() + ")");
//             }
//             else{
//                 System.out.println("\nNot logged in. ");
//             }

//             System.out.println("All Players :");
//             for(Player player : Player.get_players()){
//                 System.out.println("Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + "    Hash : " + player.hashCode());
//             }

//             System.out.println("Choose an action . . .\n <0> Register\n <1> Login\n <2> Logout\n <3> LeaderBoard\n <4> Exit");
//             int not_registered = 0;
//             int not_logged_in = 0;
//             int logout = 0;

//             Scanner input = new Scanner(System.in);
//             if(input.hasNextInt()){
//                 int action = input.nextInt();
//                 if(action == 0 && current == null){
//                     not_registered = 1;
//                 }
//                 else if(action == 1 && current == null){
//                     not_logged_in = 1;
//                 }
//                 else if(action == 2 && current != null){
//                     logout = 1;
//                 }
//                 else if(action == 3){
//                     Map<BoardSize, Set<Player>> leaderboard = Leaderboard.get_leaderboard();
//                     System.out.println("---------------------------------------------");
//                     System.out.println("\nRanklist for Small Boardsizes :");
//                     for(Player player : leaderboard.get(BoardSize.SMALL)){
//                         System.out.println(
//                                 "Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + 
//                                 "    HighScore : " + player.high_score.get(BoardSize.SMALL) + "    Hash : " + player.hashCode()
//                         );
//                     }
//                     System.out.println("\nRanklist for Medium Boardsizes :");
//                     for(Player player : leaderboard.get(BoardSize.MEDIUM)){
//                         System.out.println(
//                                 "Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + 
//                                 "    HighScore : " + player.high_score.get(BoardSize.MEDIUM) + "    Hash : " + player.hashCode()
//                         );
//                     }
//                     System.out.println("\nRanklist for Big Boardsizes :");
//                     for(Player player : leaderboard.get(BoardSize.BIG)){
//                         System.out.println(
//                                 "Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + 
//                                 "    HighScore : " + player.high_score.get(BoardSize.BIG) + "    Hash : " + player.hashCode()
//                         );
//                     }
//                     System.out.println("\n---------------------------------------------");
//                 }
//                 else if(action == 4){
//                     valid_action = 1;
//                     // System.exit(0);
//                 }
//                 else{
//                     System.out.println("Invalid Action !");
//                 }
//             }
//             else{
//                 System.out.println("Invalid Action !");
//             }

//             if(logout > 0){
//                 logout = 0;
//                 current = null;
//                 System.out.println("Logged out.");
//             }

//             while(not_registered > 0){
//                 try{
//                     System.out.println("Enter Username : ");
//                     Scanner input_reg = new Scanner(System.in);
//                     String username = input_reg.next();

//                     System.out.println("Enter Password : ");
//                     String password = input_reg.next();
//                     System.out.println("Confirm Password : ");
//                     String re_password = input_reg.next();

//                     if(password.equals(re_password)){
//                         not_registered = 0;
//                         Player new_player = Player.register(username, password);
//                         System.out.println("You are registered with id :" + new_player.id);
//                     }
//                     else{
//                         System.out.println("Your Passwords Donnot Match !");
//                     }
//                 }
//                 catch(Exception e){
//                     System.out.println(e);
//                 }
//             }

//             while(not_logged_in > 0){
//                 try{
//                     System.out.println("Enter Username : ");
//                     Scanner input_log = new Scanner(System.in);
//                     String username = input_log.next();

//                     System.out.println("Enter Password : ");
//                     String password = input_log.next();
//                     int id = Player.login(username, password);

//                     if(id > 0){
//                         Player player = Player.get_current_player_details(id);
//                         current = player;
//                         System.out.println("You are logged in with id :" + player.id);
//                         not_logged_in = 0;
//                     }
//                     else{
//                         System.out.println("Check your username and password again !");
//                     }
//                 }
//                 catch(Exception e){
//                     System.out.println(e);
//                 }
//             }

//         }while(valid_action == 0);
//     }
}

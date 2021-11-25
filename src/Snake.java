package src;

// To represent a snake
import java.util.LinkedList;
 
public class Snake {
 
    private LinkedList<Square> snakePartList = new LinkedList<>();
    private Square head;
 
    public Snake(Square initPos){
        head = initPos;
        snakePartList.add(head);
        head.setSquareType(SquareType.SNAKE_HEAD);
    }
 
    public void grow(Square nextSquare){ 
        System.out.println("Snake is GROWING to " + nextSquare.getRow() + " " + nextSquare.getCol() + " with size : " + String.valueOf(snakePartList.size()));
        if(snakePartList.size() > 0){
            snakePartList.getFirst().setSquareType(SquareType.SNAKE_NODE);
            System.out.println("node made");
        }
        head = nextSquare;
        head.setSquareType(SquareType.SNAKE_HEAD);
        snakePartList.addFirst(nextSquare); 
    }
 
    public void move(Square nextSquare){
        System.out.println("Snake is moving to " + nextSquare.getRow() + " " + nextSquare.getCol() + " with size : " + String.valueOf(snakePartList.size()));
        Square tail = snakePartList.removeLast();
        tail.setSquareType(SquareType.EMPTY);
 
        if(snakePartList.size() > 0){
            System.out.println("node made");
            snakePartList.getFirst().setSquareType(SquareType.SNAKE_NODE);
        }
        head = nextSquare;
        head.setSquareType(SquareType.SNAKE_HEAD);
        snakePartList.addFirst(head);
    }
 
    public boolean checkCrash(Square nextSquare){
        System.out.println("Going to check for Crash");
        for (Square square : snakePartList) {
            if (square == nextSquare) {
                return true;
            }
        }
        return false;
    }
 
    public LinkedList<Square> getSnakePartList(){
        return snakePartList;
    }
 
    public void setSnakePartList(LinkedList<Square> snakePartList){
        this.snakePartList = snakePartList;
    }
 
    public Square getHead(){
        return head; 
    }
 
    public void setHead(Square head){
        this.head = head; 
    }
}

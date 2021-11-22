// To represent a snake
import java.util.LinkedList;
 
public class Snake {
 
    private LinkedList<Square> snakePartList = new LinkedList<>();
    private Square head;
 
    public Snake(Square initPos){
        head = initPos;
        snakePartList.add(head);
        head.setSquareType(SquareType.SNAKE_NODE);
    }
 
    public void grow(){ 
        snakePartList.add(head); 
    }
 
    public void move(Square nextSquare){
        System.out.println("Snake is moving to " + nextSquare.getRow() + " " + nextSquare.getCol());
        Square tail = snakePartList.removeLast();
        tail.setSquareType(SquareType.EMPTY);
 
        head = nextSquare;
        head.setSquareType(SquareType.SNAKE_NODE);
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

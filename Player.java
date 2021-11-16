import static java.util.Map.entry;
import java.util.*;

class Player{

    ///////////////// ATTRIBUTES /////////////////
    
    // static id which is updated only opon new registrations
    private static int current_id = 1;

    // list of all players
    private static ArrayList<Player> all_players = new ArrayList<Player>();

    // user details
    public final String username;
    private final String password;
    public final int id;

    // rank and high scores
    /* Random generation should be removed later !!!! */
    Random rand = new Random();
    int r1 = rand.nextInt(50);
    int r2 = rand.nextInt(50);
    int r3 = rand.nextInt(50);
    /* Random generation should be removed later !!!! */
    public Map<BoardSize, Integer> rank = Map.ofEntries(
            entry(BoardSize.SMALL, 0),
            entry(BoardSize.MEDIUM, 0),
            entry(BoardSize.BIG, 0)
    );
    public Map<BoardSize, Integer> high_score = Map.ofEntries(
            entry(BoardSize.SMALL, r1),
            entry(BoardSize.MEDIUM, r2),
            entry(BoardSize.BIG, r3)
    );

    ///////////////// CONSTRUCTOR /////////////////
    
    // constructor
    public Player(String username, String password){
        this.username = username;
        this.password = password;
        this.id = current_id;
    }

    ///////////////// METHODS /////////////////

    // get password method for verification
    public String get_password(){
        return this.password;
    }

    // register new player
    public static Player register(String username, String password){
        Player new_player = new Player(username, password);
        // incrementing id unique to Player class
        current_id++;
        // adding to list of players
        all_players.add(new_player);
        return new_player;
    }

    // login 
    public static int login(String username, String password){
        for(Player player : all_players){
            if(player.username.equals(username) && player.get_password().equals(password)){
                return player.id;
            }
        }
        return -1;
    }

    // current session's player details
    public static Player get_current_player_details(int id){
        for(Player player : all_players){
            if(player.id == id){
                return player;
            }
        }
        return null;
    }

    // get list of players
    public static ArrayList<Player> get_players(){
        return all_players;
    }


    ///////////////// TO BE DELETED /////////////////
}

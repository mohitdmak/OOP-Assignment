import static java.util.Map.entry;
import java.util.*;

// player class organizing a player's record and details
class Player implements Comparable<Player>{

    ///////////////// ATTRIBUTES /////////////////
    
    // static id which is updated only opon new registrations
    private static int current_id = 1;

    // list of all players
    private static ArrayList<Player> all_players = new ArrayList<Player>();

    // user details
    public final String username;
    private final String password;
    public final int id;

    // map storing highscores and ranks for different board sizes
    public Map<BoardSize, Integer> rank = new HashMap<BoardSize, Integer>();
    public Map<BoardSize, Integer> high_score = new HashMap<BoardSize, Integer>(){{
        put(BoardSize.SMALL, 0);
        put(BoardSize.MEDIUM, 0);
        put(BoardSize.BIG, 0);
    }};

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

    // update high_score
    public void update_high_score(int score, BoardSize board_size){
        // update both high score and rank
        this.high_score.put(board_size, Math.max(score, this.high_score.get(board_size)));
        // this.set_player_ranks();
    }

    // setup player ranks
    public Map<BoardSize, Integer> get_player_ranks(){
        // obtaining ranklists
        List<Player> ranks_small = new ArrayList<>(Leaderboard.get_leaderboard().get(BoardSize.SMALL));
        List<Player> ranks_medium = new ArrayList<>(Leaderboard.get_leaderboard().get(BoardSize.MEDIUM));
        List<Player> ranks_big = new ArrayList<>(Leaderboard.get_leaderboard().get(BoardSize.BIG));

        // obtaining ranks
        this.rank.put(BoardSize.SMALL, ranks_small.indexOf(this) + 1);
        this.rank.put(BoardSize.MEDIUM, ranks_medium.indexOf(this) + 1);
        this.rank.put(BoardSize.BIG, ranks_big.indexOf(this) + 1);

        return this.rank;
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

    // comparable fxn
    public int compareTo(Player other_player){
        return this.id - other_player.id;
    }
}

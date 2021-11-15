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
    public Map<String, Integer> rank = Map.ofEntries(
            entry("small", 0),
            entry("medium", 0),
            entry("big", 0)
    );
    public Map<String, Integer> high_score = Map.ofEntries(
            entry("small", 0),
            entry("medium", 0),
            entry("big", 0)
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
    public static void main(String[] args){
        int valid_action = 0;
        Player current = null;

        do{
            if(current != null){
                System.out.println("\nWelcome (User :" + current.username + ") (ID : " + current.id + ") (Pass : " + current.get_password() + ")");
            }
            else{
                System.out.println("\nNot logged in. ");
            }

            System.out.println("All Players :");
            for(Player player : Player.get_players()){
                System.out.println("Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password());
            }

            System.out.println("Choose an action . . .\n <0> Register\n <1> Login\n <2> Logout");
            int not_registered = 0;
            int not_logged_in = 0;
            int logout = 0;

            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()){
                int action = input.nextInt();
                if(action == 0 && current == null){
                    not_registered = 1;
                    // valid_action = 1;
                }
                else if(action == 1 && current == null){
                    not_logged_in = 1;
                    // valid_action = 1;
                }
                else if(action == 2 && current != null){
                    logout = 1;
                }
                else{
                    System.out.println("Invalid Action !");
                }
            }
            else{
                System.out.println("Invalid Action !");
            }

            if(logout > 0){
                logout = 0;
                current = null;
                System.out.println("Logged out.");
            }

            while(not_registered > 0){
                try{
                    System.out.println("Enter Username : ");
                    Scanner input_reg = new Scanner(System.in);
                    String username = input_reg.next();

                    System.out.println("Enter Password : ");
                    String password = input_reg.next();
                    System.out.println("Confirm Password : ");
                    String re_password = input_reg.next();

                    if(password.equals(re_password)){
                        not_registered = 0;
                        Player new_player = Player.register(username, password);
                        System.out.println("You are registered with id :" + new_player.id);
                    }
                    else{
                        System.out.println("Your Passwords Donnot Match !");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

            while(not_logged_in > 0){
                try{
                    System.out.println("Enter Username : ");
                    Scanner input_log = new Scanner(System.in);
                    String username = input_log.next();

                    System.out.println("Enter Password : ");
                    String password = input_log.next();
                    int id = Player.login(username, password);

                    if(id > 0){
                        Player player = Player.get_current_player_details(id);
                        current = player;
                        System.out.println("You are logged in with id :" + player.id);
                        not_logged_in = 0;
                    }
                    else{
                        System.out.println("Check your username and password again !");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

        }while(valid_action == 0);
    }
}

import java.util.Scanner;
import java.util.*;

class Game{

    // trial run
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
                System.out.println("Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + "    Hash : " + player.hashCode());
            }

            System.out.println("Choose an action . . .\n <0> Register\n <1> Login\n <2> Logout\n <3> LeaderBoard\n <4> Exit");
            int not_registered = 0;
            int not_logged_in = 0;
            int logout = 0;

            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()){
                int action = input.nextInt();
                if(action == 0 && current == null){
                    not_registered = 1;
                }
                else if(action == 1 && current == null){
                    not_logged_in = 1;
                }
                else if(action == 2 && current != null){
                    logout = 1;
                }
                else if(action == 3){
                    Map<BoardSize, Set<Player>> leaderboard = Leaderboard.get_leaderboard();
                    System.out.println("---------------------------------------------");
                    System.out.println("\nRanklist for Small Boardsizes :");
                    for(Player player : leaderboard.get(BoardSize.SMALL)){
                        System.out.println(
                                "Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + 
                                "    HighScore : " + player.high_score.get(BoardSize.SMALL) + "    Hash : " + player.hashCode()
                        );
                    }
                    System.out.println("\nRanklist for Medium Boardsizes :");
                    for(Player player : leaderboard.get(BoardSize.MEDIUM)){
                        System.out.println(
                                "Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + 
                                "    HighScore : " + player.high_score.get(BoardSize.MEDIUM) + "    Hash : " + player.hashCode()
                        );
                    }
                    System.out.println("\nRanklist for Big Boardsizes :");
                    for(Player player : leaderboard.get(BoardSize.BIG)){
                        System.out.println(
                                "Name : " + player.username + "    ID : " + player.id + "    Pass : " + player.get_password() + 
                                "    HighScore : " + player.high_score.get(BoardSize.BIG) + "    Hash : " + player.hashCode()
                        );
                    }
                    System.out.println("\n---------------------------------------------");
                }
                else if(action == 4){
                    valid_action = 1;
                    // System.exit(0);
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

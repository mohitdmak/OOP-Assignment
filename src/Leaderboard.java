package src;

import java.util.*;
import static java.util.Map.entry;


class Leaderboard{

    ///////////////// ATTRIBUTES /////////////////

    // ranklist structure
    private static Map<BoardSize, Set<Player>> all_ranklists;

    ///////////////// CONSTRUCTOR /////////////////

    // custom constructor need not be created here as we only use the static methods of the leaderboard class.

    ///////////////// METHODS /////////////////
    
    // assembling leaderboard before sending response
    private static void assemble_leaderboard(){
        all_ranklists = new HashMap<BoardSize, Set<Player>>(){{
            // creating custom comparators to use with TreeSet and directly insert players in sorted orders
            put(BoardSize.SMALL, new TreeSet<Player>(new Comparator<Player>(){
                // overriding default compare function
                // return s1.high_score.get(BoardSize.MEDIUM).compareTo(s2.high_score.get(BoardSize.MEDIUM));
                @Override
                public int compare(Player p1, Player p2){
                    if(p1.high_score.get(BoardSize.SMALL) > p2.high_score.get(BoardSize.SMALL)){
                        return -1;
                    }
                    else if(p1.high_score.get(BoardSize.SMALL) < p2.high_score.get(BoardSize.SMALL)){
                        return 1;
                    }
                    else if(p1.id != p2.id){
                        return 1;
                    }
                    return 0;
                }
            }));
            put(BoardSize.MEDIUM, new TreeSet<Player>(new Comparator<Player>(){
                // overriding default compare function
                // return s1.high_score.get(BoardSize.MEDIUM).compareTo(s2.high_score.get(BoardSize.MEDIUM));
                @Override
                public int compare(Player p1, Player p2){
                    if(p1.high_score.get(BoardSize.MEDIUM) > p2.high_score.get(BoardSize.MEDIUM)){
                        return -1;
                    }
                    else if(p1.high_score.get(BoardSize.MEDIUM) < p2.high_score.get(BoardSize.MEDIUM)){
                        return 1;
                    }
                    else if(p1.id != p2.id){
                        return 1;
                    }
                    return 0;
                }
            }));
            put(BoardSize.BIG, new TreeSet<Player>(new Comparator<Player>(){
                // overriding default compare function
                // return s1.high_score.get(BoardSize.MEDIUM).compareTo(s2.high_score.get(BoardSize.MEDIUM));
                @Override
                public int compare(Player p1, Player p2){
                    if(p1.high_score.get(BoardSize.BIG) > p2.high_score.get(BoardSize.BIG)){
                        return -1;
                    }
                    else if(p1.high_score.get(BoardSize.BIG) < p2.high_score.get(BoardSize.BIG)){
                        return 1;
                    }
                    else if(p1.id != p2.id){
                        return 1;
                    }
                    return 0;
                }
            }));
        }};

        // organize each player into treeset
        for(Player player : Player.get_players()){
            all_ranklists.get(BoardSize.SMALL).add(player);
            all_ranklists.get(BoardSize.MEDIUM).add(player);
            all_ranklists.get(BoardSize.BIG).add(player);
        }
    }

    // public get leaderboard method
    public static Map<BoardSize, Set<Player>> get_leaderboard(){
        assemble_leaderboard();
        return all_ranklists;
    }


    ///////////////// TO BE DELETED /////////////////
}

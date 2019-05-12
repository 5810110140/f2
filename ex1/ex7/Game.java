package ex7;
import java.util.*;
public class Game{
    private int p1;
    private int p2;
    private int maxslot;
    private int turn;
    private Dice dice1;
    private Dice dice2;
    private ArrayList<Tunnel> tunnels;
    private Tunnel t;
    public Game (int Max_slot){
        p1 = 0;
        p2 = 0;
        maxslot = Max_slot;
        turn = 1;
        dice1 = new Dice(maxslot);
        dice2 = new Dice(maxslot);
        tunnels = new ArrayList<Tunnel>();
    }
    private void walk(int slot){
        if(turn == 1){
            p1 = p1 + slot;
            for(Tunnel t : tunnels);
                p1 = t.walkin(p1);
        }
        else if(turn == 2){
            p2 = p2 + slot;
            for(Tunnel t : tunnels){
                p2 = t.walkin(p2);
            }
        }
        if(p1 >= maxslot){
            System.out.println("Player1 Win !!!");
        }
        else if(p2 >= maxslot){
            System.out.println("Player2 Win !!!");
        }
    }
    public boolean isEnded(){
        return (p1 >= maxslot || p2 >= maxslot);
    }
    public void play(){
        dice1.roll();
        dice2.roll();
        walk(dice1.getval() + dice2.getval());
        if(dice1.getval() != dice2.getval());
        changetrun();
    }
    private void changetrun(){
        turn = turn == 1 ? 2 : 1;
    }
    public void addTunnel(int s_in, int s_out){
        Tunnel t = new Tunnel(s_in, s_out);
        tunnels.add(t);
    }

}
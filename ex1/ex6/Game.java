package ex6;

import java.util.*;
public class Game{
    private int p1;
    private int p2;
    private int maxslot;
    private int turn;
    private Dice dice1;
    private Dice dice2;
    public Game (int Max_slot){
        p1 = 0;
        p2 = 0;
        maxslot = Max_slot;
        turn = 1;
        dice1 = new Dice(maxslot);
        dice2 = new Dice(maxslot);

    }
    private void walk(int slot){
        if(turn == 1){
            p1 = p1 + slot;
        }
        else if( turn == 2){
            p2 = p2 + slot;
        }
        if(p1 >= maxslot){
            System.out.println("Player 1 WIN !!!");
        }
        else if(p2 >= maxslot){
            System.out.println("Player 2 WIN !!!");
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
        turn = turn == 1 ? 2: 1;
    }
	public void addTunnel(int i, int j) {
	}
}

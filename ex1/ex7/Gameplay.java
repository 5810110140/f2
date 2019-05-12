package ex7;

import java.util.*;

import ex6.Game;
    public class Gameplay{
    
     public static void main(String [] args){
        Game g = new Game(30);
            g.addTunnel(5,8);
            g.addTunnel(12,15);
            g.addTunnel(17,6);
            g.addTunnel(28,16);
    while (!g.isEnded()){
        g.play();
    }
    }
}
package ex6;

import java.util.*;
public class Gameplay{
    public static void main(String [] args){
        Game g = new Game(30);
        while(!g.isEnded()){
              g.play();
        }      
    }
}
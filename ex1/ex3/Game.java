package ex3;

public class Game {
    private int p1,count;
    private int p2;
    public Game(int a){
        count = a;
        p1 = 0;
        p2 = 0;
    }
    public void walk(int b,int num){
        if(num == 1)
            p1 += b;
        else if(num == 2)
            p2 += b;
        if(p1 >= count)
            System.out.println("player1 win!");
        if(p2 >= count)
            System.out.println("player2 win!");
    }
    public int getPlayer(){
        return p1;
    }
    public void setPlayer1(int player1){
        this.p1 = p1;
    }
}
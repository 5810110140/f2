import java.awt.Point;
import java.util.HashMap;

public class Board {  
  private int finishPos;
  private HashMap<Integer, Integer> tunnels = new HashMap<>();

  public Board(int finishPos) {
    this.finishPos = finishPos;
    prepareTunnels();
  }

  public int getFinishPos() {
    return finishPos;
  }

  public Integer getTunnelOutPos(int pos){
    return tunnels.get(pos);
  }

  public Point getRefLocationForPos(int pos){
    //800*500
    int row = ((pos - 1) / 10);
    int x;    
    if(row % 2 == 1){
      x = 82 * ((pos - 1) % 10);
    }else{
      x = 820 - ((pos - (row * 10)) * 82);
    }
    return new Point(x,  448 - (row * 64));
  }

  private void prepareTunnels(){

    //blackhole
    tunnels.put(8, 15);
    tunnels.put(13,10);
    tunnels.put(22,18);
    tunnels.put(25,31);
    tunnels.put(41,37);
    tunnels.put(47,67);
    tunnels.put(74,66);

    //meteorite
    tunnels.put(19,18);
    tunnels.put(28,27);
    tunnels.put(36,35);
    tunnels.put(58,57);
    tunnels.put(76,75);
  }
}
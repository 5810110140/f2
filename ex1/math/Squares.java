
// Squares.java

/*  How to use:
     > javac Squares.java
     > java Squares <number>
     e.g.
       java Squares 5

  To run, StdDraw.java must be in the same directory
*/

public class Squares
{

  public static void main(String[] args)
  {
    if (args.length != 1)
      System.out.println("Usage: java Squares <number>");
    else {
      int n = Integer.parseInt(args[0]);
      draw(n, 0.5, 0.5, 0.5);
    }
  }  // end of main()


  private static void draw(int n, double x, double y, double sz)
  {
    if (n > 0) {
      drawSquare(x, y, sz);

      double ratio = 2.2;  // sz reduction
      draw(n-1, x-sz/2, y-sz/2, sz/ratio);   
      draw(n-1, x-sz/2, y+sz/2, sz/ratio);   
      draw(n-1, x+sz/2, y-sz/2, sz/ratio);  
      draw(n-1, x+sz/2, y+sz/2, sz/ratio);
    }
  }  // end of draw()


  private static void drawSquare(double x, double y, double sz)
  // draw a shaded square using a filled gray square 
  // and an unfilled black square
  {
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledSquare(x, y, sz/2);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.square(x, y, sz/2);
  }  /// end of drawSquare()


}  // end of Squares class

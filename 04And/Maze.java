import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private int length, width;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */
    public static void main(String[]args) {
      try {
        Maze A = new Maze ( "data1.dat" );
        Maze B = new Maze ( "data2.dat" );
        Maze C = new Maze ( "data3.dat" );
        System.out.println( A );
        System.out.println( B );
        System.out.println( C );
      }
      catch ( FileNotFoundException e ) {
        System.out.println ( "uh oh");
      }
    }
    

    public Maze(String filename) throws FileNotFoundException , IllegalStateException {
      try {
	      Scanner file = new Scanner(new File(filename));
	      int lineSize = 0;
        int lineCount = 0;
        String line = "";
	      while (file.hasNextLine( )) {
	        lineCount++;
          line = file.nextLine( );
	      }
        lineSize = line.length( ); 
        maze = new char[lineCount][lineSize];
        length = lineCount;
        width = lineSize;
	      file.close( );
        int numS = 0;
        int numE = 0;
	      Scanner file2 = new Scanner(new File(filename));
	      for ( int i = 0 ; i < length ; i++ ) {
          line = file2.nextLine( );
          // System.out.println( line );
	        for ( int j = 0 ; j < width ; j++ ) {
		        maze[i][j] = line.charAt(j);
            if ( line.charAt(j) == 'S' ) {
              numS++;
            }
            if ( line.charAt(j) == 'E' ) {
              numE++;
            }
	        }
	      }
        if ( numS != 1 || numE != 1 ) {
          throw new IllegalStateException ( "incorrect amount of starts and/or ends" );
        }
      }
      catch ( FileNotFoundException e ) {
        // throw new FileNotFoundException ( "where the file at");
        System.out.println( "big uh oh");
      }
    }
    
    public String toString ( ) {
      String output = "";
      for ( int i = 0 ; i < length ; i++ ) {
        for ( int j = 0 ; j < width ; j++ ) {
          output += maze[i][j];
        }
        output += "\n";
      }
      return output;
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){
        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");
    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S. 


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);
      return 0;
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private
	
        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }
}



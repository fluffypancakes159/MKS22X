import java.util.*;

public class MazeSolver {

    private Maze maze;
    private Frontier frontier;

    public static void main(String[] args) {
        MazeSolver A = new MazeSolver ( "testMaze.txt" );
        System.out.println( A.solve( 2 ) );
        // A.tracePath( );
        // System.out.println( A );
    }

    public MazeSolver(String mazeText){
        maze = new Maze ( mazeText );
    }

    //Default to BFS
    public boolean solve( ){ 
        return solve(0); 
    }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    //2: Best-First
    public boolean solve(int mode){
        //initialize your frontier
        //while there is stuff in the frontier:
        //  get the next location
        //  process the location to find the locations (use the maze to do this)
        //  check if any locations are the end, if you found the end just return true!
        //  add all the locations to the frontier
        //when there are no more values in the frontier return false
        if ( mode == 0 ) {
            frontier = new QueueFrontier( );
        }
        if ( mode == 1 ) {
            frontier = new StackFrontier( );
        }
        if ( mode == 2 ) {
            frontier = new FrontierPriorityQueue( );
        }
        frontier.add( maze.start );
        while ( frontier.hasNext( ) ) {
            System.out.println( maze.toStringColor( ));
            System.out.println( frontier );
            Location current = frontier.next( );
            System.out.println( current );
            Location[] neighbors = maze.getNeighbors( current );
            for ( Location loc : neighbors ) {
                if ( loc != null ) {
                    if ( loc.equals( maze.end ) ) {
                        tracePath( loc.getPrev( ) );
                        return true;
                    }
                    frontier.add( loc );
                    maze.set( loc.getX( ), loc.getY( ), '?'); 
                }
                if ( maze.get( current.getX( ) , current.getY( ) ) != 'S' ) {
                    maze.set( current.getX( ), current.getY( ), '.'); 
                }
            }
        }
        return false;
    }

    public String toString( ){
        return maze.toString( );
    }

    public void tracePath ( Location ending ) {
        Location current = ending;
        while ( !current.equals( maze.start ) ) {
            maze.set( current.getX( ) , current.getY( ) , '@' );
            current = current.getPrev( );
            System.out.println( maze.toStringColor( ) );
        }
    }

}
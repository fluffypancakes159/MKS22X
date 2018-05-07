public class Maze {

    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private Location start,end;
    private char[][] board;

    public Maze(String mazeText){
    
    }

    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    public String toString( ){
        return "";
    }
   
    // Work on this method as a group! 
    public String toStringColor( ){
        return "";
    }

    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
        return null;
    }  

    public Location getStart( ){
        return null;
    }

    public Location getEnd( ){
        return null;
    }

}
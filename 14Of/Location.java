public class Location implements Comparable<Location>{

    private int x,y;
    private int dist;
    private Location previous;

    public Location(int _x, int _y, int _dist, Location prev){
    	x = _x;
    	y = _y;
        dist = _dist;
    	previous = prev;
    }

    public int getX ( ) {
    	return x;
    }

    public int getY ( ) {
    	return y;
    }

    public int getDist ( ) {
        return dist;
    }

    public int getDist ( Location other ) {
        return (x - other.x) + (y - other.y);
    }

    public Location getPrev ( ) {
    	return previous;
    }

    public boolean equals ( Location other ) {
    	return getX( ) == other.getX( ) && getY( ) == other.getY( );
    }

    public String toString ( ) {
    	return "X: " + x + " / Y: " + y; 
    }

    public int compareTo ( Location other ) {
        return this.dist - other.dist;
    }

}
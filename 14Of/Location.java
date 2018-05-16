public class Location implements Comparable<Location>{

    private int x,y;
    private int dist;
    private Location previous;
    private int distSoFar;

    public Location(int _x, int _y, int _dist, Location prev){
    	x = _x;
    	y = _y;
        dist = _dist;
    	previous = prev;
        distSoFar = 0;
    }

    public Location(int _x, int _y, int _dist, Location prev , int distSoFar ){
        x = _x;
        y = _y;
        previous = prev;
        this.distSoFar = distSoFar;
        dist = _dist + distSoFar;
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

    public int getDistSoFar ( ) {
        return distSoFar;
    }

    public int getDist ( Location other ) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    public Location getPrev ( ) {
    	return previous;
    }

    public boolean equals ( Location other ) {
    	return getX( ) == other.getX( ) && getY( ) == other.getY( );
    }

    public String toString ( ) {
    	return "" + dist;
        // return "X: " + x + " / Y: " + y; 
    }

    public int compareTo ( Location other ) {
        return this.dist - other.dist;
    }

}
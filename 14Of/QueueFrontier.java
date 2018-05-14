import java.util.*;

public class QueueFrontier implements Frontier { 

	ArrayDeque<Location> locations;

	public QueueFrontier ( ) {
		locations = new ArrayDeque<Location>( );
	}

	public void add ( Location L ) {
		locations.add( L );
	}

	public boolean hasNext ( ) {
		return locations.peek( ) != null;
	}

	public Location next ( ) {
		return locations.remove( );
	}

	public String toString ( ) {
		String out = "";
		for ( Location loc : locations ) {
			out += loc + "\n";
		}
		return out;
	}

}
import java.util.*;

public class StackFrontier implements Frontier { 

	Stack<Location> locations;

	public StackFrontier ( ) {
		locations = new Stack<Location>( );
	}

	public void add ( Location L ) {
		locations.add( L );
	}

	public boolean hasNext ( ) {
		return locations.peek( ) != null;
	}

	public Location next ( ) {
		return locations.pop( );
	}

}

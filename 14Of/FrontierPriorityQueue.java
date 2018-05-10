public class FrontierPriorityQueue implements Frontier { 

	MyHeap<Location> locations;

	public FrontierPriorityQueue ( ) {
		locations = new MyHeap<Location>( false );
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

}
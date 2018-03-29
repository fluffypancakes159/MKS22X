public class MyLinkedList implements List {
	
	private int size;
	private Node start;
	private Node end;

	public static void main(String[] args) {
		MyLinkedList A = new MyLinkedList ( );
		A.add( 5 );
		System.out.println ( A );
	}

	public MyLinkedList ( ) {
		start = null;
		end = null;
		size = 0;
	}

	public String toString ( ) {
		String out = "[";
		Node current = start;
		while ( !current.equals( null ) ) {
			out += current.getValue( );
			if ( !current.hasNext( ) ) {
				out += "]";
			}
			else {
				out += ", ";
			}
			current = current.getNext( );
		}
		return out;
	}

	public boolean add ( Integer newData ) {
		Node newNode = new Node ( newData ); 
		if ( size == 0 ) {
			start = newNode;
			end = newNode;

		}
		else { 
			newNode.setPrev( end );
			end = newNode;
		}
		size++;
	}

	public Integer get ( int index ) {
		if ( index >= size ) {
			throw new IndexOutOfBoundsException ( "array index out of bounds :(" );
		}
		int currentIndex = 0;
		for ( Node current : this ) {
			if ( currentIndex == index ) {
				return current.getValue( );
			}
			currentIndex++;
		}
		return -1;
	}

	public Integer set ( int index , Integer data ) {

	}

}
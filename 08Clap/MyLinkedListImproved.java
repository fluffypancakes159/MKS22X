import java.util.Iterator;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T> {
	
	private int size;
	private Node start;
	private Node end;

	public static void main(String[] args) {
		MyLinkedListImproved<Integer> A = new MyLinkedListImproved<>( );
		A.add( 1 );
		A.add( 2 );
		A.add( 3 );
		A.add( 4 );
		A.add( 5 );
		A.add( 6 );
		A.add( 7 );
		A.add( 8 );
		A.add( 9 );
		A.add( 10 );
		A.add( 1 );
		A.add( 2 );
		A.add( 3 );
		A.add( 1 );
		A.add( 2 );
		A.add( 3 );
		A.add( 1 );
		A.add( 2 );
		A.add( 3 );
		for ( Integer inte : A ) {
			System.out.println( inte );
		}
		System.out.println( A.min( ) );
		System.out.println( A.max( ) );
		// A.clear( );
		/*
		A.set( 1 , 6 );
		A.add( 1 , 4 );
		System.out.println( A );
		A.remove( Integer.valueOf( 4 ) );
		A.remove( 1 );
		System.out.println( A );
		MyLinkedListImproved<String> B = new MyLinkedListImproved<>( );
		B.add( "potato" );
		B.add( "tomato" );
		B.add( "asparagus" );
		System.out.println ( B );
		*/

	}

	public MyLinkedListImproved ( ) {
		start = null;
		end = null;
		size = 0;
	}

	public void clear ( ) {
		start = null;
		end = null;
		size = 0;
	}

	public int size ( ) {
		return this.size;
	}

	private Node getNode ( int index ) {
		int currentIndex = 0;
		Node current = start;
		while ( !(current == null) ) {
			if ( currentIndex == index ) {
				return current;
			}
			currentIndex++;
			current = current.getNext( );
		}
		return null;
	}

	public String toString ( ) {
		String out = "[";
		Node current = start;
		int currentIndex = 0;
		if ( size == 0 ) {
			return out + " ]";
		}
		while ( !(current == null) && currentIndex < size ) {
			out += current.getValue( );
			if ( !current.hasNext( ) ) {
				out += "]";
			}
			else {
				out += ", ";
			}
			current = current.getNext( );
			currentIndex++;
		}
		return out;
	}

	public boolean add ( T data ) {
		// System.out.println( data );
		Node newNode = new Node ( data ); 
		if ( size == 0 ) {
			start = newNode;
			end = newNode;
		}
		else { 
			end.setNext( newNode );
			newNode.setPrev( end );
			end = newNode;
		}
		size++;
		return true;
	}

	public T get ( int index ) {
		if ( index >= size || index < 0) {
			throw new IndexOutOfBoundsException ( "array index out of bounds :(" );
		}
		/* 
		int currentIndex = 0;
		Node current = start;
		while ( !(current == null) && currentIndex < size ) {
			if ( index == currentIndex ) {
				return current.getValue( );
			}
			current = current.getNext( );
			currentIndex++;
		}
		return -1;
		*/
		return getNode( index ).getValue( );
	}

	public T set ( int index , T data ) {
		if ( index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException ( "array index out of bounds :(" );
		}
		getNode( index ).setValue( data );
		return data;
	}

	public int indexOf ( T data ) {
		int currentIndex = 0;
		for ( T current : this ) {
			if ( data.equals( current ) ) {
				return currentIndex;
			}
			currentIndex++;
		}
		return -1;
	}

	public void add ( int index , T data ) {
		if ( index == size ) {
			add ( data );
		}
		Node newNode = new Node ( data );
		if ( index == 0 ) {
			start.setPrev( newNode );
			newNode.setNext( start );
			start = newNode;
		}
		else { 
			Node neighbor = getNode ( index );
			newNode.setNext( neighbor );
			newNode.setPrev( neighbor.getPrev( ) );
			neighbor.getPrev( ).setNext( newNode );
			neighbor.setPrev( newNode );
		}
		size++;
	}

	public boolean remove ( T data ) {
		int index = indexOf ( data );
		if ( index == -1 ) {
			return false;
		}
		Node target = getNode ( indexOf ( data ) );
		if ( index == 0 ) {
			start = target.getNext( );
			target.getNext( ).setPrev( null );
		}
		else if ( index == size - 1 ) {
			end = target.getPrev( );
			target.getPrev( ).setNext( null );
		}
		else {
			target.getPrev( ).setNext( target.getNext( ) );
			target.getNext( ).setPrev( target.getPrev( ) ); 
		}
		size--;
		return true;
	}

	public T remove ( int index ) {
		if ( index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException ( "array index out of bounds :(" );
		}
		Node target = getNode ( index );
		if ( index == 0 ) {
			start = target.getNext( );
			target.getNext( ).setPrev( null );
		}
		else if ( index == size - 1 ) {
			end = target.getPrev( );
			target.getPrev( ).setNext( null );
		}
		else {
			target.getPrev( ).setNext( target.getNext( ) );
			target.getNext( ).setPrev( target.getPrev( ) ); 
		}
		size--;
		return target.getValue( );
	}

	public int max ( ) {
		if ( size == 0 ) {
			return -1;
		}
		int currentIndex = 0; 
		int maxIndex = 0;
		T maxValue = start.getValue( );
		for ( T current : this ) {
			// System.out.println( current );
			if ( current.compareTo( maxValue ) > 0 ) {
				maxValue = current;
				maxIndex = currentIndex;
			}
			currentIndex++; 
		}
		return maxIndex;
	}

	public int min ( ) {
		if ( size == 0 ) {
			return -1;
		}
		int currentIndex = 0; 
		int minIndex = 0;
		T minValue = start.getValue( );
		for ( T current : this ) {
			// System.out.println( current );
			if ( current.compareTo( minValue ) < 0 ) {
				minValue = current;
				minIndex = currentIndex;
			}
			currentIndex++; 
		}
		return minIndex;
	}

	private class Node {
	
		private Node prev;
		private Node next;
		private T data;	

		public Node ( T data ) {
			prev = null;
			next = null;
			this.data = data;
		}	

		public Node ( Node prev , Node next , T data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}	

		private void setPrev ( Node prev ) {
			this.prev = prev; 
		}

		private void setNext ( Node next ) {
			this.next = next;
		}

		private void setValue ( T value ) {
			data = value;
		}

		public Node getPrev ( ) {
			return prev;
		}

		public Node getNext ( ) {
			return next;
		}

		public T getValue ( ) {
			return data;
		}

		public boolean hasNext ( ) {
			return !(this.getNext( ) == null);
		}

		public String toString ( ) {
			return "" + data;
		}

	}	

	public Iterator<T> iterator ( ) {
		return new LinkedIterator( );
	}

	private class LinkedIterator implements Iterator<T> {

		Node current;

		public LinkedIterator ( ) {
			current = start;
		}

		public boolean hasNext ( ) {
			return !(current == null); //checks if current is null instead of if the next is null
		}

		public T next ( ) {
			Node output = current;
			current = current.getNext( );
			return output.getValue( );
		}

	}

}
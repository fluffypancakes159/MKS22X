public class MyLinkedList {
	
	private int size;
	private Node start;
	private Node end;

	public static void main(String[] args) {
		MyLinkedList A = new MyLinkedList ( );
		A.add( 5 );
		A.add( 7 );
		System.out.println( A );
		System.out.println( A.get( 1 ) );
		// A.clear( );
		A.set( 1 , 6 );
		A.add( 1 , 4 );
		System.out.println( A );
		// A.remove( Integer.valueOf( 4 ) );
		A.remove( 1 );
		System.out.println( A );
		// System.out.println ( A.indexOf( 6 ) );
	}

	public MyLinkedList ( ) {
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

	public boolean add ( Integer data ) {
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

	public Integer get ( int index ) {
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

	public Integer set ( int index , Integer data ) {
		if ( index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException ( "array index out of bounds :(" );
		}
		getNode( index ).setValue( data );
		return data;
	}

	public int indexOf ( Integer data ) {
		int currentIndex = 0;
		Node current = start;
		while ( !(current == null) && currentIndex < size ) {
			if ( data.equals( current.getValue( ) ) ) {
				return currentIndex;
			}
			current = current.getNext( );
			currentIndex++;
		}
		return -1;
	}

	public void add ( int index , Integer data ) {
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

	public boolean remove ( Integer data ) {
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

	public Integer remove ( int index ) {
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

	private class Node {
	
		private Node prev;
		private Node next;
		private Integer data;	

		public Node ( Integer data ) {
			prev = null;
			next = null;
			this.data = data;
		}	

		public Node ( Node prev , Node next , Integer data) {
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

		private void setValue ( Integer value ) {
			data = value;
		}

		public Node getPrev ( ) {
			return prev;
		}

		public Node getNext ( ) {
			return next;
		}

		public Integer getValue ( ) {
			return data;
		}

		public boolean hasNext ( ) {
			return !(this.getNext( ) == null);
		}

		public String toString ( ) {
			return "" + data;
		}

	}	

}
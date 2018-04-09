public class MyLinkedList {
	
	private int size;
	private Node start;
	private Node end;

	public static void main(String[] args) {
		MyLinkedList A = new MyLinkedList ( );
		A.add( 5 );
		A.add( 7 );
		System.out.println ( A );
		// System.out.println ( A.get( 1 ) );
	}

	public MyLinkedList ( ) {
		start = null;
		end = null;
		size = 0;
	}

	public String toString ( ) {
		String out = "[";
		Node current = start;
		int currentIndex = 0;
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

	public boolean add ( Integer newData ) {
		// System.out.println( newData );
		Node newNode = new Node ( newData ); 
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
		if ( index >= size ) {
			throw new IndexOutOfBoundsException ( "array index out of bounds :(" );
		}
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
	}

	public Integer set ( int index , Integer data ) {
		return 0;
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

		public int getValue ( ) {
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
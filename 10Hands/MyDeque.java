import java.util.*;

public class MyDeque<E> /*implements Queue<E>*/ {
	
	private E[] data;
	private int start;
	private int end;
	private int len;

	public static void main(String[] args) {
		MyDeque<Integer> A = new MyDeque<>( 3 );
		A.addLast( 4 );
		A.addFirst( 5 );
		A.addLast( 4 );
		A.addLast( 7 );
		A.removeFirst( );
		A.removeLast( );
		System.out.println( A );
		// System.out.println( A.removeFirst( ) );
		MyDeque<Integer> B = new MyDeque<>( );
		B.addFirst( 17 );
		B.removeLast( );
		System.out.println( B );
		System.out.println( A.getFirst( ) );
		System.out.println( A.getLast( ) );
	}

	@SuppressWarnings ( "unchecked" )
	public MyDeque ( ) {
		data = (E[]) new Object[10];
		start = 4;
		end = 4;
		len = 0;
	}

	public MyDeque ( int size ) {
		if ( size <= 0 ) {
			throw new IllegalArgumentException( "insufficient size :(" );
		}
		data = (E[]) new Object[size];
		start = size / 2;
		end = size / 2;
	}

	public int size ( ) {
		return len;
	}

	public String toString ( ) {
		int current = start;
		String out = "[";
		// System.out.println( current % data.length );
		// System.out.println( data[current % data.length + 1] );
		if ( len == 1 ) {
			return out + data[current] + "]";
		}
		while ( current % data.length - 1 != end ) {
			if ( current % data.length == end ) {
				out += data[current % data.length] + "]";
				break;
			}
			else {
				out += data[current % data.length] + ", ";
			}
			current++; 
		}
		return out;
	}

	public void addFirst ( E elem ) {
		/*
		System.out.println( Arrays.toString ( data ) );
		System.out.println( start );
		System.out.println( end );
		*/
		if ( elem == null ) {
			throw new NullPointerException ( "cannot add null :(" );
		}
		if ( (end + 1) % data.length == start % data.length ) {
			this.resize( );
		}
		if ( len == 0 ) {
			len++;
			data[start] = elem;
			return;
		}
		else {
			if ( start == 0 ) {
				start = data.length - 1;
			}
			else {
				start--;
			}
			data[start] = elem;
			len++;
		}
	}

	public void addLast ( E elem ) {
		/*
		System.out.println( Arrays.toString ( data ) );
		System.out.println( start );
		System.out.println( end );
		*/
		if ( elem == null ) {
			throw new NullPointerException ( "cannot add null :(" );
		}
		if ( (end + 1) % data.length == start % data.length ) {
			this.resize( );
		}
		if ( len == 0 ) {
			len++;
			data[end] = elem;
			return;
		}
		else{
			if ( end == data.length - 1 ) {
				end = 0;
			}
			else {
				end++;
			}
			data[end] = elem;
			len++;
		}
	}

	private void resize ( ) {
		E[] newData = (E[]) new Object[len * 2 + 1];
		// System.out.println( Arrays.toString ( newData ) );
		int newStart = len / 2;
		int newEnd = newStart + len - 1;
		for ( int i = 0 ; i < len ; i++ ) {
			newData[newStart + i] = data[(start + i) % len];
		}
		start = newStart;
		end = newEnd;
		data = newData;
		// System.out.println( Arrays.toString ( data ) );
	}

	public E removeFirst ( ) {
		if ( len == 0 ) {
			throw new NoSuchElementException ( "list is empty :(" );
		}
		E remove = data[start];
		data[start] = null;
		len--;
		if ( len > 1 ) {
			start = (start + 1) % data.length;
		}
		return remove;
	}

	public E removeLast ( ) {
		if ( len == 0 ) {
			throw new NoSuchElementException ( "list is empty :(" );
		}
		E remove = data[end];
		data[end] = null;
		len--;
		if ( len > 1 ) {
			if ( end == 0 ) {
				end = data.length - 1;
			}
			else {
				end--;
			}
		}
		return remove;
	}

	public E getFirst ( ) {
		if ( len == 0 ) {
			throw new NoSuchElementException ( "list is empty :(" );
		}
		return data[start];
	}

	public E getLast ( ) {
		if ( len == 0 ) {
			throw new NoSuchElementException ( "list is empty :(" );
		}
		return data[end];
	}

}

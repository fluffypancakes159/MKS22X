import java.util.*;

public class MyDeque<E> /*implements Queue<E>*/ {
	
	private E[] data;
	private int start;
	private int end;
	private int len;

	public static void main(String[] args) {
		MyDeque<Integer> A = new MyDeque<>( );
		A.addLast( 4 );
		A.addFirst( 5 );
		A.addLast( 4 );
		System.out.println( A );
	}

	@SuppressWarnings ( "unchecked" )
	public MyDeque ( ) {
		data = (E[]) new Object[10];
		start = 4;
		end = 4;
		len = 0;
	}

	public MyDeque ( int size ) {
		if ( size >= 0 ) {
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
		System.out.println( current % data.length );
		System.out.println( data[current % data.length + 1] );
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
		if ( elem == null ) {
			throw new NullPointerException ( "cannot add null :(" );
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
		if ( elem == null ) {
			throw new NullPointerException ( "cannot add null :(" );
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

}
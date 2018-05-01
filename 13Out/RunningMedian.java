import java.util.*;

public class RunningMedian {

	private int size;
	private MyHeap<Double> left;
	private MyHeap<Double> right;

	public static void main(String[] args) {
		RunningMedian A = new RunningMedian ( );
		try {
			A.getMedian( );
		}
		catch ( NoSuchElementException e ) {
			System.out.println( "Error caught :)" );
		}
		A.add( 2.5 );
		A.add( 7.0 );
		A.add( 4.1 );
		A.add( 6.6 );
		A.add( 4.3 );
		A.add( 10.0 );
		A.add( 7.9 );
		A.add( 7.9 );
		A.add( 6.8 );
		System.out.println( A.getMedian( ) );
		System.out.println( A.getLeft( ) );
		System.out.println( A.getRight( ) );
	}

	public RunningMedian ( ) {
		size = 0;
		left = new MyHeap<Double>( false );
		right = new MyHeap<Double>( );
	}

	public void add ( double num ) {
		if ( size == 0 ) {
			left.add( num );
		}
		else { 
			if ( num <= getMedian( ) ) {
				left.add( num );
				if ( left.size( ) == right.size( ) + 2 ) {
					right.add( left.remove( ) );
				} 
			}
			else {
				right.add( num );
				if ( right.size( ) == left.size( ) + 2 ) {
					left.add( right.remove( ) );
				}
			}
		}
		size++;
	}

	public Double getMedian ( ) {
		if ( size == 0 ) {
			throw new NoSuchElementException ( "empty list :(" );
		}
		if ( left.size( ) == right.size( ) ) {
			return (left.peek( ) + right.peek( )) / 2;
		}
		else {
			if ( left.size( ) > right.size( ) ) {
				return left.peek( );
			}
			else {
				return right.peek( );
			}
		}
	}

	public int size ( ) {
		return size;
	}

	public MyHeap<Double> getLeft ( ) {
		return left;
	}

	public MyHeap<Double> getRight ( ) {
		return right;
	}

}
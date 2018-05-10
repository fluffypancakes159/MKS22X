import java.util.Arrays;

public class MyHeap<T extends Comparable<T>> { 

	private T[] data;
	private int size;
	private boolean max;

	public static void main(String[] args) {
		MyHeap<Integer> A = new MyHeap<>( );
		Integer[] ary = {8, 6, 5, 5, 5, 2, 0, 0, 0, 3};
		// A.add( "e");
		for ( int i = 0 ; i < 10 ; i++ ) {
			// A.add( ary[i] );
			A.add( (Integer)(int)(Math.random( ) * 10) );
		}
		// System.out.println( A.size( ) );
		System.out.println( A );
		for ( int i = 0 ; i < 10 ; i++ ) {
			System.out.println( "Elem: " + A.remove( ) );
		}
		// System.out.println( Arrays.toString(A.getData( )) );
		
	}

	@SuppressWarnings( "unchecked")
	public MyHeap ( ) {
		data = (T[]) new Comparable[10];
		size = 0;
		max = false;
	}

	public MyHeap ( boolean min ) { // mixed up max and min heaps so max really signifies if the heap is min
		this( );
		max = !min;
	}

	public T[] getData ( ) {
		return data;
	}

	private void resize ( ) {
		T[] newData = (T[])new Comparable[size * 2 + 1];
		for ( int i = 0 ; i < size ; i++ ) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public void add ( T s ) {
		if ( size == data.length ) {
			resize( );
		}
		data[size] = s;
		if ( size >= 1 ) { 
			if ( max ) {
				pushMax( size );
			}
			else {
				pushMin( size );
			}
		}
		size++;
		// System.out.println( Arrays.toString( data ) );
	}

	public T remove ( ) {
		System.out.println( this );
		if ( size == 0 ) {
			return null;
		}
		T out = data[0];
		data[0] = null;
		swap ( 0 , size - 1 );
		size--;
		// data[size - 1] = null;
		if ( max ) {
			pullMax( );
			// System.out.println( "min" );
		}
		else {
			pullMin( );
			// System.out.println( "max" );
		}
		return out;
	}

	public T peek ( ) {
		return data[0];
	}

	public int size ( ) {
		return size;
	}

	private T getParent ( int index ) {
		return data[(index - 1) / 2];
	}

	private T getLeft ( int index ) {
		return data[index * 2 + 1];
	}

	private T getRight ( int index ) {
		return data[index * 2 + 2];
	}

	private int getParentIndex ( int index ) {
		return (index - 1) / 2;
	}

	private int getLeftIndex ( int index ) {
		return index * 2 + 1;
	}

	private int getRightIndex ( int index ) {
		return index * 2 + 2;
	}

	public void swap ( int index1 , int index2 ) {
		/*
		System.out.println( "Index 1: " + index1 );
		System.out.println( "Index 2: " + index2 );
		System.out.println( size );
		System.out.println( Arrays.toString(data));
		*/
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
		// System.out.println( Arrays.toString(data));
	}

	private void pushMax ( int index ) {
		int currentIndex = index;
		while ( currentIndex != 0 && data[currentIndex].compareTo( getParent( currentIndex ) ) <= 0 ) {
			swap ( currentIndex , getParentIndex( currentIndex ) );
			currentIndex = getParentIndex( currentIndex );
		}
	}

	private void pushMin ( int index ) {
		int currentIndex = index;
		while ( currentIndex != 0 && data[currentIndex].compareTo( getParent( currentIndex ) ) >= 0 ) {
			swap ( currentIndex , getParentIndex( currentIndex ) );
			currentIndex = getParentIndex( currentIndex );
		}
	}

	private void pullMax ( ) {
		int currentIndex = 0;
		while ( hasLeft( currentIndex ) ||
			    hasRight( currentIndex ) ) {
			System.out.println( "In while loop" );
			T left = getLeft( currentIndex );
			T right = getRight( currentIndex );
			if ( right == null ) {
				if ( data[currentIndex].compareTo( left ) >= 0 ) {
					swap ( currentIndex , getLeftIndex ( currentIndex ) );	
					currentIndex = getLeftIndex ( currentIndex );
				}
				else {
					return;
				}
			}
			else {
				if ( data[currentIndex].compareTo( left ) >= 0 && left.compareTo( right ) <= 0 ) {
					swap ( currentIndex , getLeftIndex ( currentIndex ) );	
					currentIndex = getLeftIndex ( currentIndex );
				}
				else if ( data[currentIndex].compareTo( right ) >= 0 ) {
					swap ( currentIndex , getRightIndex ( currentIndex ) );	
					currentIndex = getRightIndex ( currentIndex );
				}
				else {
					return;
				}
			}
		}
	}

	private void pullMin ( ) {
		int currentIndex = 0;
		while ( hasLeft( currentIndex ) ||
			    hasRight( currentIndex ) ) {
			System.out.println( "In while loop" );
			T left = getLeft( currentIndex );
			T right = getRight( currentIndex );
			if ( right == null ) {
				if ( data[currentIndex].compareTo( left ) <= 0 ) {
					swap ( currentIndex , getLeftIndex ( currentIndex ) );	
					currentIndex = getLeftIndex ( currentIndex );
				}
				else {
					return;
				}
			}
			else {
				if ( data[currentIndex].compareTo( left ) <= 0 && left.compareTo( right ) >= 0 ) {
					swap ( currentIndex , getLeftIndex ( currentIndex ) );	
					currentIndex = getLeftIndex ( currentIndex );
				}
				else if ( data[currentIndex].compareTo( right ) <= 0 ) {
					swap ( currentIndex , getRightIndex ( currentIndex ) );	
					currentIndex = getRightIndex ( currentIndex );
				}
				else {
					return;
				}
			}
		}
	}

	private boolean hasLeft ( int index ) {
		if ( index * 2 + 1 >= size || data[index * 2 + 1] == null ) {
			return false;
		}
		return true;
	}

	private boolean hasRight ( int index ) {
		if ( index * 2 + 2 >= size || data[index * 2 + 2] == null ) {
			return false;
		}
		return true;
	}


	public boolean isMin ( ) {
		return max;
	}

	public String toString ( ) {
		return Arrays.toString( data );
	}

}
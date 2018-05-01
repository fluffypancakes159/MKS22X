import java.util.Arrays;

public class MyHeap<T extends Comparable<T>> { 

	private T[] data;
	private int size;
	private boolean max;

	public static void main(String[] args) {
		MyHeap<String> A = new MyHeap<>( false );
		A.add( "a" );
		A.add( "b" );
		A.add( "ba" );
		A.add( "c" );
		A.add( "q" );
		A.add( "bbbb" );
		A.add( "aa" );
		A.add( "bc");
		A.add( "d");
		A.add( "d");
		// A.add( "e");
		System.out.println( Arrays.toString(A.getData( )) );
		A.remove( );
		System.out.println( Arrays.toString(A.getData( )) );
		A.remove( );
		System.out.println( Arrays.toString(A.getData( )) );
		A.remove( );
		System.out.println( Arrays.toString(A.getData( )) );
		A.remove( );
		A.remove( );
		A.remove( );
		A.remove( );
		A.remove( );
		A.remove( );
		A.remove( );
		A.remove( );
		System.out.println( Arrays.toString(A.getData( )) );
		/*
		MyHeap B = new MyHeap( false );
		B.add( "a" );
		B.add( "b" );
		B.add( "ba" );
		B.add( "c" );
		B.add( "q" );
		B.add( "bbbb" );
		B.add( "aa" );
		B.add( "bc");
		System.out.println( Arrays.toString(B.getData( )) );
		*/
		// System.out.println( "c".compareTo( "ba" ) );
	}

	@SuppressWarnings( "unchecked")
	public MyHeap ( ) {
		data = (T[])new Comparable[10];
		size = 0;
		max = true;
	}

	public MyHeap ( boolean min ) {
		this( );
		max = false;
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
		if ( size == 0 ) {
			return null;
		}
		T out = data[0];
		swap ( 0 , size - 1 );
		data[size - 1] = null;
		size--;
		if ( max ) {
			pullMax( );
		}
		else {
			pullMin( );
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
		while ( ( getLeftIndex ( currentIndex ) < size &&
			     getRightIndex ( currentIndex ) < size ) &&
				( data[currentIndex].compareTo( getLeft( currentIndex ) ) > 0 ||
			     data[currentIndex].compareTo( getRight( currentIndex ) ) > 0 ) ) {
			T left = getLeft( currentIndex );
			T right = getRight( currentIndex );
			if ( right == null || left.compareTo( right ) <= 0 ) {
				swap ( currentIndex , getLeftIndex ( currentIndex ) );	
				currentIndex = getLeftIndex ( currentIndex );
			}
			else {
				swap ( currentIndex , getRightIndex ( currentIndex ) );	
				currentIndex = getRightIndex ( currentIndex );
			}
		}
	}

	private void pullMin ( ) {
		int currentIndex = 0;
		while ( ( getLeftIndex ( currentIndex ) < size &&
			     getRightIndex ( currentIndex ) < size ) &&
				( data[currentIndex].compareTo( getLeft( currentIndex ) ) < 0 ||
			     data[currentIndex].compareTo( getRight( currentIndex ) ) < 0 ) ) {
			T left = getLeft( currentIndex );
			T right = getRight( currentIndex );
			if ( right == null || left.compareTo( right ) >= 0 ) {
				swap ( currentIndex , getLeftIndex ( currentIndex ) );	
				currentIndex = getLeftIndex ( currentIndex );
			}
			else {
				swap ( currentIndex , getRightIndex ( currentIndex ) );	
				currentIndex = getRightIndex ( currentIndex );
			}
		}
	}

	public String toString ( ) {
		return Arrays.toString( getData( ) );
	}

}
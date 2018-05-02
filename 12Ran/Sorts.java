public class Sorts {

	public static void main(String[] args) {
		MyHeap<Integer> A = new MyHeap<>( );
		A.add( 3 );
		A.add( 6 );
		A.add( 5 );
		A.add( 10 );
		A.add( 14 );
		A.add( 2 );
		A.add( 3 );
		A.add( 6 );
		System.out.println( A );
		// A.remove( );
		// System.out.println( A );
		Sorts.heapSort( A );
		System.out.println( A );
	}

	public static void heapSort ( MyHeap heap ) {
		int maxSize = heap.size( );
		boolean isMin = heap.isMin( );
		System.out.println( maxSize );
		rearrange ( heap , maxSize );
		/*
		if ( isMin ) {
			rearrange_ ( heap , maxSize );
		}
		*/
	}

	private static void rearrange ( MyHeap heap , int maxSize ) {
		for ( int i = 0 ; i < maxSize ; i++ ) {
			System.out.println( heap );
			heap.getData( )[maxSize - 1 - i] = heap.remove( );
			// heap.add( null );
		}
	}

}
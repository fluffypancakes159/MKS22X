import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		/*
		MyHeap<Integer> A = new MyHeap<>( );
		A.add( 3 );
		A.add( 6 );
		A.add( 5 );
		A.add( 10 );
		A.add( 14 );
		A.add( 2 );
		A.add( 3 );
		A.add( 6 );
		*/
		// Integer[] A = {12 , 3 , 4 , 12 , 17 , 35 , 63 , 2 , 6 , 6};
		Integer[] A = new Integer[10];
		for ( int i = 0 ; i < A.length ; i++ ) {
			// A[i] = ( (Integer)(int)(Math.random( ) * 20) );
			A[i] = 5;
		}
		System.out.println( Arrays.toString( A ) );
		// A.remove( );
		// System.out.println( A );
		Sorts.heapSort( A );
		System.out.println( Arrays.toString( A ) );
	}

	public static void heapSort ( Integer[] ary ) {
		MyHeap<Integer> heap = new MyHeap<>( );
		for ( Integer inte : ary ) {
			heap.add( inte );
		}
		// int maxSize = heap.size( );
		// boolean isMin = heap.isMin( );
		System.out.println( heap );
		for ( int i = 0 ; i < ary.length ; i++ ) {
			ary[ary.length - 1 - i] = heap.remove( );
			// System.out.println( Arrays.toString( ary ) );
		}
	}

	private static void rearrange ( MyHeap heap , int maxSize ) {
		for ( int i = 0 ; i < maxSize ; i++ ) {
			// System.out.println( heap );
			heap.getData( )[maxSize - 1 - i] = heap.remove( );
			// heap.add( null );
		}
	}

}
public class Quick {
	
	public static void main(String[] args) {
		int[] A = {13,8,4,19,1,1,3,5,5,17};
		int[] B = {99,99,99,0,0,0,0,9,9,9};
		int[] C = new int[10000];
		
		for ( int i = 0 ; i < 10000 ; i++ ) {
			C[i] = (int)(Math.random( ) * 200000) - 100000;
		}
		/*
		System.out.println ( arrayStr ( C ) );
		partition ( C , 0 , C.length - 1);
		System.out.println ( arrayStr( C ) );
		*/
		
		//System.out.println ( arrayStr( C ) );
		quicksort( C );
		System.out.println ( isSorted( C ) );
		
		/*
		System.out.println ( arrayStr( B ) );
		quickSort ( B  );
		System.out.println ( arrayStr( B ) );
		*/
	}

	// helpers 

	public static boolean isSorted ( int[]ary ) {
		for ( int i = 0 ; i < ary.length - 1 ; i++ ) {
			if ( ary[i] > ary[i+1] ) {
				return false;
			}
		}
		return true;
	}

	public static void insertion ( int[]data , int lo , int hi ) {
		int current = lo + 1;
		while ( current <= hi ) {
			for ( int i = lo ; i <= hi ; i++ ) {
				if ( data[i] > data[current] ) {
					move ( data , current , i );
				}
			}
			current++;
			// System.out.println ( arrayStr (data) );
		}
	}

	public static void move ( int[]data , int start , int end ) {
		int current = start;
		int value = data[start];
		for ( int i = start ; i > end ; i-- ) {
			data[i] = data[i-1];
		}
		data[end] = value;
	}

	public static void swap ( int[]ary , int index1 , int index2 ) {
		int swap = ary[index1];
		ary[index1] = ary[index2];
		ary[index2] = swap;
	}

	public static String arrayStr ( int[]ary ) {
		String output = "[";
		for ( int i = 0 ; i < ary.length - 1; i++ ) {
			output += ary[i] + " , ";
		}
		output += ary[ary.length - 1] + "]";
		return output;
	}

	// non-helpers

	public static int partition ( int[]data , int start , int end ) {
		int pivotIndex = (int)(Math.random( ) * (end - start)) + start;
		// System.out.println ( "Pivot number: " + data[pivotIndex] + "\n" );
		int low = start;
		int high = end;
		swap ( data , low , pivotIndex );
		int lowerBound = low;
		int current = lowerBound + 1;
		int upperBound = high;
		while ( current <= upperBound ) {
			// System.out.println ( arrayStr ( data ) + "\nlowerBound: " + lowerBound + "\ncurrent: " + current + "\nupperBound: " + upperBound + "\n"  );
			if ( data[current] > data[lowerBound] ) {
				swap ( data , current , upperBound );
				upperBound--;
			}
			else if ( data[current] == data[lowerBound] ) {
				current++;
			}
			else {
				swap ( data , lowerBound , current );
				lowerBound++;
				current++;
			}
		}
		// System.out.println ( arrayStr ( data ) );
		return lowerBound;
	}

	public static int quickselect ( int[]data , int k ) {
		int divider = partition ( data , 0 , data.length - 1 ); // first divide 
		while ( divider != k ) {
			if ( divider < k ) {
				divider = partition ( data , divider , data.length - 1 );
			}
			else {
				divider = partition ( data , 0 , divider );
			}
		}
		return data[divider];
	}

	public static void quicksort ( int[]data ) {
		sortHelp ( data , 0 , data.length - 1);
		// System.out.println ( arrayStr( data ));
	}

	public static void sortHelp ( int[]data , int start , int end ) {
		if ( start + 5 >= end ) {
			insertion ( data , start , end );
			return;
		}
		else {
			int divider = partition ( data , start , end );
			// System.out.println( "" + "Start: " + start + "\nEnd: " + end + "\nDivider: " + divider );
			sortHelp ( data , start , divider );
			sortHelp ( data , divider + 1 , end);
		}
	}



}
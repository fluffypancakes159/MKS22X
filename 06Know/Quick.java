public class Quick {
	
	public static void main(String[] args) {
		int[] A = {13,8,4,19,1,1,3,5,5,17};
		int[] B = {99,99,99,0,0,0,0,9,9,9};
		int[] C = new int[20];
		
		for ( int i = 0 ; i < 20 ; i++ ) {
			C[i] = (int)(Math.random( ) * 100);
		}
		/*
		System.out.println ( arrayStr ( C ) );
		partition ( C , 0 , C.length - 1);
		System.out.println ( arrayStr( C ) );
		
		*/
		
		System.out.println ( arrayStr( C ) );
		quickSort( C );
		System.out.println ( arrayStr( C ) );
		

		/*
		System.out.println ( arrayStr( B ) );
		quickSort ( B  );
		System.out.println ( arrayStr( B ) );
		*/
	}

	// helpers 

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

	/*
	public static int partition ( int[]data , int start , int end ) {
		int pivotIndex = (int)(Math.random( ) * (end - start)) + start;
		// System.out.println ( pivotIndex );
		int low = start;
		int high = end;
		swap ( data , low , pivotIndex );
		int lowerBound = low + 1;
		int upperBound = high;
		while ( lowerBound <= upperBound ) {
			if ( data[lowerBound] > data[low] ) {
				swap ( data , lowerBound , upperBound );
				upperBound--;
			}
			else {
				lowerBound++;
			}
			// System.out.println ( arrayStr ( data ) );
		}
		swap( data , low , upperBound );
		return upperBound;
	}
	*/

	public static int partition ( int[]data , int start , int end ) {
		int pivotIndex = (int)(Math.random( ) * (end - start)) + start;
		System.out.println ( "Pivot number: " + data[pivotIndex] + "\n" );
		int low = start;
		int high = end;
		swap ( data , low , pivotIndex );
		int lowerBound = low;
		int current = lowerBound + 1;
		int upperBound = high;
		while ( current <= upperBound ) {
			System.out.println ( arrayStr ( data ) + "\nlowerBound: " + lowerBound + "\ncurrent: " + current + "\nupperBound: " + upperBound + "\n"  );
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
			// System.out.println ( arrayStr ( data ) );
		}
		// swap( data , low , lowerBound - 1 );
		// System.out.println ( arrayStr ( data ) );
		return lowerBound;
	}

	public static int quickselect ( int[]data , int k ) {
		// boolean notPartitioned = true;
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

	public static void quickSort ( int[]data ) {
		sortHelp ( data , 0 , data.length - 1);
		/*
		int divider = partition ( data , 0 , data.length - 1 );
		System.out.println ( divider );
		System.out.println ( arrayStr ( data ) );
		
		System.out.println ( "------------------------" );
		System.out.println ( partition ( data , 0 , divider) );
		System.out.println ( arrayStr ( data ) );
		System.out.println ( "------------------------" );
		System.out.println ( partition ( data , divider , data.length - 1 ) );
		System.out.println ( arrayStr ( data ) );
		*/
	}

	public static void sortHelp ( int[]data , int start , int end ) {
		// System.out.println ( arrayStr ( data ) );
		if ( start >= end ) {
			// return;
		}
		else {
			// System.out.println ( arrayStr ( data ) );
			int divider = partition ( data , start , end );
			System.out.println( "" + "Start: " + start + "\nEnd: " + end + "\nDivider: " + divider );
			sortHelp ( data , start , divider );
			sortHelp ( data , divider + 1 , end);
		}
	}

}
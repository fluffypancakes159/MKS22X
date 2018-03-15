public class Quick {
	
	public static void main(String[] args) {
		int[] A = {13,8,4,19,-1,1,3,5,6,17};
		int[] B = {99,99,99,0,0,0,0,99,99,99};
		// partition ( A , 0 , A.length - 1);
		System.out.println ( arrayStr( A ) );
		/* 
		System.out.println ( quickselect ( A , 0 ) );
		System.out.println ( quickselect ( A , 1 ) );
		System.out.println ( quickselect ( A , 2 ) );
		System.out.println ( quickselect ( A , 3 ) );
		System.out.println ( quickselect ( A , 4 ) );
		System.out.println ( quickselect ( A , 5 ) );
		System.out.println ( quickselect ( A , 6 ) );
		System.out.println ( quickselect ( A , 7 ) );
		System.out.println ( quickselect ( A , 8 ) );
		System.out.println ( quickselect ( A , 9 ) );
		*/
		quickSort( A );
		System.out.println ( arrayStr( A ) );
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
		if ( start + 1 >= end ) {
			return;
		}
		else {
			int divider = partition ( data , start , end );
			sortHelp ( data , start , divider );
			sortHelp ( data , divider , end);
		}
	}

}
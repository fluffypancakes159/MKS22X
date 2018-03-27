public class Merge {
	
	public static void main(String[] args) {
		int[] A = {5, 3, 10, 12, 56, 6, 7, 34};
		int[] B = new int[8];
		int[] C = new int[100];
		for ( int i = 0 ; i < C.length ; i++ ) {
			C[i] = (int)(Math.random( ) * 100);
		}
		// merge ( B , A , 0 , 1 , 1 );
		
		// System.out.println ( arrayStr ( C ) );
		mergesort ( C );
		System.out.println ( isSorted (  C  ) );
		
	}

	public static boolean isSorted ( int[]ary ) {
		for ( int i = 0 ; i < ary.length - 1 ; i++ ) {
			if ( ary[i] > ary[i+1] ) {
				return false;
			}
		}
		return true;
	}

	public static String arrayStr ( int[]ary ) {
		String output = "[";
		for ( int i = 0 ; i < ary.length - 1; i++ ) {
			output += ary[i] + " , ";
		}
		output += ary[ary.length - 1] + "]";
		return output;
	}

	public static void mergesort ( int[]data ) {
		int[]temp = new int[data.length];
		mergeHelp ( data , temp , 0 , data.length - 1 );
	}

	public static void mergeHelp ( int[]data , int[]temp , int lo , int hi ) {
		int mid = (lo + hi) / 2;
		// System.out.println( "" + lo + " / " + mid + " / " + hi );
		//System.out.println( arrayStr ( temp ) );
		if ( lo + 3 >= hi ) {
			insertion ( data , lo , hi );
			return;
		}
		for ( int i = lo ; i <= hi ; i++ ) {
			temp[i] = data[i];
		}
		mergeHelp ( temp , data , lo , mid );
		mergeHelp ( temp , data , mid + 1 , hi );
		merge ( data , temp , lo , mid + 1 , hi );
	}

	public static void merge ( int[]data , int[]temp , int lo , int mid , int hi ) {
		int current = lo;
		int left = lo;
		int right = mid;
		while ( left < mid  && right <= hi ) {
			// System.out.println( "temp[left]: " + temp[left] + "\ntemp[right]: " + temp[right] );
			if ( temp[left] <= temp[right] ) {
				//System.out.println(temp[i]);
				data[current] = temp[left];
				left++;
			}
			else {
				//System.out.println(temp[j]);
				data[current] = temp[right];
				right++;
			}
			current++;
			// System.out.println ( arrayStr ( data ));
			// System.out.println( arrayStr(temp));
		}
		if ( left < mid ) {
			for ( int n = left ; n < mid ; n++ ) {
				data[current] = temp[n];
				current++;
			}
		}
		if ( right <= hi) {
			// System.out.println ( "hello ");
			for ( int n = right ; n <= hi ; n++ ) {
				data[current] = temp[n];
				current++;
			}
		}
		// System.out.println ( arrayStr( data ));
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

}
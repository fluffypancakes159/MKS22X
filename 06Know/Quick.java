public class Quick {
	
	public static void main(String[] args) {
		int[] A = {13,8,4,19,4,-1,1,3,5,6,17};
		partition ( A , 0 , A.length - 1);
		System.out.println ( arrayStr( A ) );
	}

	public static int partition ( int[]data , int start , int end ) {
		int pivotIndex = (int)(Math.random( ) * data.length);
		int low = start;
		int high = end;
		swap ( data , 0 , pivotIndex );
		int lowerBound = low + 1;
		int upperBound = high;
		while ( lowerBound <= upperBound ) {
			if ( data[lowerBound] > data[0] ) {
				swap ( data , lowerBound , upperBound );
				upperBound--;
			}
			else {
				lowerBound++;
			}
		}
		swap( data , 0 , upperBound );
		return upperBound;
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

}
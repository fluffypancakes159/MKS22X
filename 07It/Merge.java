import java.util.Arrays;

public class Merge {
	
	public static void main(String[] args) {
		int[] A = {1,2,21,17,11,11,17,17};
		int[] B = new int[8];
		int[] C = new int[20];
		for ( int i = 0 ; i < C.length ; i++ ) {
			C[i] = (int)(Math.random( ) * 11) - 5;
		}
		
		/*
		merge ( A , B , 0 , 1 , 1 );
		merge ( A , B , 2 , 3 , 3 );
		merge ( A , B , 4 , 5 , 5 );
		merge ( A , B , 6 , 7 , 7 );
		System.out.println ( arrayStr( A ));
		merge ( B , A , 0 , 1 , 3 );
		merge ( B , A , 4 , 5 , 7 );
		System.out.println ( arrayStr( B ));
		*/
		/*
		int[] ans = Arrays.copyOf( C , C.length );
		Arrays.sort(ans);
		*/
		/*
		mergeHelp ( A , B , 0 , 7 );
		System.out.println ( arrayStr(A));
		System.out.println ( arrayStr(B));
		*/
		// System.out.println ( arrayStr( A ));
		
		// System.out.println ( arrayStr ( C ) );
		// insertion ( A , 2 ,3 );
		System.out.println ( arrayStr ( C ) );
		mergesort ( C );
		System.out.println ( arrayStr ( C ) );
		// System.out.println ( arrayStr (ans));
		// System.out.println ( isSorted ( C ) ); 
		
		// System.out.println ( isSorted (  C  ) );
		
	}

	public static boolean isSorted ( int[]ary ) {
		int[] ans = Arrays.copyOf( ary , ary.length);
		return ans.equals(ary);
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
		
		if ( lo + 7 >= hi ) {
			insertion ( data , lo , hi );
			return;
		}
		
		/*
		if ( lo >= hi ) {
			return;
		}
		*/
		for ( int i = lo ; i <= hi ; i++ ) {
			temp[i] = data[i];
		}
		mergeHelp ( temp , data , lo , mid );
		mergeHelp ( temp , data , mid + 1 , hi );
		merge ( data , temp , lo , mid , hi );
	}

	public static void merge ( int[]data , int[]temp , int lo , int mid , int hi ) {
		// System.out.println ( "Merging between " + lo + " and " + hi );
		int current = lo;
		int left = lo;
		int right = mid + 1;
		while ( left <= mid && right <= hi ) {
			// System.out.println( "temp[left]: " + temp[left] + "\ntemp[right]: " + temp[right] );
			if ( temp[left] <= temp[right] ) {
				data[current] = temp[left];
				left++;
			}
			else {
				data[current] = temp[right];
				right++;
			}
			/*
			System.out.println ( "Current: " + current );
			System.out.println ( "Data: " + arrayStr ( data ));
			System.out.println( "Temp: " + arrayStr(temp));
			*/
			current++;
		}
		if ( left <= mid ) {
			for ( int n = left ; n <= mid ; n++ ) {
				data[current] = temp[n];
				/*
				System.out.println ( "Current: " + current );
				System.out.println ( "Data: " + arrayStr ( data ));
				*/
				current++;
			}
		}
		if ( right <= hi) {
			for ( int n = right ; n <= hi ; n++ ) {
				data[current] = temp[n];
				/*
				System.out.println ( "Current: " + current );
				System.out.println ( "Data: " + arrayStr ( data ));
				*/
				current++;
			}
		}
		// System.out.println ( arrayStr( data ));
	}

	public static void insertion ( int[]data , int lo , int hi ) {
		// System.out.println( "insertion sorting between " + lo + " and " + hi);
		int current = lo + 1;
		while ( current <= hi ) {
			move ( data , current , lo );
			current++;
		}
		// System.out.println ( arrayStr (data) );
	}

	public static void move ( int[]data , int index , int lo ) {
		int current = index;
		int value = data[index];
		while ( current > lo && value <= data[current-1] ) {
			data[current] = data[current-1];
			// System.out.println ( arrayStr ( data ) );
			current--;
		}
		data[current] = value;
		// System.out.println ( arrayStr ( data ) );
	}

}
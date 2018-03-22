public class Merge {
	
	public static void main(String[] args) {
		int[] A = {3, 5, 6, 12, 12, 5, 6, 56, 7};
		mergeSort ( A );
		System.out.println ( arrayStr ( A ) );
	}

	public static String arrayStr ( int[]ary ) {
		String output = "[";
		for ( int i = 0 ; i < ary.length - 1; i++ ) {
			output += ary[i] + " , ";
		}
		output += ary[ary.length - 1] + "]";
		return output;
	}

	public static void mergeSort ( int[]data ) {
		int[]temp = new int[data.length];
		mergeHelp ( data , temp , 0 , data.length - 1 );
	}

	public static void mergeHelp ( int[]data , int[]temp , int lo , int hi ) {
		int mid = (lo + hi) / 2;
		System.out.println( "" + lo + " / " + mid + " / " + hi );
		//System.out.println( arrayStr ( temp ) );
		if ( lo >= hi ) {
			return;
		}
		for ( int i = lo ; i <= hi ; i++ ) {
			temp[i] = data[i];
		}
		mergeHelp ( temp , data , lo , mid );
		mergeHelp ( temp , data , mid + 1 , hi );
		merge ( data , temp , lo , mid , hi );
	}

	public static void merge ( int[]data , int[]temp , int lo , int mid , int hi ) {
		int current = lo;
		int i = lo;
		int j = mid;
		while ( i < mid && j < hi ) {
			if ( data[i] <= data[j] ) {
				//System.out.println(temp[i]);
				temp[current] = data[i];
				i++;
			}
			else {
				//System.out.println(temp[j]);
				temp[current] = data[j];
				j++;
			}
			current++;
			System.out.println( arrayStr(data));
		}
	}

}
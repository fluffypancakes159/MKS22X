public class Sorts {

	public static void main(String[] args) {
		MyLinkedListImproved<Integer> A = new MyLinkedListImproved<>( );
		A.add( 2 );
		A.add( 1 );
		A.add( 5 );
		A.add( 10 );
		A.add( 18 );
		A.add( 4 );
		A.add( 24 );
		A.add( 25 );
		A.add( -7 );
		A.add( 32 );
		A.add( -25 );
		A.add( -77 );
		A.add( -61 );
		A.add( 15 );
		A.add( 47 );
		// System.out.println( A );
		Sorts.radixSort( A );
		System.out.println( A );
		// System.out.println( -15 % 100 );
		/*
		MyLinkedListImproved<Integer> B = new MyLinkedListImproved<>( );
		MyLinkedListImproved<Integer> C = new MyLinkedListImproved<>( );
		C.add( 10 );
		B.extend(C);
		System.out.println( B );
		*/
	}

	public static String arrayStr ( MyLinkedListImproved[]ary ) {
		String output = "[";
		for ( int i = 0 ; i < ary.length - 1; i++ ) {
			output += ary[i] + " , ";
		}
		output += ary[ary.length - 1] + "]";
		return output;
	}

	public static void radixSort ( MyLinkedListImproved<Integer> data ) {
		@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[19];
		int digitCount = 1;
		// MyLinkedListImproved<Integer> test = new MyLinkedListImproved<>( );
		// System.out.println(data);
		// System.out.println(data.max() + " max");
		for ( int i = 1 ; Math.pow( 10 , i ) <= data.get(data.max( )) ; i++ ) {
			digitCount++;
		}
		// System.out.println( digitCount );
		for ( int i = 0 ; i < 19 ; i++ ) {
			buckets[i] = new MyLinkedListImproved<Integer>( );
		}
		for ( int i = 0 ; i < digitCount ; i++ ) {
			for ( Integer inte : data ) {
				// System.out.println(arrayStr(buckets) + " buckets" );
				int place = (int)(inte / Math.pow( 10 , i));
				// System.out.println ( inte );
				buckets[(place % 10) + 9].add(inte);
			}
			data.clear( );
			for ( int j = 0 ; j < 19 ; j++ ) {
				data.extend(buckets[j]);
				// test.extend(buckets[j]);
			}
			// System.out.println(test);
		}
		return;
	}

}
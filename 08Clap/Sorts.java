public class Sorts {

	public static void main(String[] args) {
		
	}

	public static void radixSort ( MyLinkedListImproved<Integer> data ) {
		Integer[] buckets = new Integer[10];
		int digitCount = 0;
		for ( int i = 0 ; Math.pow( 10 , i ) < data.max( ) ; i++ ) {
			digitCount = i + 1;
		}
		for ( int i = 0 ; i < digitCount ; i++ ) {
			for ( Integer inte : data ) {
				buckets[(inte / Math.pow( 10 , i)) % 10] = inte;
			}
			
		}
		return;
	}

}
public class quickselect {

	public static void main(String[] args) {
		int[] A = {13,8,4,19,4,-1,1,3,5,6,17};
		System.out.println( partition ( A , 0 , 0 ) );
	}

	public static int partition ( int[]data , int start , int end ) {
		int[] dump = new int[data.length];
		int pivotIndex = (int)(Math.random( ) * data.length);
		int pivotValue = data[pivotIndex];
		System.out.println( "" + pivotIndex + ": " + pivotValue );
		int lowerBound = 0;
		int upperBound = data.length - 1;
		for ( int i = 0 ; i < data.length ; i++ ) {
			if ( data[i] < pivotValue ) {
				dump[lowerBound] = data[i];
				lowerBound++;
			}
			if ( data[i] > pivotValue ) {
				dump[upperBound] = data[i];
				upperBound--;
			}
		}
		System.out.println( arrayStr ( dump ) );
		return lowerBound;
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
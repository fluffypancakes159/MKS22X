import java.util.LinkedList;

public class Calculator {

	public static void main(String[] args) {
		System.out.println( eval( "1 2 + 3 +") );
		System.out.println( eval( "1 2 * 3 +") );
		System.out.println( eval( "5 2 * 6 + 4 / ") );
	}

	public static double eval ( String exp ) {
		Stack stack = new Stack ( exp.length( ) );
		String currentToken = ""; 
		char currentChar = ' ';
		for ( int i = 0 ; i < exp.length( ) ; i++ ) {
			currentChar = exp.charAt(i);
			// System.out.println( "Char: |" + currentChar + "|" );
			// System.out.println( "Token: |" + currentToken + "|" );
			if ( currentChar == ' ' ) {
				stack.push( Double.parseDouble( currentToken ) );
				// System.out.println ( stack );
				currentToken = ""; 
			}
			else if ( currentChar > 47 ) {
				currentToken += currentChar;
			}
			else {			
				if ( currentChar == '+' ) {
					stack.push( stack.pop( ) + stack.pop( ) );
				}
				else if ( currentChar == '*' ) {
					stack.push( stack.pop( ) * stack.pop( ) );
				}
				else if ( currentChar == '-' ) {
					double second = stack.pop( );
					double first = stack.pop( );
					stack.push( first - second );
				}
				else if ( currentChar == '/' ) {
					double second = stack.pop( );
					double first = stack.pop( );
					stack.push( first / second );
				}
				else if ( currentChar == '%' ) {
					double second = stack.pop( );
					double first = stack.pop( );
					stack.push( first % second );
				}
				// System.out.println ( stack );
				i++;
			}
		}
		return stack.getFirst( );
	}

	private static class Stack {

		double[] data;
		int size;
		int end;

		public Stack ( int size ) {
			this.data = new double[size];
			this.size = 0;
			this.end = -1;
		}

		public void push ( double num ) {
			end++;
			data[end] = num;
			size++;
			return;
		}

		public double pop ( ) {
			double elem = data[end];
			data[end] = 0;
			end--;
			size--;
			return elem;
		}

		public double getFirst ( ) {
			return data[end];
		}

		public String toString ( ) {
			return arrayStr ( data );
		}

		public static String arrayStr ( double[]ary ) {
		String output = "[";
		if ( ary.length == 0 ) {
			return "[ ]";
		} 
		for ( int i = 0 ; i < ary.length - 1; i++ ) {
			output += ary[i] + " , ";
		}
		output += ary[ary.length - 1] + "]";
		return output;
	}

	}

}
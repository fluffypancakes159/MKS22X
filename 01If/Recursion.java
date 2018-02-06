import java.util.*;

public class Recursion {

	public static void main(String[] args) {
		System.out.println ( fact(0) );
		System.out.println ( fact(3) );
		System.out.println ( fact(4) );
		System.out.println ( fact(5) );

		System.out.println ( fib(0) );
		System.out.println ( fib(3) );
		System.out.println ( fib(4) );
		System.out.println ( fib(5) );

		System.out.println ( sqrt(0) );
		System.out.println ( sqrt(2) );
		System.out.println ( sqrt(4) );
		System.out.println ( sqrt(16) );
		System.out.println ( sqrt(0.0004) );

	}

	public static void errorCheck ( int n ) {
		if ( n < 0 ) {
			throw new IllegalArgumentException();
		}
	}

	public static void errorCheck ( double n ) {
		if ( n < 0 ) {
			throw new IllegalArgumentException();
		}
	}

	public static int fact ( int n ) {
		errorCheck ( n );
		if ( n < 2 ) {
			return 1;
		}
		else {
			return fact ( n - 1 ) * n;
		}
	}

	public static int fib ( int n ) {
		errorCheck ( n );
		if ( n < 2 ) {
			return n;
		}
		return fibHelp ( n , 0 , 1 );
	}

	public static int fibHelp ( int n , int num1 , int num2 ) {
		if ( n == 0 ) {
			return num1;
		}
		return fibHelp ( n - 1 , num2 , num1 + num2 );
	}

	public static double sqrt ( double n ) {
		errorCheck ( n );
		if ( n == 0 || n == 1 ) {
			return n;
		}
		return sqrtHelp ( n , n / 2.0 ); // default guess is just the given number divided by 2
	}

	public static double sqrtHelp ( double n , double guess ) {
		if ( Math.abs( n - guess * guess ) < n * 0.00000000001 ) { // very small difference allowed proportional to n
			return guess;
		}
		return sqrtHelp ( n , ( n / guess + guess) / 2 );
	}

}
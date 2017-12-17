package recursionI;

public class FibonacciNumber {
	// Method 1: recursion, this method will timeout
	public long fibonacci(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		return fibonacci(k - 1) + fibonacci(k - 2);
	}
	
	// Method 2: dp solution with O(n) space
	public long fibonacciI(int k) {
		if (k <= 0) {
			return 0;
		}
		long[] array = new long[k + 1];
		array[1] = 1;
		for (int i = 2; i <= k; i++) {
			array[i] = array[i - 2] + array[i - 1];
		}
		return array[k];
	}
	
	// Method 3: dp solution with O(1) space
	public long fibonacciII(int k) {
		long a = 0;
		long b = 1;
		if (k <= 0) {
			return a;
		}
		while (k > 1) {
			long temp = a + b;
			a = b;
			b = temp;
			k--;
		}
		return b;
	}
	
	// Method 4: O(logn) solution using matrix multiplication.
	// M = {{1, 1}, {1, 0}} = {{f(2), f(1)}, {f(1), f(0)}}
	// fibo(k) = (M ^ K)[0][0]
	
	public static final long[][] SEED = {{1L, 1L}, {1L, 0L}};
	
	public long fibonacciIII(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		long[][] matrix = {{1L, 1L}, {1L, 0L}};
		pow(matrix, k - 1);
		return matrix[0][0];
	}
	
	// calculate matrix ^ pow, and use the result to update matrix value
	private void pow(long[][] matrix, int pow) {
		if (pow == 1) {
			return;
		}
		pow(matrix,  pow / 2);
		multiply(matrix, matrix);
		if (pow % 2 != 0) {
			multiply(matrix, SEED);
		}
	}
	
	// matrix multiplication and the result is updated to matrix itself.
	private void multiply(long[][] matrix, long[][] multiplier) {
		long topLeft = matrix[0][0] * multiplier[0][0] + matrix[0][1] * multiplier[1][0];
		long topRight = matrix[0][0] * multiplier[0][1] + matrix[0][1] * multiplier[1][1];
		long botLeft = matrix[1][0] * multiplier[0][0] + matrix[1][1] * multiplier[1][0];
		long botRight = matrix[1][0] * multiplier[0][1] + matrix[1][1] * multiplier[1][1];
		
		matrix[0][0] = topLeft;
		matrix[0][1] = topRight;
		matrix[1][0] = botLeft;
		matrix[1][1] = botRight;
	}
}

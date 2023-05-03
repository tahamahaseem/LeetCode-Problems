class Solution {
	 public static double myPow(double x, int n) {
		double product = x, reserve = 1, power = n;

		if (n == 0) {//if power is 0 then answer will be always 1
			return 1;
		} else if (n == 1) {//if power is 1 then answer will be always the base value x
			return x;
		}

		if (power < 0) {
			power *= -1;// converts negative power to positive
		}
		while (power > 1) {
			if (power % 2 == 1) {// checks if the power n is odd
				power--;// convert odd power to even
				reserve *= product;// accommodates for odd power
			}

			// squaring the base and dividing the power by 2 is the same as x^n
			product *= product;
			power /= 2;
		}
		 //checks if intial power was negative, if so returns the reciporal.
		return n < 0 ? 1 / (product * reserve) : product * reserve;// if power is odd, reserve will not be 1.

	}
}

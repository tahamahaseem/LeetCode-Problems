class Solution {
public static String numberToWords(int num) {
		Map<Integer, String> store = new HashMap<>();

		// all possible key value pairs for english word representation of integers
		
        if(num == 0) {
			return "Zero";
		}
    
		store.put(1, "One");
		store.put(2, "Two");
		store.put(3, "Three");
		store.put(4, "Four");
		store.put(5, "Five");
		store.put(6, "Six");
		store.put(7, "Seven");
		store.put(8, "Eight");
		store.put(9, "Nine");
		store.put(10, "Ten");
		store.put(11, "Eleven");
		store.put(12, "Twelve");
		store.put(13, "Thirteen");
		store.put(14, "Fourteen");
		store.put(15, "Fifteen");
		store.put(16, "Sixteen");
		store.put(17, "Seventeen");
		store.put(18, "Eighteen");
		store.put(19, "Nineteen");
		store.put(20, "Twenty");
		store.put(30, "Thirty");
		store.put(40, "Forty");
		store.put(50, "Fifty");
		store.put(60, "Sixty");
		store.put(70, "Seventy");
		store.put(80, "Eighty");
		store.put(90, "Ninety");
		store.put(100, "Hundred");
		store.put(1000, "Thousand");
		store.put(1000000, "Million");
		store.put(1000000000, "Billion");

		String numString = Integer.toString(num);

		int numLength = numString.length();
		String hundreds = null, thousands = null, millions = null, billions = null;

		if (numLength > 9) {
			billions = numString.substring(0, numLength - 9);
			millions = numString.substring(billions.length(), numLength - 6);
			thousands = numString.substring(millions.length() + 1, numLength - 3);
			hundreds = numString.substring(numLength - 3);

		} else if (numLength > 6) {
			millions = numString.substring(0, numLength - 6);
			thousands = numString.substring(millions.length(), numLength - 3);
			hundreds = numString.substring(numLength - 3);
		} else if (numLength > 3) {
			thousands = numString.substring(0, numLength - 3);
			hundreds = numString.substring(numLength - 3);
		} else {
			hundreds = numString.substring(0);
		}

		String[] placings = new String[] { billions, millions, thousands, hundreds };

		int remainder = 0, quotient;
		String temp = "", englishRep = "";
		for (int i = 0; i < placings.length; i++) {

			if (placings[i] != null &&  Integer.parseInt(placings[i]) != 0) {

				int placingInt = Integer.parseInt(placings[i]);

				do {
					quotient = placingInt;
					if (placingInt <= 20) {
						temp += store.get(placingInt) + " ";
						break;
					} else if (placingInt < 100) {

						remainder = quotient % 10;
						quotient /= 10;
						temp += store.get(quotient * 10) + " "
								+ (remainder == 0 ? "" : store.get(remainder) + " ");
						break;
					} else {
						remainder = quotient % 100;
						quotient /= 100;
						temp = store.get(quotient) + " " + store.get(100) + " ";
						placingInt = remainder;
						

					}

				} while (remainder != 0);

				
				if (i == 0) {// in billions
					temp += store.get(1000000000) + " ";
				} else if (i == 1) {// in millions
					temp += store.get(1000000) + " ";
				} else if (i == 2) {// in thousands
					temp += store.get(1000) + " ";
				}

				englishRep += temp;
				temp = "";
			}

		}

		return englishRep.trim();

	}
}
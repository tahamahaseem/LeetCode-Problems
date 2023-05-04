class Solution {
public static String numberToWords(int num) {
		Map<Integer, String> store = new HashMap<>();

		// if the num is 0, then return Zero
		if (num == 0) {
			return "Zero";
		}

		// all possible key value pairs for english word representation of integers
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

		String numString = Integer.toString(num);// converts num to a string to perform substring operation

		int numLength = numString.length();// holds the length of the num to determine decimal places like tens, hundredths
											// etc
		String hundreds = null, thousands = null, millions = null, billions = null;

		// This block of code divides the number into 4 decimal places (billions, millions, thousands and hundredth place)
		if (numLength > 9) {// checks if num has billions place
			
			billions = numString.substring(0, numLength - 9);
			millions = numString.substring(billions.length(), numLength - 6);
			thousands = numString.substring(millions.length() + 1, numLength - 3);
			hundreds = numString.substring(numLength - 3);

		} else if (numLength > 6) {// checks if num has millions place
			
			millions = numString.substring(0, numLength - 6);
			thousands = numString.substring(millions.length(), numLength - 3);
			hundreds = numString.substring(numLength - 3);

		} else if (numLength > 3) {// checks if num has thousands place
			
			thousands = numString.substring(0, numLength - 3);
			hundreds = numString.substring(numLength - 3);

		} else {// num is less than thousands place
			hundreds = numString.substring(0);
		}

		String[] placings = new String[] { billions, millions, thousands, hundreds };// decimal places are put into an array

		int remainder = 0, quotient;
		String temp = "", englishRep = "";// temp holds temporarily parts of the English representations, englishRep will
											// hold the final sentence
		for (int i = 0; i < placings.length; i++) {

			if (placings[i] != null && Integer.parseInt(placings[i]) != 0) {// checks if the current decimal place in array
																			// is not null and not zero.

				int placingInt = Integer.parseInt(placings[i]);

				do {//loops until placing has been constructed into English
					quotient = placingInt;
					if (placingInt <= 20) {//first 20 numbers in the number system have unique names so therefore they require a special case
						
						temp += store.get(placingInt) + " ";//gets the exact value from the store
						break;//we are done breaks the loop and goes to the next placing
						
					} else if (placingInt < 100) {//the first 99 numbers in the number system repeat again in different decimal places, therefore they need their own case

						remainder = quotient % 10;//returns the integer ones place 
						quotient /= 10;//returns the integer of the hundredth and tenth place 
						
						//translates the numerical values to English using the store. Note that it checks if remainder is zero so that it does not print a Zero/null for the tenths and ones place. For example for 50, "Fifty Zero" or "Fifty null" does not make sense.
						temp += store.get(quotient * 10) + " " + (remainder == 0 ? "" : store.get(remainder) + " ");
						
						break;//we are done breaks the loop and goes to the next placing
						
					} else {//if the placing portion is greater than 99
						
						remainder = quotient % 100;//returns the integer of the tenth and ones place 
						quotient /= 100;//returns the integer of the hundredth place 
						
						//translates the numerical values to English using the store. Only returns the hundredth place
						temp = store.get(quotient) + " " + store.get(100) + " ";
						
						//sets the tenth and ones to placingInt such that the loop, loops back to decompose that rest of the remaining tenth and ones place
						placingInt = remainder;

					}

				} while (remainder != 0);

				if (i == 0) {//adds billion to the current placing aka the temp string
					temp += store.get(1000000000) + " ";
				} else if (i == 1) {//adds million to the current placing aka the temp string
					temp += store.get(1000000) + " ";
				} else if (i == 2) {//adds thousand to the current placing aka the temp string
					temp += store.get(1000) + " ";
				}

				englishRep += temp;//adds it to the final sentence variable
				temp = "";//resets temp for the next decimal place
			}

		}
		
		//trims any empty space at the front and back of the sentence and returns final sentence
		return englishRep.trim();

	}
}
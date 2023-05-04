class Solution {
    public static int lengthOfLongestSubstring(String s) {

		ArrayList<Character> store = new ArrayList<Character>();
		int length, longest = 0;
		char current;
		
		if(s.length() == 1) {
			return 1;
		}
		
		for (int i = 0; i < s.length()-1; i++) {
			current = s.charAt(i);
			store.add(current);
			length = 1;
			for (int j = i + 1; j < s.length(); j++) {
				
				

				if (store.contains(s.charAt(j))) {
					break;
				} else {
					length++;
					store.add(s.charAt(j));
				}
			}
			if (length > longest) {
				longest = length;
			}
			length = 1;
			store = new ArrayList<Character>();

		}

		return longest;

	}
}
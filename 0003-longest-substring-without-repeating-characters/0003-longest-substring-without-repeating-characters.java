class Solution {
    public int lengthOfLongestSubstring(String s) {
    
    Set<Character> characters = new HashSet<>();

    if (s.length() == 0) return 0;

    if (s.length() == 1) return 1;

    //Setup
    int highestLength = 0;
    int leftPointer = 0;

    for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
        char currentChar = s.charAt(rightPointer);
        while (characters.contains(currentChar)) {
            characters.remove(s.charAt(leftPointer));
            leftPointer++;
        }

        characters.add(currentChar);
        highestLength = Math.max(highestLength, characters.size());
    }

    return highestLength;        
    }
}
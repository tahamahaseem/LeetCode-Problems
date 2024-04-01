class Solution {
    public int lengthOfLastWord(String s) {
        int space = s.trim().lastIndexOf(' ');
        return s.trim().substring(space+1).length();
    }
}
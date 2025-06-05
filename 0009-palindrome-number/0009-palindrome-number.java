class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        else if (x <= 9)
            return true;

        boolean isPalindrome = true;
        String[] nums = Integer.toString(x).split("");
        int i = 0;


        while (i < nums.length - 1 - i) {
            if (!nums[i].equals(nums[nums.length - 1 - i])) {
                isPalindrome = false;
                break;
            }
            i++;
        }

        return isPalindrome;
    }
}
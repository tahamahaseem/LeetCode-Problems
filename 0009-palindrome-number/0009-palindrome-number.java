class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x <= 9)
            return true;

        boolean isPalindrome = true;
        String[] nums = Integer.toString(x).split("");
        int i = 0;
        int j = nums.length - 1;


        while (i < j) {
            if (!nums[i].equals(nums[j])) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        return isPalindrome;
    }
}
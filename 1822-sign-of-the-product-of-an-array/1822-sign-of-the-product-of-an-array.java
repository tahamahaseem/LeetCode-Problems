import java.util.Arrays;

class Solution {

public static int arraySign(int[] nums) {
    
    	int sign = 1;
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length; i++) {
    			 sign = nums[i] < 0 ? sign * -1 : (nums[i] == 0 ? 0 : sign);
    	}
		return sign;
        
    }
    	
}
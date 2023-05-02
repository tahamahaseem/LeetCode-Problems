import java.util.Arrays;

class Solution {
public static int arraySign(int[] nums) {
    
    	int sign = 1;// assuming product is positive
    	for(int i = 0; i < nums.length; i++) {
            //switches sign upon finding a negative value. If find zero in array, sign becomes zero
    		sign = nums[i] < 0 ? sign * -1 : (nums[i] == 0 ? 0 : sign);
    	}
		return sign;//return the sign
        
    }
    	
}
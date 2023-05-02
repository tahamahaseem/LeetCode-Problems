import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    
public static int arraySign(int[] nums) {
    
    	int sign;//holds on the the sign of the product
    
        
        //searches for zeros in array
    	int[] zero = Arrays.stream(nums).filter(n -> n == 0).toArray();
    
        //searches for all negatives in array
    	nums = Arrays.stream(nums).filter(n -> n < 0).toArray();
    
        //checks if there is a zero (returns 0), if not then determines if there is odd or even number of negatives in array
    	sign = zero.length >= 1 ? 0 : (nums.length % 2 == 0 ? 1 : -1);
    
		return sign;
    	
        
    }
}
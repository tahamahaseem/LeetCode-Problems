class Solution {
public int[] twoSum(int[] nums, int target) {
    	int[] indecies = new int[2];
    	int complement;
    	for(int i = 0; i< nums.length; i++) {
            complement = target - nums[i];
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    if(nums[i] + nums[j] == target){
                    	if(i > j) {
                    		 indecies[1] = i;
                             indecies[0] = j;
                    	}else {
                    		 indecies[0] = i;
                             indecies[1] = j;
                    	}
                        break;
                       
                        
                    }
                }
                
            }
    	}
		return indecies;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> integerMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                //filter out values greater than target
                int difference = target - nums[i];
                if (integerMap.containsKey(difference))
                    return new int[]{integerMap.get(difference), i};
                    
                //store number into map
                integerMap.put(nums[i], i);
            }
            //return -1 indecies if no answer exists
            return new int[]{-1, -1};
        }
}
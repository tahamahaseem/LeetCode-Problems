class Solution {
public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> store = new HashMap();//look up table with key value pairs
		int compliment;
		for (int i = 0; i < nums.length; i++) {
			store.put(nums[i], i);//key holds the integers, and value holds the indecies of those integers

		}
		for(int i = 0; i<nums.length; i++) {//first number that will sum to target
			compliment = target - nums[i];//find second number that will sum to target
			if(store.containsKey(compliment) && store.get(compliment) != i) {
				nums = new int[]{i, store.get(compliment)};//makes new array with the integer indecies that add up to target
			}
			
		}
		return nums;
	}
}
class Solution {
public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> store = new HashMap();
		int compliment;
		for (int i = 0; i < nums.length; i++) {
			store.put(nums[i], i);

		}
		for(int i = 0; i<nums.length; i++) {
			compliment = target - nums[i];
			if(store.containsKey(compliment) && store.get(compliment) != i) {
				nums = new int[]{i, store.get(compliment)};
			}
			
		}
		return nums;
	}
}
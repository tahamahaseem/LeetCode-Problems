class Solution {
    
	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> nums = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
		int length = nums1.length >= nums2.length ? nums1.length : nums2.length;
		Arrays.sort(nums1);
	    Arrays.sort(nums2);
		
		for (int i = 0; i < length; i++) {

			if (i < nums1.length) {
				if (Arrays.binarySearch(nums2, nums1[i]) <= -1) {
					if (!(nums.get(0).contains(nums1[i]))) {
						nums.get(0).add(nums1[i]);
					}

				}
			}

			if (i < nums2.length) {
				if (Arrays.binarySearch(nums1, nums2[i]) <= -1) {
					if (!(nums.get(1).contains(nums2[i]))) {
						nums.get(1).add(nums2[i]);
					}
				}
			}

		}
		return nums;

	}
}
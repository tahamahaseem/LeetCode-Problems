class Solution {
    
	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
		List<List<Integer>> nums = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
		
        //gets the highest length from the two arrays
        int length = nums1.length >= nums2.length ? nums1.length : nums2.length;
        
        //sort arrays for Arrays.binarySearch
		Arrays.sort(nums1);
	    Arrays.sort(nums2);
		
        //iterates largest array number of times
		for (int i = 0; i < length; i++) {

			if (i < nums1.length) {//checks if iteration in not beyond the array size
				if (Arrays.binarySearch(nums2, nums1[i]) <= -1) {
					if (!(nums.get(0).contains(nums1[i]))) {//checks if no duplicate
						nums.get(0).add(nums1[i]);//adds the unique integer into the list
					}

				}
			}

			if (i < nums2.length) {//checks if iteration in not beyond the array size
				if (Arrays.binarySearch(nums1, nums2[i]) <= -1) {
					if (!(nums.get(1).contains(nums2[i]))) {//checks if no duplicate
						nums.get(1).add(nums2[i]);//adds the unique integer into the list
					}
				}
			}

		}
		return nums;

	}
}
class Solution {
    public static int pivotIndex(int[] nums) {

		int arraySum = IntStream.of(nums).sum();
		int leftSum = 0, rightSum = arraySum;
		int pivot, tempPivot = 0;
		for (int i = 0; i < nums.length; i++) {
			pivot = nums[i];
			rightSum -= pivot;
			leftSum += tempPivot;
			if (leftSum == rightSum) {
				return i;
			}
			tempPivot = pivot;

		}
		return -1;

	}
}
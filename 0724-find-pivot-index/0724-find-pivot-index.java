class Solution {
    public static int pivotIndex(int[] nums) {

		int arraySum = IntStream.of(nums).sum();//gets the sum of the array
        
		int leftSum = 0, rightSum = arraySum;//holds the left side and right side sums
		int pivot, tempPivot = 0;//pivot variables
        
		for (int i = 0; i < nums.length; i++) {
			pivot = nums[i];//trying all pivots from left to right
			
            //right sum increases and left sum decrease
            rightSum -= pivot;
            leftSum += tempPivot;
            
            //checks if the two sums are equal
			if (leftSum == rightSum) {
				return i;//returns the index of the correct pivot
			}
            
			tempPivot = pivot;//holds previous pivot to subtract from left side

		}
		return -1;//returns -1 if no index found

	}
}
class Solution {
    public int longestConsecutive(int[] nums) {
        //if size of array is 0 or 1, just return the length as consecutive seq
        if (nums.length <= 1) {
            return nums.length;
        }
        //create array to hashSet
        Set<Integer> integerSet = new HashSet<>();

        //adding each element in array to hashSet
        for (int num : nums)
            integerSet.add(num);

        //highest keeps track of the highest consecutive numbers found so far
        int highest = 1;

        //count keeps track of the highest consecutive numbers found in current state
        int count;


        for (int num : integerSet) {
            /* checking if number in hashset has left consecutive number.
            If it does not, it means it is the head/start of a potential
            sequence of consecutive numbers */
            if (!integerSet.contains(num - 1)) {
                count = 1;

                //if head, checks if next consecutive numbers exist in relative to the head
                while (true) {
                    if (integerSet.contains(num + count)) {
                        count++;
                    } else {
                        break;
                    }
                }
                /*checks if the highest is still higher than the new 
                length of consecutive numbers is found, and returns the greater */
                highest = Math.max(highest, count);
            }
        }
        //final result returned
        return highest; 
    }
}
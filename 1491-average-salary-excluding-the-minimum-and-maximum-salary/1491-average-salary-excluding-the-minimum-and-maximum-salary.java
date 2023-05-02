import java.util.Arrays;

class Solution {
	public double average(int[] salary) {
		double sum = 0;
		Arrays.sort(salary);//sorts array from lowest to highest salaries
		
        //iterates through the array but skips first and last (lowest and highest) salaries 
		for (int i = 1; i < salary.length - 1; i++) {
			sum += (double) salary[i];
		}
		
		return sum / (salary.length - 2);//returns sum with no min and max salary
	}
}

function missingRolls(rolls: number[], mean: number, n: number): number[] {
    let totalRolls: number = rolls.length + n; // This represents the total number of rolls, both observed and missing.
    
    let totalKnownValues: number = rolls.reduce((sum, roll) => sum + roll, 0); // Sum of all the values in the observed rolls array.
    
    let totalMissingValues: number = mean * totalRolls - totalKnownValues; // Reverse engineer to find the sum of missing rolls using the mean formula.

    // Base case: If no missing rolls, return an empty array (shouldn't normally occur with valid input).
    if(n == 0) { 
        return [];
    }
    
    // Base case: If there is only one missing observation, return it directly as the entire missing sum.
    else if (n == 1) { 
        return [totalMissingValues]; // Only one roll to determine, so it's the entire missing sum.
    }
    
    // General case: Distribute the missing values across multiple rolls
    else {
        let quotient: number;
        let leftOverMissingValues: number = totalMissingValues; // Start with the total sum of missing values.
        let result: number[] = []; // Array to store the resulting missing rolls.

        // Iterate over the number of missing observations
        for(let remainingObservations: number = n; remainingObservations > 0; remainingObservations--) {
            quotient = Math.ceil(leftOverMissingValues / remainingObservations); // Calculate the maximum possible value for the current roll.
            
            // Check if the calculated value is within the valid range for a dice roll (1 to 6)
            if (quotient <= 6 && quotient >= 1) {
                result.push(quotient); // If valid, add it to the result array.
            } else {
                return []; // If not valid, return an empty array (no valid solution exists).
            }
            
            leftOverMissingValues -= quotient; //Update left overs to calculate the next maximum possible dice roll.
        }
        
        // Return the array of missing rolls.
        return result;
    }
};

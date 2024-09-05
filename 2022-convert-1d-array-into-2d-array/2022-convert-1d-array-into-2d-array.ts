function construct2DArray(original: number[], m: number, n: number): number[][] {
    // Calculate the length of the original array.
    let length: number = original.length;
    
    // Check if it's possible to form a 2D array with m rows and n columns.
    if (n * m !== length) {
        return []; // Return an empty array if not possible.
    } else {
        // Initialize variables
        let currentArray: number = -1; // Index for tracking the current row in result. In the beginning there is no array intialized.
        let nextRowIndex: number = 0;  // Index for tracking the start of the next row in original array.
        let result: number[][] = [];   // Initialize the result array.

        // Iterate over each element in the original array.
        for (let i: number = 0; i < length; i++) {
            // Check if it's time to start a new row.
            if (i === nextRowIndex) {
                // Start a new row and push it to the result.
                result.push([original[nextRowIndex]]);
                // Move to the start index of the next row.
                nextRowIndex += n;
                // Move to the next row index.
                currentArray++;
            } else {
                // Add the element to the current row if it exists.
                if (Array.isArray(result[currentArray])) {
                    result[currentArray].push(original[i]);
                }
            }
        }
        // Return the constructed 2D array
        return result;
    }
}
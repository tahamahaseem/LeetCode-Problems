function missingRolls(rolls: number[], mean: number, n: number): number[] {
    let totalRolls: number = rolls.length + n;
    let totalKnownValues: number = rolls.reduce((sum, i) => sum + i, 0);
    let totalMissingValues: number = mean*(totalRolls) - totalKnownValues;
    if(n == 0){
        return [];
    }
    else if (n == 1){
        return [totalMissingValues]
    }
    else {
        let quotient: number;
        let leftOverMissingValues: number = totalMissingValues
        let result: number[] = [];
        for(let observation: number = n ; observation > 0 ; observation--){
             quotient = Math.ceil(leftOverMissingValues / observation);
            if (quotient <= 6 && quotient >= 1) {
                result.push(quotient);
            } else {
                return [];
                
            }
            leftOverMissingValues -= quotient;
        }
        return result;
    }
};
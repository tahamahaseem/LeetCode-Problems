function construct2DArray(original: number[], m: number, n: number): number[][] {
    let length: number = original.length;
    if(n * m !== length){
        return []
    }else{
        let currentArray: number = -1;
        let nextRowIndex: number = 0;
        let result: number[][] = [];
        for(let i: number = 0; i < length ; i++){
            if(i === nextRowIndex){
                result.push([original[nextRowIndex]]);
                nextRowIndex += n;
                currentArray++;
            } else {
                if(Array.isArray(result[currentArray])){
                    result[currentArray].push(original[i]);
                }
            }
           
        }
        return result;
    }
};
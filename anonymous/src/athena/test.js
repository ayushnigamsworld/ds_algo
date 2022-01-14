const arr = [3, 1, 2, 4, 5, 2, 5, 6, 7, 8];
const batchSize = 3;

[3, 1, 2, 4, 5, 2, 5, 6, 7, 8]

[3, 1, 2]

async function processBatch(arr, batchSize) {
    let promiseArr = [];
    let localB = 0;
    for (let current of arr) {
        promiseArr.push(internalProcessing(current));
        localB++;
        if (localB === batchSize) {
            await Promise.all(promiseArr);
            localB = 0;
            promiseArr = [];
        }
    }

    if (promiseArr.length > 0) {
        await Promise.all(promiseArr);
    }
}

async function internalProcessing(inp) {
    return new Promise( (resolve, reject) => {
        setTimeout( () => {
            console.log('hi') ;
            resolve();
        }, 1000 * inp);
    });
}


processBatch(arr, batchSize);
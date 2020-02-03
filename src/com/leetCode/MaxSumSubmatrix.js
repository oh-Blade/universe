
var maxSumSubmatrix = function(matrix, k) {
    const row = matrix.length;
    if (!row) return 0;
    const col = matrix[0].length;
    if (!col) return 0;

    let max = -Infinity;
    for (let l = 0; l < col; l++) {
        const list = new Array(row).fill(0);
        for (let r = l; r < col; r++) {
            for (let k = 0; k < row; k++) list[k] += matrix[k][r];
            const m = maxSubarraySumNoMoreThanK(list, k);
            max = Math.max(max, m);
        }
    }

    function maxSubarraySumNoMoreThanK(list, k) {
        let max = -Infinity;
        const preSum = [0];
        let accu = 0;
        for (let i = 0; i < list.length; i++) {
            accu += list[i];
            const index = findLowerBound(preSum, accu - k);
            const sum = accu - preSum[index];
            if (sum <= k) max = Math.max(max, sum);
            insert(preSum, accu);
        }
        return max;
    }

    function insert(nums, target) {
        if (target >= nums[nums.length - 1]) {
            nums.push(target);
            return;
        }
        const index = findLowerBound(nums, target);
        nums.splice(index, 0, target);
    }

    function findLowerBound(nums, target) {
        let l = 0;
        let r = nums.length - 1;
        while (l < r) {
            const mid = l + r >>> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    if (max === -Infinity) return 0;
    return max;
};

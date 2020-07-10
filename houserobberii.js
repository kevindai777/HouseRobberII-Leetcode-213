//Objective is the same as 'House Robber', except this time the first and
//last house in the list are also adjacent.

let nums = [2,3,2]


//O(n) solution that uses two dp arrays that start from the beginning and one
//after the beginning, then compares to the two arrays

if (nums.length < 2) {
    return nums[0] || 0
}

let start = [nums[0]]
let after = [0, nums[1]]

for (let i = 1; i < nums.length - 1; i++) {
    start[i] = Math.max(start[i - 1], (start[i - 2] || 0) + nums[i])
}

for (let i = 2; i < nums.length; i++) {
    after[i] = Math.max(after[i - 1], after[i - 2] + nums[i])
}

return Math.max(start.pop(), after.pop())
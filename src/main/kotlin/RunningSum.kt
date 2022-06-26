class RunningSum {

    fun runningSum(nums: IntArray): IntArray {
        val array = IntArray(nums.size)
        nums.forEachIndexed { index, num ->
            if(index==0){
                array[index] = num
            }else{
                array[index] = num+array[index-1]
            }
        }
        return array
    }

    fun pivotIndex(nums: IntArray): Int {
        var pIndex = -1
        // get sum in O(n)
        val sum = nums.sum()
        var leftSum = 0
        nums.forEachIndexed { index, num ->
            leftSum = if(index == 0) 0 else leftSum+nums[index-1]
            if(pIndex==-1 && leftSum == sum-(leftSum+num)) {
                pIndex = index
                return@forEachIndexed
            }
        }
        return pIndex
    }
}


fun main(){
    val runningSum = RunningSum()
    //println(runningSum.runningSum(intArrayOf(1,2,3,4)))
    println(runningSum.pivotIndex(intArrayOf(-1, -1, 0, 0, -1, -1)))
}
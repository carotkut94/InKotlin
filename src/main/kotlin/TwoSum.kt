fun main() {
    val s = TwoSum()
    val a = s.twoSum(intArrayOf(3,3), 6)
    a.forEach{
        print("$it \n")
    }
}

class TwoSum{
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val collection = mutableMapOf<Int, Int>()
        nums.forEachIndexed{index, value ->
            val remaining = target - value
            if(collection.contains(remaining)){
                return intArrayOf(collection[remaining]!!, index)
            }else{
                collection[value] = index
            }
        }
        return intArrayOf(0,1);
    }
}
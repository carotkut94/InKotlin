class NonDuplicateNumber {
    fun nonDuplicateNumber(nums: IntArray): Int{
        return nums.reduce { acc, i ->  acc xor i}
    }
}


fun main(){
    val s = NonDuplicateNumber()
    print(s.nonDuplicateNumber(intArrayOf(4,4,1,9,1,3,3,2,2,5,5,7,7,8,8)))
}
package algos

class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {

        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) return mid
            else if (nums[mid] > target) right = mid - 1
            else if (nums[mid] < target) left = mid + 1
        }
        return -1
    }
}


fun main(){
    val binarySearch = BinarySearch()
    print(binarySearch.search(intArrayOf(1,2,3,4,5,6,7), 5))
}

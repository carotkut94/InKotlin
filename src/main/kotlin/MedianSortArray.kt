fun main() {
    val s = MedianSortArray()
    val a = s.findMedianSortedArrays(intArrayOf(1,2),intArrayOf(3,4))
    print("$a \n")
}

class MedianSortArray {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val a = (nums1+nums2).sorted()
        return if(a.size%2 == 0){
            val trailingIndex = a.size/2
            (a[trailingIndex]+a[trailingIndex-1])/2.toDouble()
        }else{
            a[a.lastIndex/2].toDouble()
        }
    }
}

// Link to explanation
// In progress, finding more elegant ways to solve this

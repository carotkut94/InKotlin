fun main() {
    val s = MedianSortArray()
    val a = s.findMedianSortedArrays(intArrayOf(1,2),intArrayOf(3,4))
    print("$a \n")

    val l = Solution()
    print(l.findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
    print("$l \n")
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
// https://drive.google.com/file/d/1dWAKLqCQ3_i1Qf0hy2AIVgkedg210XAS/view?usp=sharing
// In progress, finding more elegant ways to solve this
// The partition way

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if(nums1.size>nums2.size){
            return findMedianSortedArrays(nums2, nums1)
        }
        val x = nums1.size
        val y = nums2.size
        var low = 0
        var high = x
        while(low<=high){
            val partitionX = ((low+high)/2).toInt()
            val partitionY = ((x+y+1)/2).toInt() - partitionX

            val maxX = if(partitionX==0) Integer.MIN_VALUE else nums1[partitionX - 1]
            val minX = if(partitionX==x) Integer.MAX_VALUE else nums1[partitionX]

            val maxY = if(partitionY==0) Integer.MIN_VALUE else nums2[partitionY - 1]
            val minY = if(partitionY==y) Integer.MAX_VALUE else nums2[partitionY]

            if(maxX <= minY && maxY <= minX){
                if((x+y)%2==0){
                    return (Math.max(maxX, maxY)+Math.min(minY, minX))/2.toDouble()
                }else{
                    return Math.max(maxX, maxY).toDouble()
                }
            }else if(maxX>minY){
                high = partitionX-1
            }else{
                low = partitionX+1
            }
        }
        return 0.toDouble()
    }
}

import kotlin.math.abs
import kotlin.math.min

/**
 * Problem Statement
 * There is a frog on the 1st step of an N stairs long staircase. The frog wants to reach the Nth stair.
 * HEIGHT[i] is the height of the (i+1)th stair.If Frog jumps from ith to jth stair,
 * the energy lost in the jump is given by |HEIGHT[i-1] - HEIGHT[j-1] |.In the Frog is on ith staircase
 * he can jump either to (i+1)th stair or to (i+2)th stair. Your task is to find the minimum total energy used by the frog to reach from 1st stair to Nth stair.
 */

class LetTheFrogJump {

    fun letTheFrogJump(n: Int, heights: IntArray): Int {
        return jump(n - 1, heights)
    }

    fun letTheFrogJumpDp(n: Int, heights: IntArray): Int {
        val dpData = IntArray(n + 1) { -1 }
        return dpJump(n - 1, heights, dpData)
    }

    private fun jump(index: Int, heights: IntArray): Int {
        if (index == 0) {
            return 0
        }
        val left = jump(index - 1, heights) + abs(heights[index] - heights[index - 1])
        var right = Int.MAX_VALUE
        if (index > 1) right = jump(index - 2, heights) + abs(heights[index] - heights[index - 2])
        return min(left, right)
    }

    private fun dpJump(index: Int, heights: IntArray, memoizedData: IntArray): Int {
        if (index == 0) {
            return 0
        }
        if (memoizedData[index] != -1) return memoizedData[index]

        val left = jump(index - 1, heights) + abs(heights[index] - heights[index - 1])
        var right = Int.MAX_VALUE
        if (index > 1) right = jump(index - 2, heights) + abs(heights[index] - heights[index - 2])
        memoizedData[index] = min(left, right)
        return memoizedData[index]
    }

    fun nonRecJump(n:Int, heights: IntArray): Int {
        val dp  = IntArray(n){
            0
        }

        for(i in 1 until n){
            val ss = dp[i-1] + abs(heights[i]-heights[i-1])
            var ds = Int.MAX_VALUE
            if(i>1) ds = dp[i-2] + abs(heights[i]-heights[i-2])
            dp[i] = min(ss, ds)
        }
        return dp.last()
    }

    fun spaceOptimizedJump(n:Int, heights: IntArray): Int {
        var previous = 0
        var previous2 = 0

        for(i in 1 until n){
            val ss = previous + abs(heights[i] - heights[i-1])
            var ds = Int.MAX_VALUE
            if(i>1) ds = previous2 + abs(heights[i]-heights[i-2])
            val current = min(ss, ds)
            previous2 = previous
            previous = current
        }
        return previous
    }
}

fun main() {
    val k = LetTheFrogJump()
    //print(k.letTheFrogJump(4, intArrayOf(10,20,30,10)))
    println(k.spaceOptimizedJump(4, intArrayOf(10, 20, 30, 10)))
    println(k.letTheFrogJumpDp(8, intArrayOf(7, 4, 4, 2, 6, 6, 3, 4)))
    println(k.nonRecJump(8, intArrayOf(7, 4, 4, 2, 6, 6, 3, 4)))
    println(k.spaceOptimizedJump(8, intArrayOf(7, 4, 4, 2, 6, 6, 3, 4)))
}
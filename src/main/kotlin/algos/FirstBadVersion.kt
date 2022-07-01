package algos

/**
 * Dummy implementation of class for
 * https://leetcode.com/problems/first-bad-version/
 */
abstract class VersionControl{
    fun isBadVersion(version: Int) : Boolean{
        return false
    }

    abstract fun firstBadVersion(n: Int): Int
}

class BadVersion: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var start = 1
        var end = n

        while(start<end){
            val mid = start+(end-start)/2
            if(isBadVersion(mid)){
                end = mid
            }else{
                start = mid+1
            }
        }

        return start
    }
}
class LetsClimb {
    private val data = mutableMapOf<Int, Int>()
    fun climbStairs(n: Int): Int {
        if(n<=1) return 1
        if(data.containsKey(n)) return data[n]!!
        val singleStep = climbStairs(n-1)
        val dualStep = climbStairs(n-2)
        data[n] = singleStep+dualStep
        return data[n]!!
    }

    var forOne = 1
    private var forTwo = 1
    fun climbStairsMemoSwap(n: Int): Int {
        repeat(n){
            forOne += forTwo.apply {
                forTwo = forOne
            }
        }

        return forTwo
    }
}


fun main(){
    val l = LetsClimb()
    print(l.climbStairsMemoSwap(4))
}
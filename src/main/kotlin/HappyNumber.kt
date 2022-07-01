class HappyNumber {

    private fun nextInt(n:Int):Int{
        var num = n
        var totalSum = 0
        while(num>0){
            val d = num%10
            num = n/10
            totalSum += d*d
        }
        return totalSum
    }

    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = nextInt(n)

        while (fast!=1 && slow != fast){
            slow = nextInt(slow)
            fast = nextInt(nextInt(fast))
        }

        return fast == 1
    }
}
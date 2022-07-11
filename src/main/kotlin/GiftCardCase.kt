class GiftCardCase {

    fun tellMeNumberOfGiftCards(n:Int):Int{
        var giftCards = 0
        val l = mutableListOf<Int>()
        var flag = false
        if(n<100){
            return giftCards
        }
        if(n<=1000){
            println("$n * 1")
            return 1
        }

        giftCards = n/1000 // number of gift cards that straight up to value of 1000 1100/1000 - 1 100
        val remaining = n%1000

        if(remaining >= 100){
            l.add(remaining)
        }else if(remaining!=0) {
            l.addAll(listOf(900, remaining+100))
            flag = true
        }

        if(flag){
            l.addAll(List<Int>(giftCards-1){1000})
        }else{
            l.addAll(List<Int>(giftCards){1000})
        }

        l.forEach {
            println("1 * $it")
        }

        return l.size
    }

    // partition
    /**
     * 1001
     * 1099 (1000, 99)
     * 2099 (1000, 1000, 99)
     *
     */

}

fun main(){
    val l = GiftCardCase()
    print(l.tellMeNumberOfGiftCards(1100))
}


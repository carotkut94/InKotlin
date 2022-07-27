class LetsPaint {
    fun solution(costs: MutableList<Int>): Int {
        var profit = 0
        var minIndex = 0
        for (i in 1 until costs.size){
            if(costs[i-1]>costs[i])
            {
                minIndex = i
            }
            if(costs[i-1] <= costs[i] && (i+1 == costs.size || costs[i]>costs[i-1])){
                profit += costs[i] - costs[minIndex]
            }
        }
        return profit
    }

    fun paintSolution(times:MutableList<MutableList<Int>>):Int{

        var lastPaintedIndex = 0
        var totalMinTime = 0
        times.forEachIndexed { index, time ->
            if(index==0){
                val minTime = time.minOrNull()!!
                lastPaintedIndex = time.indexOf(minTime)
                totalMinTime += minTime
            }else{
                val local = time.toList()
                val currentFence = time.also {
                    it.removeAt(lastPaintedIndex)
                }
                val minTime = currentFence.minOrNull()!!
                lastPaintedIndex = local.indexOf(minTime)
                totalMinTime += minTime
            }
        }
        return totalMinTime
    }
}

fun main(){
    val l = LetsPaint()
    println(l.solution(mutableListOf(6,5,3,7,1,4)))
}
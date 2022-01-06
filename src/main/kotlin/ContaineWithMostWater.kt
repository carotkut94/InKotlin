import kotlin.math.min
import java.util.Collections.max as cMax

class ContainerWithMostWater {
    fun theONSquareWay(a:IntArray){
        val maxArray = mutableListOf<Int>()
        a.forEachIndexed{index,item->
            var maxArea = 0
            for(i in index+1 until a.size){
                val h = item.coerceAtMost(a[i])
                val b = i-index;
                val area = h*b
                if(area>maxArea){
                    maxArea = area;
                    maxArray.add(maxArea)
                }
            }
        }

        print(cMax(maxArray))
    }

    fun theONWay(a:IntArray){
        var start = 0
        var end = a.size - 1
        var maxArea = 0
        while(start<end){
            val heightStart = a[start]
            val heightEnd = a[end]
            val area = min(heightStart, heightEnd) * (end-start)
            if(area>maxArea){
                maxArea = area
            }
            if(heightStart<heightEnd){
                start+=1
            }else{
                end-=1
            }
        }
        print(maxArea)
    }
}

fun main(){
    val s = ContainerWithMostWater()
    s.theONWay(intArrayOf(1,8,6,2,5,4,8,3,7))
}
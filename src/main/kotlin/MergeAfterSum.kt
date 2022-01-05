class MergeAfterSum {
    fun mergeSumAndSplit(s:IntArray, k:IntArray):List<Int>{
        val l = mutableListOf<Int>()
        s.forEachIndexed{index, item->
            var n = 0
            if(index!=k.size){
                n = k[index]
            }
            val sum = (item + n).toString()
            if(sum.length==2){
                l.add(sum[0].digitToInt())
                l.add(sum[1].digitToInt())
            }else{
                l.add(sum.toInt())
            }
        }
        return l.toList();
    }
}

fun main(){
    val m = MergeAfterSum()
    val k = intArrayOf(1,2,3,4,5)
    val s = intArrayOf(2,3,8,9)
    if(s.size>k.size){
        val l = m.mergeSumAndSplit(s, k)
        print("$l")
    }else{
        val l = m.mergeSumAndSplit(k, s)
        print("$l")
    }
}
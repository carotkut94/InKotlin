fun main() {
    val ints = intArrayOf(1,9,7,8,2,5,6,3).sorted()
    val targetSum = 8
    val result = mutableListOf<List<Int>>()

    for(i in 0..ints.size-3){
        var start = i+1
        var end = ints.size - 1


        while(start<end){
            var currentSum = ints[i]
            currentSum += ints[start]
            currentSum += ints[end]
            if(currentSum == targetSum){
                result.add(listOf(ints[i], ints[start], ints[end]))
                start+=1
                end-=1
            }else if(currentSum<targetSum){
                start+=1
            }else{
                end-=1
            }
        }
    }
}
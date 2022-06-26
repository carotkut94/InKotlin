fun main(){

    val array1 = intArrayOf(1,5,7,9)
    val array2 = intArrayOf(2,3,4,8,10)
    val mergedArray = mutableListOf<Int>()
    var p1 = 0
    var p2 = 0

    val maxLen = array2.size

    while(p1 < maxLen){
        if(p2 < array1.size){
            if(array2[p1]<array1[p2]){
                mergedArray.add(array2[p1])
                p1+=1
            }else{
                mergedArray.add(array1[p2])
                p2+=1
            }
        }else{
            mergedArray.add(array2[p1])
            p1+=1
        }
    }

    mergedArray.toTypedArray()
}
class PalindromicArray {
    fun isPalindromic(a:IntArray):Boolean{
        var start = 0
        var end = a.size-1

        while(start<end){
            if(a[start]!=a[end]){
                return false
            }
            start += 1
            end -= 1
        }
        return true
    }
}


fun main(){
    val s = PalindromicArray()
    print("${s.isPalindromic(intArrayOf(1,2,2,1))}")
    print("${s.isPalindromic(intArrayOf(1,2,3,1))}")
    print("${s.isPalindromic(intArrayOf(1,2,1))}")
}
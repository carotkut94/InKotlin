class SeventyFiveD2 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val visited = mutableMapOf<Char, Boolean>()
        val mappedPair = mutableMapOf<Char, Char>()
        for(i in s.indices){
            if(mappedPair.containsKey(s[i])){
                if(mappedPair[s[i]] != t[i])
                    return false
            }else{
                if(visited.containsKey(t[i])){
                    return false
                }else{
                    mappedPair[s[i]] = t[i]
                    visited[t[i]] = true
                }
            }
        }

        return true
    }
}

fun main(){
    val seventyFiveD2 = SeventyFiveD2()
    println(seventyFiveD2.isIsomorphic("egg", "add"))
}

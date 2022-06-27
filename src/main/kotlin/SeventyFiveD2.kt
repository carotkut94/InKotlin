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
    fun isSubsequence(s: String, t: String): Boolean {
        if(s.isEmpty()) return true
        if(t.length<s.length) return false

        var count = 0
        for(i in t.indices){
            if(t[i] == s[count]){
                count++
                if(count==s.length){
                    return true
                }
            }
        }

        return false
    }
}

fun main(){
    val seventyFiveD2 = SeventyFiveD2()
    println(seventyFiveD2.isIsomorphic("egg", "add"))
    println(seventyFiveD2.isSubsequence("ace", "abbcnnne"))
}

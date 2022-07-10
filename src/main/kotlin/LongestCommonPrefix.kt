class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]
        var res = ""
        for (i in 0 until strs.size - 1) {
            if (i == 0) {
                res = strs[i]
            }
            val s2 = strs[i + 1]
            res = res.commonPrefixWith(s2)
        }
        return res
    }
}

fun main() {
    val k = LongestCommonPrefix()
    print(k.longestCommonPrefix(arrayOf("reflower", "flow", "flight")))
}
fun main() {
    val s = "occurrence"
    val d = mutableMapOf<String, Int>()
    s.forEach{ c ->
        if(d.contains(c.toString())){
            d[c.toString()] = d.get(c.toString())!!+1
        }else{
            d[c.toString()] = 1
        }
    }

    d.forEach{entry->
        print("${entry.key}${entry.value}")
    }
}

// Link to explanation
// https://drive.google.com/file/d/1ldp9ikw6To8t3s6rwkT976AIIeJ0zmu7/view?usp=sharing


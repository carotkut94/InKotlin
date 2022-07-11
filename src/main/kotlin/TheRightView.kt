class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TheRightView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val l = mutableListOf<Int>()
        rightView(root, 0, l)
        return l
    }

    fun rightView(root:TreeNode?, level:Int, l:MutableList<Int>){
        if(root == null) return
        if(level >= l.size) l.add(root.`val`)

        rightView(root.right, level+1, l)
        rightView(root.left, level+1, l)
    }
}

fun main(){
    val l = TreeNode(1)
    l.right  = TreeNode(2)

    val t = TheRightView()
    val k = t.rightSideView(l)
    k.forEach {
        println(it)
    }
}
class SpiralIt {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        val rows = matrix.size
        val col = matrix.first().size
        var top = 0
        var bottom = rows - 1
        var left = 0
        var right = col - 1
        var direction = Direction.LEFTRIGHT
        while(top <= bottom && left <= right){
            when (direction) {
                Direction.LEFTRIGHT -> {
                    for(i in left..right){
                        result.add(matrix[top][i])
                    }
                    top+=1
                    direction = Direction.TOPBOTTOM
                }
                Direction.TOPBOTTOM -> {
                    for(i in top..bottom){
                        result.add(matrix[i][right])
                    }
                    right-=1
                    direction = Direction.RIGHTLEFT
                }
                Direction.RIGHTLEFT -> {
                    for(i in right downTo left){
                        result.add(matrix[bottom][i])
                    }
                    bottom-=1
                    direction = Direction.BOTTOMTOP
                }
                else -> {
                    for(i in bottom downTo top){
                        result.add(matrix[i][left])
                    }
                    left+=1
                    direction = Direction.LEFTRIGHT
                }
            }
        }
        return result.toList()
    }

}

enum class Direction{
    LEFTRIGHT,
    TOPBOTTOM,
    RIGHTLEFT,
    BOTTOMTOP,
}
class LetTheBallFall {

    fun findBall(grid: Array<IntArray>): IntArray {
        val resultArray = IntArray(grid[0].size)

        for(column in grid[0].indices){
           resultArray[column] = dfs(grid, 0, column)
        }

        return resultArray
    }

    private tailrec fun dfs(grid: Array<IntArray>, row: Int, column: Int): Int {
        if(row == grid.size){
            return column
        }

        if(column<0 || column>=grid[0].size){
            return  -1
        }

        if(grid[row][column] == 1 && column<grid[0].size-1 && grid[row][column+1]==grid[row][column]){
            return dfs(grid, row+1, column+1)
        }else if(grid[row][column] == -1 && column>0 && grid[row][column-1]==grid[row][column]){
            return dfs(grid, row+1, column-1)
        }
        return  -1
    }
}
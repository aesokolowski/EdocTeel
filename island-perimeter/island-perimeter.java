class Solution {
    private int[][] grid;
    private int coastCount;
    
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        coastCount = 0;
        
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                if (this.grid[i][j] == 1) {
                    howMuchCoast(i, j);
                }
            }
        }
        
        return coastCount;
    }
    
    private void howMuchCoast(int r, int c) {
        if (r - 1 < 0 || grid[r - 1][c] == 0) coastCount++;
        if (c - 1 < 0 || grid[r][c - 1] == 0) coastCount++;
        if (r + 1 >= grid.length || grid[r + 1][c] == 0) coastCount++;
        if (c + 1 >= grid[r].length || grid[r][c + 1] == 0) coastCount++;
        
        System.out.println(coastCount);
            
    }
}
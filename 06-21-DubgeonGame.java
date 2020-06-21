class Solution {
    int[][] memo;
    int row, col;
    int min = Integer.MIN_VALUE;

    public int calculateMinimumHP(int[][] d) {
        row = d.length;
        if (row == 0) return 0;
        col = d[0].length;
        memo = new int[row][col];

        dfs(0, 0, d);
        // for(int[] a: memo)System.out.println(Arrays.toString(a));
        return memo[0][0];
    }


    public int dfs(int i, int j, int[][] d) {
        if (memo[i][j] > 0) return memo[i][j];

        int healthRequired = Integer.MAX_VALUE;
        if (i < row - 1) healthRequired = Math.min(healthRequired, dfs(i + 1, j, d));
        if (j < col - 1) healthRequired = Math.min(healthRequired, dfs(i, j + 1, d));
        healthRequired = healthRequired == Integer.MAX_VALUE ? 1 : healthRequired;
        healthRequired = healthRequired > d[i][j] ? healthRequired - d[i][j] : 1;

        memo[i][j] = healthRequired;

        return healthRequired;
    }
}


// [-2,-3,3]
// [-5,-10,1]
// [10,30,-5]


// [-1, 1, 4, 0]
// [-14, -9, 1, 0]
// [40, 30, -5, 0]
// [0, 0, 0, 0]



/*
1. Subproblem: sffix:matrix (for 5x5 matrix-> a matrix starting from (1,1) of 4x4 size, (0,1)of 4x3 and from (1,0) of 3x4 size)
                        #Subproblems = O(N^2)
2. Guess: What health is required by the knight at any given i,j if we make a sub matrix from there
3. Recurrence: healthRequired(i,j) = min(healthRequired(i+1,j), healthRequired(i,j+1))
                            {
                                healthRequired > dungeon(i,j) :  health - dungeon(i,j)
                                heathRequired <= dungeon(i,j) : 1 (minimum health required by knight)
                            }
                        - base case: healthRequired(row, col) = 1 - dungeon(row, col)
                        - Time per subproblem: O(1)
4. Topological Sort: smallest sub matrix to largest - princess to knight
                        - Total Space = O(N^2) memo table
                        - Total Time = #Subproblems * time/subproblem = O(N^2)
5. Original Question: healthRequired(0, 0)
*/

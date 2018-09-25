package com.vikrambpgc.Matrices;

public class Islands {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {
                     {1,1,1,0,1},
                     {1,1,0,0,0}
                    };
        
        System.out.println(islands(A));

    }
    
    public static int islands(int[][] A) {
        int result = 0;
        int i,j;
        
        final  int[] x = {-1,-1,-1, 0, 0, 1, 1, 1};
        final int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        boolean[][] visited = new boolean[A.length][A[0].length];
        
        for (i=0;i<A.length;i++) {
            for(j=0;j<A[0].length;j++) {
                if (A[i][j] != 0 && visited[i][j] != true) {
                    dfs(A, visited, x, y, i, j);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private static void dfs(int[][] A, boolean[][] visited, int[] x, int[] y, int xpos, int ypos) {
        int i;
        
        visited[xpos][ypos] = true;
        
        for(i=0;i < x.length;i++) {
            if (isSafe(A, visited, xpos + x[i], ypos + y[i]) == true) {
                dfs(A, visited, x, y, xpos + x[i], ypos + y[i]);
            }
        }
    }
    
    private static boolean isSafe(int[][] A, boolean[][] visited, int xpos, int ypos) {
        
        return (xpos >= 0 && xpos < visited.length && 
                ypos >= 0 & ypos < visited[0].length && 
                A[xpos][ypos] != 0 && visited[xpos][ypos] != true);
    }

}

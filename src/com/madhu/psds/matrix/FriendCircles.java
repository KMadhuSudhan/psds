package com.madhu.psds.matrix;

public class FriendCircles {
    public static void main(String[] args) {
        int[][] m = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        FriendCircles friendCircles = new FriendCircles();
        System.out.println(friendCircles.findCircleNum(m));
    }

    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        int length = M.length;
        for (int i = 0; i < length; i++) {
            if(!visited[i]) {
                dfs(M, visited, i,length);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, boolean[] visited, int i,int length) {
        for (int j = 0; j < length; j++) {
            if (i != j && !visited[j] && M[i][j] == 1) {
                visited[j] = true;
                dfs(M, visited, j,length);
            }
        }
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        int minutes = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for(int[] d : dir){

                    int nx = x + d[0];
                    int ny = y + d[1];

                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1){

                        grid[nx][ny] = 2;
                        fresh--;

                        q.offer(new int[]{nx,ny});
                    }
                }
            }

            minutes++;
        }

        if(fresh>0) return -1;

        return minutes-1;
    }
}
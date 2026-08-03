class Solution {
    public boolean canMeasureWater(int x, int y, int target) {

        if (target > x + y) return false;

        if (target == 0) return true;

        Queue<int[]> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0});
        visited.add("0,0");

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int jugX = current[0];
            int jugY = current[1];

            if (jugX + jugY == target) return true;
            int pourXtoY = Math.min(jugX, y - jugY);
            int pourYtoX = Math.min(jugY, x - jugX);
            int[][] allMoves = {
                {x,    jugY},               
                {jugX, y},                  
                {0,    jugY},               
                {jugX, 0},                  
                {jugX - pourXtoY, jugY + pourXtoY},  
                {jugX + pourYtoX, jugY - pourYtoX}   
            };
            for (int[] move : allMoves) {

                String state = move[0] + "," + move[1];
                if (!visited.contains(state)) {
                    visited.add(state);
                    queue.offer(move);
                }
            }
        }
        return false;
    }
}
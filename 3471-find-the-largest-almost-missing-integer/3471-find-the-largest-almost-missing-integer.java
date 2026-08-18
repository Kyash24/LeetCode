class Solution {
    public int largestInteger(int[] nums, int k) {
        int res = - 1 ;
        int ans[]= new int [ 51 ] ;

        for( int i = 0 ; i < nums.length - k + 1 ; i ++ ) {

           boolean seen[] = new boolean [ 51 ] ;

            for(int j = i ; j < i + k ; j ++ ) {

                if( !seen[ nums [ j ] ] ) {
                    ans [ nums [ j ] ] ++ ;
                    seen [ nums [ j ] ] = true ;
                }

            }
        }
        for(int i = 0 ; i <= 50 ; i ++ ) {

            if( ans [ i ] == 1 ) {
                res = i ;
            }

        }

        return res;
    }
}
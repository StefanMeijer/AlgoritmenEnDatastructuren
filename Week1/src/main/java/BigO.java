public abstract class BigO {
    /**
     * Small function to return O(1)
     * @return
     */
    public static int O_1 (int x, int y) {
        return x + y;
    }

    /**
     * Small function to return O(LOG N)
     * @return
     */
    public static int O_LOG_N (int x) {
        while ( x > 0 ) {
            x = x / 2;
        }
        return x;
    }

    /**
     * Small function to return O(N)
     * @return
     */
    public static int O_N(int x) {
        while(x > 0) {
            x--;
        }
        return x;
    }

    /**
     * Small function to return O(N LOG N)
     * @return
     */
    public static int O_N_LOG_N(int n) {

        int x = n;
        while ( x > 0 ) {
            int y = n;
            while ( y > 0 ) {
                y = y - 1;
            }
            x = x / 2;
        }

        return x;
    }

    /**
     * Small function to return O(N^2)
     * @return
     */
    public static int O_N_2_KWADRAAT () {
        return 0;
    }
}

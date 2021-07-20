public class PetsAndToys {
    public static void main(String[] args)
    {
        Solution s = new Solution();

        //First Test Case
        /*int[] P = {1, 1, 2};
        int[] T = {2, 1, 1};
        int[] A = {0, 2};
        int[] B = {1, 1};*/

        //Second Test Case
        /*int[] P = {2, 2, 1, 1, 1};
        int[] T = {1, 1, 1, 2, 2};
        int[] A = {0, 1, 2, 3};
        int[] B = {1, 2, 0, 4};*/

        //Third Test Case
        /*int[] P = {1, 1, 2, 2, 1, 1, 2, 2};
        int[] T = {1, 1, 1, 1, 2, 2, 2, 2};
        int[] A = {0, 2, 4, 6};
        int[] B = {1, 3, 5, 7};*/

        //Fourth Test Case
        int[] P = {2, 2, 2, 2, 1, 1, 1, 1};
        int[] T = {1, 1, 1, 1, 2, 2, 2, 2};
        int[] A = {0, 1, 2, 3, 4, 5, 6};
        int[] B = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(s.solution(P, T, A, B));
    }
}

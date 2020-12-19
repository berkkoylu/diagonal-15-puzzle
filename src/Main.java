import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //int[][] puzzle;
        int[][] puzzle = {{1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 9, 15, 6},
                {10, 0, 8, 7}};
        int depth = 2;
        //puzzle = PuzzleGenerator.generatePuzzle(depth);
        printPuzzle(puzzle);
        System.out.println("-----------THIS IS INITIAL STATE--------");

        State initialState = new State(puzzle);

        UCS ucs = new UCS();
        ucs.solve(initialState);

//        DFS.solve(initialState);
//        DFS.solve(initialState);
//        IDS.solve(initialState,depth);
//        //ILS
//        boolean isSolvableWithCost = ILS.solve(initialState,7);
//        System.out.println(isSolvableWithCost);
//        UCS.solve(initialState);
//        AStarH1.solve(initialState);
//        AStarH2.solve(initialState);


    }

    public static void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ", puzzle[i][j]);
            }
            System.out.println();
        }
    }
}

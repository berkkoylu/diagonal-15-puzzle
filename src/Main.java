import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[][] puzzle;

         int[][] puzzle = {{1, 2, 3, 4},
                          {12, 13, 14, 5},
                          {11, 10, 15, 6},
                          {0, 9, 8, 7}};

//        int[][] puzzle = {{1, 2, 3, 4},
//                          {12, 13, 14, 5},
//                          {11, 0, 6, 15},
//                          {10, 9, 8, 7}};

//                int[][] puzzle = {{1, 14, 3, 4},
//                                 {2, 13, 0, 5},
//                                 {12, 10, 15, 6},
//                                 {11, 9, 8, 7}};

//                        int[][] puzzle = {{1, 14, 3, 4},
//                                 {2, 13, 0, 5},
//                                 {12, 10, 15, 6},
//                                 {11, 9, 8, 7}};


//        int[][] puzzle = {{1, 2, 3, 4},
//                        {12, 13, 14, 5},
//                        {11, 9, 15, 6},
//                        {10, 8, 7, 0}};
//        int[][] puzzle = {{1, 0, 3, 4},
//                          {12, 2, 14, 5},
//                          {11, 13, 15, 6},
//                          {10, 9, 8, 7}};


//        // 1. puzzle
//        int[][] puzzle = {{0, 1, 3, 4},
//                {12, 13, 2, 5},
//                {11, 14, 15, 6},
//                {10, 9, 8, 7}};


//        // 2. puzzle
//        int[][] puzzle = {{1, 3, 5, 4},
//                {2, 13, 14, 15},
//                {11, 12, 9, 6},
//                {0, 10, 8, 7}};

        // 3. puzzle
//        int[][] puzzle = {{1, 13, 3, 4},
//                {12, 11, 2, 5},
//                {9, 8, 15, 7},
//                {10, 6, 14, 0}};



        int depth = 5;
//        puzzle = PuzzleGenerator.generatePuzzle(depth);
        printPuzzle(puzzle);
        System.out.println("-----------THIS IS INITIAL STATE--------");

        State initialState = new State(puzzle);
        DFSupdated dfs =  new DFSupdated();
        dfs.solve(initialState);


//        AStarH2 aStarH2 =  new AStarH2();
//        aStarH2.solve(initialState);

//        System.out.println("---------UCS--------");
//        System.out.println();
//        UCS ucs = new UCS();
//        ucs.solve(initialState);
        System.out.println("---------BFS--------");
        System.out.println();
//
//        AStarH1 aStarH1 = new AStarH1();
//        aStarH1.solve(initialState);

//        BFS bfs = new BFS();
//        bfs.solve(initialState);


//       DFS.solve(initialState);

//        IDS.solve(initialState,depth);
//        boolean isSolvableWithCost = ILS.solve(initialState,7);
//        System.out.println(isSolvableWithCost);
//        UCS.solve(initialState);



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

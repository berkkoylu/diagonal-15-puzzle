import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


//        int[][] puzzle = {{1, 3, 14, 4},
//                          {12, 2, 15, 5},
//                          {11, 13, 0, 6},
//                          {10, 9, 8, 7}};

//        int[][] puzzle = {{1, 2, 3, 4},
//                          {12, 13, 14, 5},
//                          {10, 11, 0, 6},
//                          {9, 8, 15, 7}};


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

//         3. puzzle
//        int[][] puzzle = {{1, 13, 3, 4},
//                {12, 11, 2, 5},
//                {9, 8, 15, 7},
//                {10, 6, 14, 0}};


        int depth = 5;
        int[][] puzzle; puzzle = PuzzleGenerator.generatePuzzle(depth);

        System.out.println("##########################################");
        System.out.println("##########################################");
        System.out.println("##########################################");

        printPuzzle(puzzle);

        System.out.println("-----------THIS IS INITIAL STATE--------");


        State initialState = new State(puzzle);

//        ILS ils = new ILS();
//        ils.solve(initialState);

//        UCS ucs = new UCS();
//        ucs.solve(initialState);

        //       ILS.solve(initialState,17);


            AStarH1 aStarH1 = new AStarH1();
            aStarH1.solve(initialState);

//            AStarH2 aStarH2 =  new AStarH2();
//            aStarH2.solve(initialState);



//
//        BFS bfs = new BFS();
//        bfs.solve(initialState);

//        IDS ids = new IDS();
//        ids.solve(initialState);

//        DFS dfs =  new DFS();
//        dfs.solve(initialState);


//        ILS.solve(initialState, 10);
//        boolean isSolvableWithCost = ILS.solve(initialState,7);
//        System.out.println(isSolvableWithCost);


    }

    public static void printPuzzle(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }
}

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       //int[][] puzzle;
       int [][]puzzle = {{1,13,3,4},
                        {12, 11, 2, 5},
                        {9,8,15,7},
                        {10,6,14,0}};
       int depth = 1;
        //puzzle = PuzzleGenerator.generatePuzzle(depth);
        printPuzzle(puzzle);
        System.out.println("-----------THIS IS INITIAL STATE--------");

        State initialState = new State(puzzle);
        //IDS.solve(initialState,1);
        UCS.solve(initialState);


        //BFS.solve(initialState,depth);
           // UCS.solve(initialState,depth);
//       System.out.println("-----------");
//        int [][]puzzle = {{1,2,3,4},
//                {12, 13, 14, 5},
//                {11,0,15,6},
//                {10,9,8,7}};
//        State initialState = new State(puzzle);
//        printPuzzle(puzzle);
//        System.out.println("-----------");
//
//        printPuzzle(Move.up(initialState).getMatrixPuzzle());
//        System.out.println("-----------");
//        printPuzzle(Move.down(initialState).getMatrixPuzzle());
//        System.out.println("-----------");


/*        initialState = Move.up(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.right(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.down(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.left(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.upAndRight(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.downAndRight(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.downAndLeft(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.upAndLeft(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        System.out.println(initialState.getCost());*/

    }


    public static void printPuzzle(int[][] puzzle){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ",puzzle[i][j]);
            }
            System.out.println();
        }
    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //int[][] puzzle;
        int[][] puzzle = {{1, 3, 0, 4},
                {12, 13, 2, 5},
                {11, 14, 15, 6},
                {10, 9, 8, 7}};
        int depth = 2;
        //puzzle = PuzzleGenerator.generatePuzzle(depth);
        printPuzzle(puzzle);
        System.out.println("-----------THIS IS INITIAL STATE--------");

        State initialState = new State(puzzle);
<<<<<<< Updated upstream
=======
        State normalState = new State(puzzle);

        //AStarH1.solve(initialState);
        //AStarH2.solve(initialState);
        //IDS.solve(initialState,1);
        //UCS.solve(initialState);
        //boolean isSolvableWithCost = ILS.solve(initialState,7);
        //System.out.println(isSolvableWithCost);
        //BFS.solve(initialState,depth);
        //UCS.solve(initialState,depth);

        List<State> visited = new LinkedList<>(new Comparator<State>() {
            @Override
            public int compare(State state, State t1) {
                return (state.getCost() + state.getHeuristic()) - (t1.getCost() + t1.getHeuristic());
            }
        });

        visited.add(initialState);
        visited.add(normalState);
        System.out.println(visited.size());



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
>>>>>>> Stashed changes

//        BFS.solve(initialState);
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class IDS {


    static int[][] solution = {{1,2,3,4},
            {12, 0, 14, 5},
            {11,13,15,6},
            {10,9,8,7}};
    int[][] puzzle;

    public static HashSet<State> visited = new HashSet<State>();
    public static Stack<State> frontier = new Stack<State>();

    public IDS(int[][] puzzle){
        this.puzzle = puzzle;
    }
    public static void solve(State state, int depthLimit){

        for(int currentDepth=1;currentDepth<=depthLimit;currentDepth++){
            frontier.clear();
            frontier.push(state);
            State currentState = state;
            while(!frontier.isEmpty()){
                state = frontier.pop();
                if(isSolution(state.getMatrixPuzzle())){
                    currentState = state;
                    while(currentState != null){
                        printPuzzle(currentState.getMatrixPuzzle());
                        System.out.println("----------- cost of move is " + currentState.getCost());
                        currentState = currentState.getPreviousState();
                    }
                    System.out.println("solved");
                    return;
                }
                if(currentState.getDepth() < currentDepth){
                    currentState.setDepth(currentState.getDepth() + 1);
                    System.out.println(currentState.getDepth());


                    if(!visited.contains(state)){
                        visited.add(state);
                        if(!visited.contains(Move.upAndRight(state))){
                            if(Move.upAndRight(state) != null){
                                frontier.push(Move.upAndRight(state));
                            }
                        }
                        if(!visited.contains(Move.upAndLeft(state))) {
                            if (Move.upAndLeft(state) != null) {
                                frontier.push(Move.upAndLeft(state));
                            }
                        }
                        if(!visited.contains(Move.downAndRight(state))) {
                            if (Move.downAndRight(state) != null) {
                                frontier.push(Move.downAndRight(state));
                            }
                        }
                        if(!visited.contains(Move.downAndLeft(state))) {
                            if (Move.downAndLeft(state) != null) {
                                frontier.push(Move.downAndLeft(state));
                            }
                        }
                        if(!visited.contains(Move.left(state))) {
                            if (Move.left(state) != null) {
                                frontier.push(Move.left(state));
                            }
                        }
                        if(!visited.contains(Move.right(state))) {
                            if (Move.right(state) != null) {
                                frontier.push(Move.right(state));
                            }
                        }
                        if(!visited.contains(Move.down(state))) {
                            if (Move.down(state) != null) {
                                frontier.push(Move.down(state));
                            }
                        }
                        if(!visited.contains(Move.up(state))) {
                            if (Move.up(state) != null) {
                                frontier.push(Move.up(state));
                            }
                        }
                    }

                }
            }
            if(!isSolution(state.getMatrixPuzzle())){
                System.out.println("Solution not found");
            }
        }
    }
    public static boolean isSolution(int[][] puzzle){
        return Arrays.deepEquals(puzzle, solution);
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

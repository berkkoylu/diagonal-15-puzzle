import java.util.*;

public class DFS {
    static int[][] solution = {{1,2,3,4},
            {12, 13, 14, 5},
            {11,0,15,6},
            {10,9,8,7}};
    int[][] puzzle;

    public static HashSet<State> visited = new HashSet<>();
    public static final Stack<State> frontier = new Stack<>();



    public DFS(int[][] puzzle){
        this.puzzle = puzzle;
    }

    public static void solve(State state, int depth){
        frontier.clear();
        frontier.push(state);
        State currentState;
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
                break;
            }
            if(!visited.contains(state)){
                visited.add(state);
                if(!visited.contains(Move.upAndRight(state))){
                    if(Move.up(state) != null){
                        frontier.push(Move.up(state));
                    }
                }
                if(!visited.contains(Move.upAndLeft(state))) {
                    if (Move.down(state) != null) {
                        frontier.push(Move.down(state));
                    }
                }
                if(!visited.contains(Move.downAndRight(state))) {
                    if (Move.right(state) != null) {
                        frontier.push(Move.right(state));
                    }
                }
                if(!visited.contains(Move.downAndLeft(state))) {
                    if (Move.left(state) != null) {
                        frontier.push(Move.left(state));
                    }
                }
                if(!visited.contains(Move.left(state))) {
                    if (Move.downAndLeft(state) != null) {
                        frontier.push(Move.downAndLeft(state));
                    }
                }
                if(!visited.contains(Move.right(state))) {
                    if (Move.downAndRight(state) != null) {
                        frontier.push(Move.downAndRight(state));
                    }
                }
                if(!visited.contains(Move.down(state))) {
                    if (Move.upAndLeft(state) != null) {
                        frontier.push(Move.upAndLeft(state));
                    }
                }
                if(!visited.contains(Move.up(state))) {
                    if (Move.upAndRight(state) != null) {
                        frontier.push(Move.upAndRight(state));
                    }
                }
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

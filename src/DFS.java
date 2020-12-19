import java.util.*;

public class DFS {
    static int[][] solution = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};
    int[][] puzzle;

    public static HashSet<State> visited = new HashSet<State>();
    public static final Stack<State> frontier = new Stack<>();


    public DFS(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public static void solve(State state) {
        frontier.clear();
        frontier.push(state);
        State currentState;
        while (!frontier.isEmpty()) {
            state = frontier.pop();
            if (isSolution(state.getMatrixPuzzle())) {
                currentState = state;
                while (currentState != null) {
                    printPuzzle(currentState.getMatrixPuzzle());
                    System.out.println("----------- cost of move is " + currentState.getCost());
                    currentState = currentState.getPreviousState();
                }
                System.out.println("solved");
                break;
            }


            if (isVisited(state)) {
                insertVisited(state);
                if (isVisited(Move.upAndRight(state))) {
                    if (Move.upAndRight(state) != null) {
                       insertFrontier(Move.upAndRight(state));
                    }
                }
                if (isVisited(Move.upAndLeft(state))) {
                    if (Move.upAndLeft(state) != null) {
                        insertFrontier(Move.upAndLeft(state));
                    }
                }
                if (isVisited(Move.downAndRight(state))) {
                    if (Move.downAndRight(state) != null) {
                        insertFrontier(Move.downAndRight(state));
                    }

                }
                if (isVisited(Move.downAndLeft(state))) {
                    if (Move.downAndLeft(state) != null) {
                        insertFrontier(Move.downAndLeft(state));
                    }
                }
                if (isVisited(Move.left(state))) {
                    if (Move.left(state) != null) {
                        insertFrontier(Move.left(state));
                    }
                }
                if (isVisited(Move.right(state))) {
                    if (Move.right(state) != null) {
                        insertFrontier(Move.right(state));
                    }
                }
                if (isVisited(Move.down(state))) {
                    if (Move.down(state) != null) {
                        insertFrontier(Move.down(state));
                    }
                }
                if (isVisited(Move.up(state))) {
                    if (Move.up(state) != null) {
                        insertFrontier(Move.up(state));
                    }
                }
            }
            if(!isSolution(state.getMatrixPuzzle())){
                System.out.println("Solution not found");
            } 

        }

    }

    public static boolean isSolution(int[][] puzzle) {
        return Arrays.deepEquals(puzzle, solution);
    }

    public static void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ", puzzle[i][j]);
            }
            System.out.println();
        }
    }
    public static void insertVisited(State state){
        if(state != null){
            if(visited.isEmpty()){
                visited.add(state);
            }else{
                Iterator<State> iteratorState = visited.iterator();
                while (iteratorState.hasNext()){
                    if(!Arrays.deepEquals(iteratorState.next().getMatrixPuzzle(),state.getMatrixPuzzle())){
                        visited.add(state);
                    }
                }
            }
        }
    }
    public static boolean isVisited(State state){
        if(state != null){
            Iterator<State> iteratorState = visited.iterator();
            while (iteratorState.hasNext()){
                if(!Arrays.deepEquals(iteratorState.next().getMatrixPuzzle(),state.getMatrixPuzzle())){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static void insertFrontier(State state){
        if(state != null){
            if(frontier.isEmpty()){
                frontier.push(state);
            }else{
                Iterator<State> iteratorStack = frontier.iterator();
                while(iteratorStack.hasNext()){
                    if(!Arrays.deepEquals(iteratorStack.next().getMatrixPuzzle(),state.getMatrixPuzzle())){
                        frontier.push(state);
                    }
                }
            }
        }

    }
}

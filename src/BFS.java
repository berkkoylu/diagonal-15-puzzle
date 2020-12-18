import java.util.*;

public class BFS {
    static int[][] solution = {{1,2,3,4},
            {12, 13, 14, 5},
            {11,0,15,6},
            {10,9,8,7}};
    int[][] puzzle;
    State state;

    public static HashSet<State> visited = new HashSet<State>();
    public static final Queue<State> frontier = new LinkedList<>();



    public BFS(int[][] puzzle){
        this.puzzle = puzzle;
    }

    public static void solve(State state){
        frontier.clear();
        frontier.add(state);
        State currentState = state;
        while(!frontier.isEmpty()){
            state = frontier.poll();
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

            visited.add(currentState);
            addQueue(Move.up(state));
            addQueue(Move.down(state));
            addQueue(Move.left(state));
            addQueue(Move.right(state));
            addQueue(Move.downAndLeft(state));
            addQueue(Move.upAndLeft(state));
            addQueue(Move.downAndRight(state));
            addQueue(Move.downAndLeft(state));
        }
    }

    public static boolean isSolution(int[][] puzzle){
        if(Arrays.deepEquals(puzzle,solution)){
            return true;
        }else{
            return false;
        }
    }

    public static void addQueue(State state){
        if(state != null && !visited.contains(state)){
            frontier.add(state);
        }
    }

    public static void printPuzzle(int[][] puzzle){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ",puzzle[i][j]);
            }
            System.out.println();
        }
    }

    public static void expand(){

    }
}

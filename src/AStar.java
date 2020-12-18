import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStar {
    static int[][] solutionMatrix = {{1,2,3,4},
            {12, 13, 14, 5},
            {11,0,15,6},
            {10,9,8,7}};
    int[][] puzzle;
    State state;

    public static HashSet<State> visited = new HashSet<State>();
    public static final PriorityQueue<State> queue = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return (state.getCost() + state.getHeuristic()) - (t1.getCost() + t1.getHeuristic());
        }
    });



    public AStar(int[][] puzzle){
        this.puzzle = puzzle;
    }

    public static void solve(State state, int depth){
        queue.clear();
        queue.add(state);
        State currentState = state;
        while(!queue.isEmpty()){
            state = queue.poll();
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
        if(Arrays.deepEquals(puzzle,solutionMatrix)){
            return true;
        }else{
            return false;
        }
    }

    public static void addQueue(State state){
        if(state != null && !visited.contains(state)){
            int heuristicValue = calculateHeuristic(state);
            state.setHeuristic(heuristicValue);
            queue.add(state);
        }
    }

    public static int calculateHeuristic(State state){
        int heuristicValue = 0;
        int [][]stateMatrix = state.getMatrixPuzzle();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(stateMatrix[i][j] != solutionMatrix[i][j]){
                    heuristicValue++;
                }
            }
        }

        return heuristicValue;
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


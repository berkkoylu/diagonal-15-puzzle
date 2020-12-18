import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ILS {
    static int[][] solution = {{1,2,3,4},
            {12, 13, 14, 5},
            {11,0,15,6},
            {10,9,8,7}};
            int[][] puzzle;

    public static HashSet<State> visited = new HashSet<State>();
    public static final PriorityQueue<State> queue = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return state.getCost() - t1.getCost();
        }
    });
    public ILS(int[][] puzzle){
        this.puzzle = puzzle;
    }
    public static void solve(State state, int depth){
        queue.clear();
        queue.add(state);
        State currentState = state;
        while(!queue.isEmpty()) {
            state = queue.poll();
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
            int i=1;
            if(currentState.getDepth() < i ){
                currentState.setDepth(currentState.getDepth() + 1);
                visited.add(currentState);
                addQueue(Move.up(state));
                addQueue(Move.down(state));
                addQueue(Move.left(state));
                addQueue(Move.right(state));
                addQueue(Move.downAndLeft(state));
                addQueue(Move.upAndLeft(state));
                addQueue(Move.downAndRight(state));
                addQueue(Move.downAndLeft(state));
                if(i<depth)
                    i++;
            }

        }

    }
    public static boolean isSolution(int[][] puzzle){
        if(Arrays.deepEquals(puzzle,solution)){
            return true;
        }else{
            return false;
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
    public static void addQueue(State state){
        if(state != null && !visited.contains(state)){
            queue.add(state);
        }
    }
}
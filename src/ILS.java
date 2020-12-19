import java.util.*;

public class ILS {
    static int[][] solution = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};
    int[][] puzzle;

    public static HashSet<State> visited = new HashSet<>();
    public static final PriorityQueue<State> frontier = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return state.getCost() - t1.getCost();
        }
    });

    public ILS(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public static boolean solve(State state, int maxCost) {
        frontier.clear();
        frontier.add(state);
        State currentState = state;
        while (!frontier.isEmpty()) {
            state = frontier.poll();
            if (isSolution(state.getMatrixPuzzle())) {
                currentState = state;
                while (currentState != null) {
                    printPuzzle(currentState.getMatrixPuzzle());
                    System.out.println("----------- cost of move is " + currentState.getCost());
                    currentState = currentState.getPreviousState();
                }
                System.out.println("solved");
                return true;
            }

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

            addQueue(Move.up(state), maxCost);
            addQueue(Move.down(state), maxCost);
            addQueue(Move.left(state), maxCost);
            addQueue(Move.right(state), maxCost);
            addQueue(Move.downAndLeft(state), maxCost);
            addQueue(Move.upAndLeft(state), maxCost);
            addQueue(Move.downAndRight(state), maxCost);
            addQueue(Move.downAndLeft(state), maxCost);
        }
        return false;
    }

    public static boolean isSolution(int[][] puzzle) {
        return Arrays.deepEquals(puzzle, solution);
    }

    public static void addQueue(State state, int maxCost) {
        if (state != null && state.getCost() <= maxCost && searchExploredAndVisited(state)) {
            frontier.add(state);
        }else if(searchAtFrontier(state)){
            swapFrontier(state);
        }
    }
    public static void swapFrontier(State state){

        for (State tempState: frontier) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
                if(tempState.getCost() > state.getCost()){
                    frontier.remove(tempState);
                    frontier.add(state);
                    break;
                }
            }
        }

    }
    public static boolean searchAtFrontier(State state){
        if (state == null){
            return false;
        }

        for (State tempState: frontier) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
                return true;
            }
        }
        return false;

    }
    public static boolean searchExploredAndVisited(State state){
        if (state == null){
            return false;
        }

        for (State tempState: visited) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
                return false;
            }
        }

        for (State tempState: frontier) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
                return false;
            }
        }
        return true;
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

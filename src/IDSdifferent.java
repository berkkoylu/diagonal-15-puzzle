import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class IDSdifferent {

    static int[][] solution = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};

    private final HashSet<State> visited = new HashSet<>();
    private final Stack<State> frontier = new Stack<>();
    private boolean solvedFlag = false;

    public void solve(State state, int depthLimit) {

        for (int currentDepth = 0; currentDepth < depthLimit; currentDepth++) {

            visited.clear();
            frontier.clear();
            frontier.add(state);
            State currentState;

            while (!frontier.isEmpty()) {
                currentState = frontier.pop();

                if (isSolution(currentState.getMatrixPuzzle())) {
                    while (currentState != null) {
                        printPuzzle(currentState.getMatrixPuzzle());
                        System.out.println("----------- cost of move is " + currentState.getCost());
                        currentState = currentState.getPreviousState();
                    }
                    solvedFlag = true;
                    System.out.println("solved");
                    break;
                }


                    visited.add(currentState);

                    addQueue(Move.up(currentState),currentDepth, currentState.getDepth());
                    addQueue(Move.down(currentState),currentDepth,currentState.getDepth());
                    addQueue(Move.left(currentState),currentDepth,currentState.getDepth());
                    addQueue(Move.right(currentState),currentDepth,currentState.getDepth());
                    addQueue(Move.downAndLeft(currentState),currentDepth,currentState.getDepth());
                    addQueue(Move.upAndLeft(currentState),currentDepth,currentState.getDepth());
                    addQueue(Move.downAndRight(currentState),currentDepth,currentState.getDepth());
                    addQueue(Move.upAndRight(currentState),currentDepth,currentState.getDepth());


//                if(currentState.getDepth() <= currentDepth) {
//                    visited.add(currentState);
//
//                    addQueue(Move.up(currentState),currentState.getDepth());
//                    addQueue(Move.down(currentState),currentState.getDepth());
//                    addQueue(Move.left(currentState),currentState.getDepth());
//                    addQueue(Move.right(currentState),currentState.getDepth());
//                    addQueue(Move.downAndLeft(currentState),currentState.getDepth());
//                    addQueue(Move.upAndLeft(currentState),currentState.getDepth());
//                    addQueue(Move.downAndRight(currentState),currentState.getDepth());
//                    addQueue(Move.upAndRight(currentState),currentState.getDepth());
//                }
            }

            if (solvedFlag){
                break;
            }

        }
    }

    public boolean isSolution(int[][] puzzle) {
        return Arrays.deepEquals(puzzle, solution);
    }


    public void addQueue(State state, int currentDepth, int pastStateDepth) {

        if (state != null) {
            state.setDepth(pastStateDepth + 1);
            if(state.getDepth() <= currentDepth) {
                if (searchVisited(state) && searchFrontier(state)) {
                    frontier.push(state);
                }
            }
        }
    }

    public boolean searchVisited(State state) {
        for (State tempState : visited) {
            if (Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())) {
                return false;
            }
        }
        return true;
    }


    public boolean searchFrontier(State state) {
        for (State tempState : frontier) {
            if (Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())) {
                return false;
            }
        }
        return true;
    }

    public void printPuzzle(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }


}

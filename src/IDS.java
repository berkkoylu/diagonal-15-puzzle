import java.util.*;

public class IDS {

    static int[][] solution = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};
    private int maxNumberOfStoredInMemory = 0;
    private int totalVisitedNode = 0;


    private final HashSet<State> visited = new HashSet<>();
    private final Stack<State> frontier = new Stack<>();
    private boolean solvedFlag = false;

    public void solve(State state) {

        int depthLimit = 100000;

        for (int currentDepth = 0; currentDepth < depthLimit; currentDepth++) {

            visited.clear();
            frontier.clear();
            frontier.add(state);
            State currentState;

            while (!frontier.isEmpty()) {
                currentState = frontier.pop();

                if (isSolution(currentState.getMatrixPuzzle())) {
                    State printState = currentState;
                    List<State> list = new ArrayList<>();
                    while (currentState != null) {
                        list.add(currentState);
                        currentState = currentState.getPreviousState();
                    }

                    Collections.reverse(list);

                    for (State reverseState: list
                    ) {
                        printPuzzle(reverseState.getMatrixPuzzle());
                        System.out.println("----------- cost of move is " + reverseState.getCost());

                    }

                    solvedFlag = true;
                    System.out.println("Solved at depth: " + printState.getDepth());
                    System.out.println("Total number of expanded node: " + totalVisitedNode);
                    System.out.println("Maximum number of nodes stored in the memory: " + maxNumberOfStoredInMemory);

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
                maxNumberOfStoredInMemory = Math.max(maxNumberOfStoredInMemory, frontier.size() + visited.size());



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

            totalVisitedNode = totalVisitedNode + visited.size();

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

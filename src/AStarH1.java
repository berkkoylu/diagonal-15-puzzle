import java.util.*;

public class AStarH1 {
    static int[][] solutionMatrix = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};

    private static int counter = 0;

    private final Set<State> visited = new HashSet<State>();
    private final Queue<State> frontier = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return (state.getCost() + state.getHeuristic()) - (t1.getCost() + t1.getHeuristic());
        }
    });


    public void solve(State state) {
        frontier.clear();
        frontier.add(state);
        State currentState;
        while (!frontier.isEmpty()) {
            currentState = frontier.poll();

            if (isSolution(currentState.getMatrixPuzzle())) {
                List<State> list = new ArrayList<>();
                while (currentState != null) {
                    list.add(currentState);
//                    printPuzzle(currentState.getMatrixPuzzle());
//                    System.out.println("----------- cost of move is " + currentState.getCost());
                    currentState = currentState.getPreviousState();
                }

                Collections.reverse(list);

                for (State reverseState: list
                ) {
                    printPuzzle(reverseState.getMatrixPuzzle());
                    System.out.println("----------- cost of move is " + reverseState.getCost());

                }


                System.out.println("solved");
                System.out.println("Number of expanded node: " + visited.size());
                break;
            }

            if(currentState.getCost() == counter){
                System.out.println("Cost is: " + counter);
                counter++;
            }
            visited.add(currentState);

            addQueue(Move.up(currentState));
            addQueue(Move.down(currentState));
            addQueue(Move.left(currentState));
            addQueue(Move.right(currentState));
            addQueue(Move.downAndLeft(currentState));
            addQueue(Move.upAndLeft(currentState));
            addQueue(Move.downAndRight(currentState));
            addQueue(Move.upAndRight(currentState));

        }
    }

    public void addQueue(State state) {

        if (state != null) {
            if (searchVisited(state) && searchFrontier(state)) {
                int heuristicValue = calculateHeuristicH1(state);
                state.setHeuristic(heuristicValue);
                frontier.add(state);
            } else if (searchAtFrontier(state)) {
                int heuristicValue = calculateHeuristicH1(state);
                state.setHeuristic(heuristicValue);
                swapFrontier(state);
            }
        }
    }


    public void swapFrontier(State state) {

        for (State tempState : frontier) {
            if (Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())) {
                if ((tempState.getCost() + tempState.getHeuristic()) > (state.getCost() + state.getHeuristic())) {
                    frontier.remove(tempState);
                    frontier.add(state);
                    break;
                }
            }
        }

    }


    public boolean searchAtFrontier(State state) {

        for (State tempState : frontier) {
            if (Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())) {
                return true;
            }
        }
        return false;
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


    public boolean searchExploredAndVisited(State state) {
        if (state == null) {
            return false;
        }

        for (State tempState : visited) {
            if (Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())) {
                return false;
            }
        }

        for (State tempState : frontier) {
            if (Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSolution(int[][] puzzle) {
        return Arrays.deepEquals(puzzle, solutionMatrix);
    }

    public int calculateHeuristicH1(State state) {
        int heuristicValueH1 = 0;
        int[][] stateMatrix = state.getMatrixPuzzle();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (stateMatrix[i][j] != solutionMatrix[i][j]) {
                    heuristicValueH1++;
                }
            }
        }

        return heuristicValueH1;
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



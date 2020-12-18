import java.util.*;

public class AStarH2 {

    static int[][] solutionMatrix = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};
    int[][] puzzle;

    public static Set<State> visited = new HashSet<>();
    public static final Queue<State> queue = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return (state.getCost() + state.getHeuristic()) - (t1.getCost() + t1.getHeuristic());
        }
    });

    public AStarH2(int[][] puzzle) {
        this.puzzle = puzzle;
    }


    public static void solve(State state) {
        queue.clear();
        queue.add(state);
        State currentState = state;
        while (!queue.isEmpty()) {
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

    public static boolean isSolution(int[][] puzzle) {
        if (Arrays.deepEquals(puzzle, solutionMatrix)) {
            return true;
        } else {
            return false;
        }
    }

    public static void addQueue(State state) {
        if (state != null && !visited.contains(state)) {
            int heuristicValue = calculateHeuristicH2(state);
            state.setHeuristic(heuristicValue);
            queue.add(state);
        }
    }

    public static int calculateHeuristicH2(State state) {
        int heuristicValueH2 = 0;
        int[][] stateMatrix = state.getMatrixPuzzle();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int currentIndex = stateMatrix[i][j];
                for (int k = 0; k < 4; k++)
                    for (int l = 0; l < 4; l++) {
                        if (solutionMatrix[k][l] == currentIndex) {
                            heuristicValueH2 = heuristicValueH2 + Math.abs(k - i) + Math.abs(l - j);
                        }
                    }
            }
        }

        return heuristicValueH2;
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

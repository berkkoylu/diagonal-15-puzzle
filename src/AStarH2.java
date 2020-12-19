import java.util.*;

public class AStarH2 {

    static int[][] solutionMatrix = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};

    private final Set<State> visited = new HashSet<>();
   private final Queue<State> frontier = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return (state.getCost() + state.getHeuristic()) - (t1.getCost() + t1.getHeuristic());
        }
    });



    public  void solve(State state) {
        frontier.clear();
        frontier.add(state);
        State currentState;
        while (!frontier.isEmpty()) {
            currentState = frontier.poll();
//            System.out.println(frontier.size());

            if (isSolution(currentState.getMatrixPuzzle())) {
                while (currentState != null) {
                    printPuzzle(currentState.getMatrixPuzzle());
                    System.out.println("----------- cost of move is " + currentState.getCost());
                    currentState = currentState.getPreviousState();
                }
                System.out.println("solved");
                break;
            }
            visited.add(currentState);

            addQueue(Move.up(currentState));
            addQueue(Move.down(currentState));
            addQueue(Move.left(currentState));
            addQueue(Move.right(currentState));
            addQueue(Move.downAndLeft(currentState));
            addQueue(Move.upAndLeft(currentState));
            addQueue(Move.downAndRight(currentState));
            addQueue(Move.downAndLeft(currentState));
        }
    }

    public void addQueue(State state) {
        if (state != null && searchExploredAndVisited(state)) {
            int heuristicValue = calculateHeuristicH2(state);
            state.setHeuristic(heuristicValue);
            frontier.add(state);
        }else if(searchAtFrontier(state)){
            int heuristicValue = calculateHeuristicH2(state);
            state.setHeuristic(heuristicValue);
            swapFrontier(state);
        }
    }




    public void swapFrontier(State state){

        for (State tempState: frontier) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
                if((tempState.getCost() + tempState.getHeuristic()) > (state.getCost() + state.getHeuristic())){
                    frontier.remove(tempState);
                    frontier.add(state);
//                    System.out.println("swap oldu");
                    break;
                }
            }
        }

    }

    public boolean searchAtFrontier(State state){
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

    public boolean searchExploredAndVisited(State state){
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



    public  boolean isSolution(int[][] puzzle) {
        if (Arrays.deepEquals(puzzle, solutionMatrix)) {
            return true;
        } else {
            return false;
        }
    }

    public  int calculateHeuristicH2(State state) {
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

    public  void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ", puzzle[i][j]);
            }
            System.out.println();
        }
    }

}

import java.util.*;

public class UCS {
    private final static int[][] solution = {{1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 0, 15, 6},
            {10, 9, 8, 7}};

    private static int counter = 0;

   private final HashSet<State> visited = new HashSet<>();
   private final PriorityQueue<State> frontier = new PriorityQueue<>(new Comparator<State>() {
        @Override
        public int compare(State state, State t1) {
            return state.getCost() - t1.getCost();
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

    public boolean isSolution(int[][] puzzle) {
        return Arrays.deepEquals(puzzle, solution);
    }



    public void addQueue(State state) {
        if(state != null){
            if ( searchVisited(state) && searchFrontier(state) ) {
                frontier.add(state);
            }else if(searchAtFrontier(state)){
                swapFrontier(state);
            }
        }
    }

//    public void addQueue(State state) {
//
//        if(state != null){
//            if ( searchExploredAndVisited(state)) {
//                frontier.add(state);
//            }else if(searchAtFrontier(state)){
//                swapFrontier(state);
//            }
//        }
//
//
//    }

    public void swapFrontier(State state){

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

    public boolean searchAtFrontier(State state){

        for (State tempState: frontier) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
                return true;
            }
        }
        return false;
    }

    public boolean searchVisited(State state){
        for (State tempState: visited) {
            if(Arrays.deepEquals(tempState.getMatrixPuzzle(), state.getMatrixPuzzle())){
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


    public void printPuzzle(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }

}

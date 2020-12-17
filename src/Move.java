import java.util.Arrays;

public class Move {

    public static State up(State state){
        if(state.getBlankTileCoordinateX() - 1 >= 0){
            int[][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() - 1  , state.getBlankTileCoordinateY()};

            swap(newMatrix, spaceLocation, tileLocation);
            State newState = new State(newMatrix, state);
            newState.setCost(state.getCost() + 1);
            return newState;
        }else{
            return state;
        }
    }
    public static State down(State state){
        if(state.getBlankTileCoordinateX() + 1 <= 3 ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() + 1  , state.getBlankTileCoordinateY()};
            swap(newMatrix, spaceLocation,tileLocation);
            State newState = new State(newMatrix, state);
            newState.setCost(state.getCost() + 1);
            return newState;
        }else{
            return state;
        }
    }
    public static State right(State state){
        if(state.getBlankTileCoordinateY() + 1 <= 3 ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY() + 1 };
            swap(newMatrix, spaceLocation,tileLocation);
            State newState = new State(newMatrix, state);
            newState.setCost(state.getCost() + 1);
            return newState;
        }else{
            return state;
        }
    }
    public static State left(State state){
        if(state.getBlankTileCoordinateY() - 1 >= 0 ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY() - 1 };
            swap(newMatrix, spaceLocation,tileLocation);
            State newState = new State(newMatrix, state);
            newState.setCost(state.getCost() + 1);
            return newState;
        }else{
            return state;
        }
    }
    public static State upAndRight(State state){
        if(state.getBlankTileCoordinateX() - 1 >= 0 && state.getBlankTileCoordinateY() + 1 <= 3  ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() - 1, state.getBlankTileCoordinateY()};
            swap(newMatrix, spaceLocation,tileLocation);

            State newState = new State(newMatrix, state);
            int [][] newMatrixForSecondMove = newState.getMatrixPuzzle().clone();
            int[] spaceLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY()};
            int[] tileLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY() + 1 };
            swap(newMatrixForSecondMove, spaceLocationForSecondMove,tileLocationForSecondMove);
            State newStateForSecondMove = new State(newMatrixForSecondMove, newState);
            newStateForSecondMove.setCost(state.getCost() + 3);
            return newStateForSecondMove;
        }else{
            return state;
        }
    }

    public static State upAndLeft(State state){
        if(state.getBlankTileCoordinateX() - 1 >= 0 && state.getBlankTileCoordinateY() - 1 >= 0  ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() - 1, state.getBlankTileCoordinateY()};
            swap(newMatrix, spaceLocation,tileLocation);

            State newState = new State(newMatrix, state);
            int [][] newMatrixForSecondMove = newState.getMatrixPuzzle().clone();
            int[] spaceLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY()};
            int[] tileLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY() - 1 };
            swap(newMatrixForSecondMove, spaceLocationForSecondMove,tileLocationForSecondMove);
            State newStateForSecondMove = new State(newMatrixForSecondMove, newState);
            newStateForSecondMove.setCost(state.getCost() + 3);
            return newStateForSecondMove;
        }else{
            return state;
        }
    }
    public static State downAndRight(State state){
        if(state.getBlankTileCoordinateX() + 1 >= 0 && state.getBlankTileCoordinateY() + 1 >= 0  ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() + 1, state.getBlankTileCoordinateY()};
            swap(newMatrix, spaceLocation,tileLocation);

            State newState = new State(newMatrix, state);
            int [][] newMatrixForSecondMove = newState.getMatrixPuzzle().clone();
            int[] spaceLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY()};
            int[] tileLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY() + 1 };
            swap(newMatrixForSecondMove, spaceLocationForSecondMove,tileLocationForSecondMove);
            State newStateForSecondMove = new State(newMatrixForSecondMove, newState);
            newStateForSecondMove.setCost(state.getCost() + 3);
            return newStateForSecondMove;
        }else{
            return state;
        }
    }
    public static State downAndLeft(State state){
        if(state.getBlankTileCoordinateX() + 1 >= 0 && state.getBlankTileCoordinateY() - 1 >= 0  ){
            int [][] newMatrix = state.getMatrixPuzzle().clone();
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() + 1, state.getBlankTileCoordinateY()};
            swap(newMatrix, spaceLocation,tileLocation);

            State newState = new State(newMatrix, state);
            int [][] newMatrixForSecondMove = newState.getMatrixPuzzle().clone();
            int[] spaceLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY()};
            int[] tileLocationForSecondMove = {newState.getBlankTileCoordinateX(), newState.getBlankTileCoordinateY() - 1 };
            swap(newMatrixForSecondMove, spaceLocationForSecondMove,tileLocationForSecondMove);
            State newStateForSecondMove = new State(newMatrixForSecondMove, newState);
            newStateForSecondMove.setCost(state.getCost() + 3);
            return newStateForSecondMove;
        }else{
            return state;
        }
    }
    public static int[][] swap(int[][] puzzle, int[] space, int[] tile){
        puzzle[space[0]][space[1]] = puzzle[tile[0]][tile[1]];
        puzzle[tile[0]][tile[1]] = 0;
        return puzzle;
    }


}

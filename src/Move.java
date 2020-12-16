import java.util.Arrays;

public class Move {

    public static State up(State state){
        if(state.getBlankTileCoordinateX() - 1 >= 0){
            int[][] newMatrix = state.getMatrixPuzzle().clone();
            //int[][] newMatrix = swap(state.getMatrixPuzzle(),state.)
            int[] spaceLocation = {state.getBlankTileCoordinateX(), state.getBlankTileCoordinateY()};
            int[] tileLocation = {state.getBlankTileCoordinateX() - 1  , state.getBlankTileCoordinateY()};
            newMatrix = swap(newMatrix, spaceLocation,tileLocation);
            State newState = new State(newMatrix, state);
            newState.setCost(state.getCost() + 1);
            return newState;
        }else{
            return null;
        }
    }

    public static int[][] swap(int[][] puzzle, int[] space, int[] tile){
        puzzle[space[0]][space[1]] = puzzle[tile[0]][tile[1]];
        puzzle[tile[0]][tile[1]] = 0;
        return puzzle;
    }


}

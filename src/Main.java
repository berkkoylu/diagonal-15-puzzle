public class Main {

    public static void main(String[] args) {
        int[][] puzzle;
        int depth = 10;
        puzzle = PuzzleGenerator.generatePuzzle(depth);
        printPuzzle(puzzle);
        System.out.println("-----------");
        State initialState = new State(puzzle);
        Move.up(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.up(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.up(initialState);
        printPuzzle(initialState.getMatrixPuzzle());
        System.out.println("-----------");
        initialState = Move.up(initialState);
        printPuzzle(initialState.getMatrixPuzzle());



    }


    public static void printPuzzle(int[][] puzzle){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ",puzzle[i][j]);
            }
            System.out.println();
        }
    }
}

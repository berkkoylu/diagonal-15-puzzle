public class Main {

    public static void main(String[] args) {
        int[][] puzzle;
        int depth = 2;
        puzzle = PuzzleGenerator.generatePuzzle(depth);
        printPuzzle(puzzle);
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

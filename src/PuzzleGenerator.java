import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuzzleGenerator {

    private static int lastMovedTile = 0;
    private int nextTile = 0;
    static int[][] puzzle = {{1,2,3,4},
                             {12, 13, 14, 5},
                             {11,0,15,6},
                             {10,9,8,7}};


    public static int[][] generatePuzzle(int depth){
        for (int i = 0; i < depth; i++) {
            List<Integer> possibleMoves = findPossibleMove(puzzle);
            Random rand = new Random();
            int randomElement = possibleMoves.get(rand.nextInt(possibleMoves.size()));
            if(lastMovedTile != randomElement){
                makeMove(0,randomElement);
//                System.out.printf("Changed 0 with %d\n", randomElement);
//                printPuzzle();
            }else{
                possibleMoves.remove(possibleMoves.remove(possibleMoves.indexOf(randomElement)));
                int newRandomElement = possibleMoves.get(rand.nextInt(possibleMoves.size()));
                makeMove(0,newRandomElement);
//                System.out.printf("cycle detected %d and finding new element %d \n",randomElement, newRandomElement);
//                printPuzzle();
            }
            lastMovedTile = randomElement;
        }
        return puzzle;
    }

    public static List<Integer> findPossibleMove(int[][] puzzle){
        //arraylist'in içine posssible solutionları kaybedip bu arraylist'i dönecek
        int[] position = findSpace(0);
        List<Integer> adjacent = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(position[0] + i >= 0 && position[1] + j >= 0 && position[0] + i < 4 && position[1] + j < 4){
                    adjacent.add(puzzle[position[0]+i][position[1]+j]);
                }
            }
        }
        return adjacent;
    }

    public static int[] findSpace(int number){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(puzzle[i][j] == number){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {0,0};
    }

    public static void makeMove(int space, int tile){
        int locationSpace[] = findSpace(space);
        int locationTile[] = findSpace(tile);

        puzzle[locationSpace[0]][locationSpace[1]] = tile;
        puzzle[locationTile[0]][locationTile[1]] = 0;

    }

    public static void printPuzzle(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d  ",puzzle[i][j]);
            }
            System.out.println();
        }
    }
}



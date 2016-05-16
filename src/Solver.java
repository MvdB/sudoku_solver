import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MvdB on 16.05.2016.
 */
public class Solver {

    public void solve(Sudoku sudoku) {
        while (!checkFilled(sudoku)) {
            for (int i = 0; i < Sudoku.SIZE; i++) {
                for (int j = 0; j < Sudoku.SIZE; j++) {
                    checkPosition(sudoku, j, i);
                    System.out.println(Arrays.deepToString(sudoku.getField()));
                }
            }
        }
    }

    private boolean checkFilled(Sudoku sudoku) {
        Integer[][] sudokuField = sudoku.getField();
        boolean full = true;
        for (int i = 0; i < sudokuField.length; i++) {
            for (int j = 0; j < sudokuField[i].length; j++) {
                if (sudokuField[i][j] == null) {
                    full = false;
                }
            }
        }
        return full;
    }

    private void checkPosition(Sudoku sudoku, int x, int y) {

        // Prüfen ob an der Koordinate nur eine Zahl möglich ist,
        // wenn  ja, ist diese  Zahl die  Lösung
        ArrayList<Integer> possibles = getPossibles();
        eliminatePossibles(sudoku.getColumn(y), possibles);
        eliminatePossibles(sudoku.getRow(x), possibles);
        eliminatePossibles(concat2DimArray(sudoku.getSquare(x, y)), possibles);
//        System.out.println(possibles);
        if (possibles.size() == 1) {
            sudoku.setDigit(x, y, possibles.get(possibles.size() - 1));
        }

        // komplexere Prüfungen

        // not implemented yet
    }

    private ArrayList<Integer> getPossibles() {
        ArrayList<Integer> possibles = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            possibles.add(i);
        }
        return possibles;
    }

    private void eliminatePossibles(Integer[] array, ArrayList<Integer> possibles) {
        for (int i = 0; i < Sudoku.SIZE; i++) {
            if (possibles.remove(array[i])) {
                //System.out.println(array[i] + " not possible");
            }
        }
    }

    private Integer[] concat2DimArray(Integer[][] array) {
        Integer[] array_1dim = new Integer[Sudoku.SIZE];
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++, x++) {
                array_1dim[x] = array[i][j];
            }
        }
        return array_1dim;
    }
}

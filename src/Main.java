import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        Solver solver = new Solver();
        sudoku.fillExample();

        solver.solve(sudoku);

        System.out.println(Arrays.deepToString(sudoku.getField()));
    }
}

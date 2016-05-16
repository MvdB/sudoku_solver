/**
 * Created by MvdB on 16.05.2016.
 */
public class Sudoku {
    public static final Integer SIZE = 9;
    private Integer[][] field = new Integer[SIZE][SIZE];

    public void setDigit(int x, int y, int digit) {
        if (field[x][y] == null) {
            field[x][y] = digit;
        } else {
            System.out.println("field is already set");
        }
    }

    public Integer[][] getField() {
        return field;
    }

    public Integer[] getRow(Integer y) {
        if (y >= 0 && y < SIZE) {
            return field[y];
        } else {
            System.out.println("max/min coord exceeded");
            return null;
        }
    }

    public Integer[] getColumn(Integer x) {
        if (x >= 0 && x < SIZE) {
            Integer[] column = new Integer[SIZE];
            for (Integer i = 0; i < column.length; i++) {
                column[i] = field[i][x];
            }
            return column;
        } else {
            System.out.println("max/min coord exceeded");
            return null;
        }
    }

    public Integer[][] getSquare(Integer x, Integer y) {
        Integer square_x = x / 3;
        Integer square_y = y / 3;
        Integer[][] square = new Integer[3][3];
        Integer i = 0;
        for (Integer coord_x = square_x * 3; coord_x < (square_x + 1) * 3; coord_x++, i++) {
            Integer j = 0;
            for (Integer coord_y = square_y * 3; coord_y < (square_y + 1) * 3; coord_y++, j++) {
                //System.out.println("x: " + coord_x + " / y: " + coord_y);
                square[i][j] = field[coord_x][coord_y];
            }
        }
        return square;
    }

    /*
        public void fillExample() {
            field = new Integer[][]{{1, null, null, 6, null, null, null, null, null},
                    {null, 2, null, null, null, null, 9, null, null},
                    {null, null, 3, null, null, null, null, null, null},
                    {null, null, null, 4, null, null, null, 1, null},
                    {null, 4, null, null, 5, null, null, null, null},
                    {null, null, null, null, null, 6, null, 9, null},
                    {null, null, 2, null, null, null, 7, null, null},
                    {null, null, null, null, null, null, null, 8, null},
                    {3, null, null, 5, null, null, null, null, 9}};
        }
    */
    public void fillExample() {
        field = new Integer[][]{{8, null, null, null, 4, null, null, null, 2},
                {null, 5, 6, 8, null, 2, 7, 3, null},
                {null, 1, null, null, null, null, null, 4, null},
                {null, null, 1, 5, null, 8, 6, null, null},
                {null, null, null, null, 2, null, null, null, null},
                {null, null, 5, 7, null, 4, 2, null, null},
                {null, 4, null, null, null, null, null, 5, null},
                {null, 3, 9, 6, null, 1, 4, 7, null},
                {5, null, null, null, 8, null, null, null, 9}};
    }
}

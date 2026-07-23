import java.util.*;

public class NQueens {

    public List<List<String>> placeSensors(int n) {

        List<List<String>> result = new ArrayList<>();

        int[] sensorCol = new int[n];

        backtrack(n, 0, sensorCol, result);

        return result;
    }

    private void backtrack(int n, int row, int[] sensorCol, List<List<String>> result) {

        if (row == n) {
            result.add(buildBoard(n, sensorCol));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, sensorCol)) {

                sensorCol[row] = col;

                backtrack(n, row + 1, sensorCol, result);
            }
        }
    }

    private boolean isSafe(int row,
                           int col,
                           int[] sensorCol) {

        for (int r = 0; r < row; r++) {

            if (sensorCol[r] == col)
                return false;

            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row))
                return false;
        }

        return true;
    }

    private List<String> buildBoard(int n, int[] sensorCol) {

        List<String> board = new ArrayList<>();

        for (int r = 0; r < n; r++) {

            char[] row = new char[n];

            Arrays.fill(row, '.');

            row[sensorCol[r]] = 'Q';

            board.add(new String(row));
        }

        return board;
    }

    public static void main(String[] args) {

        NQueens obj = new NQueens();

        List<List<String>> ans = obj.placeSensors(4);

        for (List<String> board : ans) {
            System.out.println();

            for (String row : board) {
                System.out.println(row);
            }
        }
    }
}
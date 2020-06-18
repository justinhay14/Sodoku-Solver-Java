import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solver {
    private int functionCalls;
    private int numSolutions;
    private int grid[][];
    private ArrayList<int[][]> solutions;

    public Solver(int grid[][]) {
        this.grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
        solutions = new ArrayList<int[][]>();
        functionCalls = 1;
        numSolutions = 0;
    }

    public ArrayList<int[][]> getSolutions() {
        return solutions;
    }

    public boolean possible(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            if (grid[y][i] == num)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (grid[i][x] == num)
                return false;
        }
        int x0 = (x / 3) * 3;
        int y0 = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[y0 + i][x0 + j] == num)
                    return false;
            }
        }
        return true;
    }

    public void solve_puzzle() {
        if (numSolutions == 10) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (functionCalls >= 10000) {
                solutions = null;
                return;
            }
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    for (int n = 1; n <= 9; n++) {
                        if (possible(i, j, n)) {
                            grid[i][j] = n;
                            functionCalls++;
                            System.out.println(functionCalls);
                            solve_puzzle();
                            grid[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
        int[][] sol = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sol[i][j] = grid[i][j];
            }
        }
        numSolutions++;
        solutions.add(sol);
    }
}

import java.util.Scanner;

public class Main {
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            System.out.print("[");
            for (int j = 0; j < 8; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(grid[i][8] + "]");
        }
    }
    public static void main(String args[]) {
        int[][] grid = new int[9][9];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        Solver solver = new Solver(grid);
        solver.solve_puzzle();
        for (int[][] sol : solver.getSolutions()) {
            printGrid(sol);
        }
    }
}

import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
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
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setLayout(new BorderLayout());
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Sudoku Solver", SwingConstants.CENTER);
        title.setVisible(true);
        titlePanel.add(title);
        frame.add(titlePanel, BorderLayout.PAGE_START);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9,9));
        frame.setSize(450,450);
        JPanel [][]GridGUI = new JPanel[9][9];
        for (int i = 0 ; i < GridGUI.length; i++) {
            for (int j = 0; j < GridGUI[i].length; j++) {
                GridGUI[i][j] = new JPanel();
                Border b = BorderFactory.createLineBorder(Color.BLACK);
                GridGUI[i][j].setBorder(b);
                JTextField jt = new JTextField(2);
                jt.setVisible(true);
                GridGUI[i][j].add(jt);
                mainPanel.add(GridGUI[i][j]);
                GridGUI[i][j].setVisible(true);
            }
        }
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setVisible(true);
        JPanel bottomPanel = new JPanel();
        JButton calculateButton = new JButton("CALCULATE");
        calculateButton.setVisible(true);
        bottomPanel.add(calculateButton);
        bottomPanel.setVisible(true);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
        frame.setVisible(true);
        int[][] grid = new int[9][9];
        /*Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        Solver solver = new Solver(grid);
        solver.solve_puzzle();
        for (int[][] sol : solver.getSolutions()) {
            printGrid(sol);
        }*/
    }
}

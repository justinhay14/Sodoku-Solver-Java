import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Main {
    public static boolean baseMode = true;
    public static int[][] grid = new int[9][9];
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
        JTextField jt[][] = new JTextField[9][9];
        for (int i = 0 ; i < GridGUI.length; i++) {
            for (int j = 0; j < GridGUI[i].length; j++) {
                GridGUI[i][j] = new JPanel();
                Border b = BorderFactory.createLineBorder(Color.BLACK);
                GridGUI[i][j].setBorder(b);
                jt[i][j] = new JTextField(2);
                jt[i][j].setVisible(true);
                GridGUI[i][j].add(jt[i][j]);
                mainPanel.add(GridGUI[i][j]);
                GridGUI[i][j].setVisible(true);
            }
        }
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setVisible(true);
        JPanel bottomPanel = new JPanel();
        JButton clearButton = new JButton("Clear");
        JButton calculateButton = new JButton("CALCULATE");
        clearButton.setVisible(true);
        calculateButton.setVisible(true);
        bottomPanel.add(clearButton);
        bottomPanel.add(calculateButton);
        bottomPanel.setVisible(true);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
        frame.setVisible(true);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        jt[i][j].setText("");
                    }
                }
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (baseMode) {
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (jt[i][j].getText().equals("")) {
                                grid[i][j] = 0;
                                continue;
                            }
                            int num = -1;
                            try {
                                num = Integer.parseInt(jt[i][j].getText());
                            } catch (IndexOutOfBoundsException e) {
                                title.setText("Error! Invalid Number in row " + (i + 1) + " column " + (j + 1));
                                title.setForeground(Color.RED);
                                continue;
                            }
                            if (num < 0 || num > 9) {
                                title.setText("Error! Invalid Number in row " + (i + 1) + " column " + (j + 1));
                                title.setForeground(Color.RED);
                                continue;
                            }
                            grid[i][j] = num;
                        }
                    }
                    baseMode = false;
                }

            }
        });

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

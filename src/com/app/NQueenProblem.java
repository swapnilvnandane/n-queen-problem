package com.app;

/**
 * N-Queen-Problem class to solve the N-Queen problem.
 *
 * **/
public class NQueenProblem {
    private static int N;

    /**
     * Constructor to initialize the N-Queen problem with the given size.
     * @param n The size of the chess board.
     *          The board will be of size n x n.
     * */
    public NQueenProblem(int n) {
        this.N = n;
    }

    /**
     * Function to print solution to N-Queen problem.
     * @param board The board with the final solution.
     * **/
    private static void print(int[][] board) {
        for (int[] row : board) {
            for (int j : row) {
                System.out.print(" " + j + " ");
            }
            System.out.println();
        }
    }

    /**
     * Function to check if a queen can be placed at the given position.
     * @param board The board to check if the queen can be placed.
     * @param row The row to check if the queen can be placed.
     * @param column The column to check if the queen can be placed.
     * @return {@link Boolean} True if the queen can be placed, False otherwise.
     * **/
    private static boolean isQueenSafePlace(int[][] board, int row, int column) {

        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = column; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Recursive function to solve the N-Queen problem.
     * @param board The board to solve the N-Queen problem.
     * @param column The column to solve the N-Queen problem.
     * @return {@link Boolean} True if the N-Queen problem is solved, False otherwise.
     * */
    private static boolean solveNQueen(int[][] board, int column) {

        if(column >= N) {
            return true;
        }

        for(int i = 0; i < N; i++) {
            if (isQueenSafePlace(board, i, column)) {
                board[i][column] = 1;

                if(solveNQueen(board, column + 1)) {
                    return true;
                }

                board[i][column] = 0;
            }
        }
        return false;
    }

    /**
     * Solve the N-Queen problem.
     * */
    public void solve() {
        int[][] board = new int[N][N];

        if(!solveNQueen(board, 0)) {
            System.out.println("Solution not present!!");
        } else {
            print(board);
        }
    }
}

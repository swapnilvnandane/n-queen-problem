import com.app.NQueenProblem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the size of the board (N X N): ");
        Scanner scanner = new Scanner(System.in);
        NQueenProblem nq = new NQueenProblem(scanner.nextInt());
        nq.solve();
    }
}
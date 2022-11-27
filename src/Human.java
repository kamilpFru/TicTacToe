import java.util.Scanner;

public class Human {
    int field = -1;
    public void makeMove(Board board, Scanner scanner) {
        System.out.print("Your move (1-9): ");
        String response = scanner.next();

        try {
            field = Integer.parseInt(response);
        } catch (NumberFormatException e) {
            System.out.println("Wrong format, try again");
            makeMove(board, scanner);
            return;
        }

        if (field > 9 || field < 1) {
            System.out.println("Wrong value, try again");
            makeMove(board, scanner);
        } else if (board.isTaken(field - 1)) {
            System.out.println("Already taken, try again");
            makeMove(board, scanner);
        } else {
            board.makeMove(field - 1, 'x');
        }
    }
}

import java.util.Scanner;

public class TicTacToe {

    private int playerScore;
    private int computerScore;
    
    Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        playerScore = 0;
        computerScore = 0;
        startGame();
    }

    public void startGame() {

        Board board = new Board();
        Human player = new Human();
        Computer opponent = new Computer();
        board.printBoard(board.helpingBoard);

        while (!board.isFull()) {
            player.makeMove(board, scanner);
            opponent.makeMove(board);
            if (board.hasWon() == 'x') {
                System.out.println("Player wins!");
                playerScore++;
                System.out.println("You " + playerScore + " : " + computerScore + " Computer");
                playAgain();
                break;
            } else if (board.hasWon() == 'o') {
                System.out.println("Computer wins :c");
                computerScore++;
                System.out.println("You " + playerScore + " : " + computerScore + " Computer");
                playAgain();
                break;
            }
            if (board.isFull()) {
                System.out.println("Draw!");
                System.out.println("You " + playerScore + " : " + computerScore + " Computer");
                playAgain();
            }

        }
    }

    private void playAgain() {
        System.out.print("Would You like to play again? (y/n) ");
        String response = scanner.next();
        if (response.equals("y")) {
            startGame();
        } else {
            System.out.println("Bye");
            scanner.close();
        }
    }
}

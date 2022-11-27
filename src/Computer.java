import java.util.Random;

public class Computer {
    public void makeMove(Board board) {
        Random rand = new Random();
        int field = rand.nextInt(9) ;
        if (!board.isTaken(field)) {
            System.out.printf("Computer move: %d%n", field + 1);
            board.makeMove(field, 'o');
        } else if (!board.isFull()){
            makeMove(board);
        }
    }
}

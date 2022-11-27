public class Board {

    private final char[][] board = {{' ', ' ', ' '},
                                    {' ', ' ', ' '},
                                    {' ', ' ', ' '}};

    public final char[][] helpingBoard = {{'1', '2', '3'},
                                           {'4', '5', '6'},
                                           {'7', '8', '9'}};


    public boolean isTaken(int x) {
        return !(getField(x) == ' ');
    }

    public char hasWon() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') return 'x';
            if (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o') return 'o';

            if (board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x') return 'x';
            if (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o') return 'o';
        }
        if (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') return 'x';
        if (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') return 'o';

        if (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') return 'x';
        if (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') return 'o';

        return ' ';
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public char getField(int x) {
        if (x < 3) {
            return board[0][x % 3];
        } else if (x < 6) {
            return board[1][x % 3];
        } else if (x < 9) {
            return board[2][x % 3];
        } else {
            return ' ';
        }
    }

    public void printBoard(char[][] board) {
        for (int i = 0;; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i == 2) break;
            System.out.println(" -------");
        }
        System.out.println();
    }

    public void makeMove(int x, char player) {
        if (x < 3) {
            board[0][x % 3] = player;
        } else if (x < 6) {
            board[1][x % 3] = player;
        } else if (x < 9) {
            board[2][x % 3] = player;
        }
        printBoard(board);
    }
}
